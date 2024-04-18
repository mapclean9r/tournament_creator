import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StartTournament {

    private Tournament currentTournament;
    private int teamsLeft = 0;
    private List<Contender> allTeams = new ArrayList<>();
    private List<Contender> vs = new ArrayList<>();
    private Contender contenderRoundWinner;
    Contender[][] bracket = new Contender[2][100];

    public StartTournament(Tournament tournament){
        currentTournament = tournament;
        UpdateTeamsData();
    }

    private void BuildBrackets(){
        CreateVersus();
    }

    private void UpdateTeamsData(){
        allTeams.clear();
        for (Contender i: currentTournament.getTeams()) {
            teamsLeft++;
            allTeams.add(i);
        }
    }

    private int generateNumber(){
        Random r = new Random();
        int num = r.nextInt(allTeams.size());
        //kan fjerne forloop, kanskje jeg får bruk for den senere
        for (int i = 0; i < 1; i++){
            if (vs.size() == 0) {
                return num;
            }
            if (vs.get(i) != allTeams.get(num) && allTeams.get(num).isAvailable()){
                return num;
            }
        }
        return generateNumber();
    }

    private void CreateVersus(){
        for (int i = 0; i < 2; i++){
            for (int k = 0; k < 2; k++){
                bracket[k][i] = allTeams.get(generateNumber());
                vs.add(bracket[k][i]);
                bracket[k][i].setAvailable(false);
            }
        }
        for (int l = 0; l < 2; l++){
            int round = 1+l;
            System.out.print("Bracket "+round+": [  ");
            for (int u = 0; u < 2; u++){
                System.out.print(bracket[l][u].getName() + "  ");
            }
            System.out.print("]");
            System.out.println("\n");
        }
    }

    /*
    private void CreateVersus(){
        vs.clear();
        int randomGen1 = generateNumber();
        while (vs.size() != 2){
            if (vs.size() == 0){
                vs.add(allTeams.get(randomGen1));
            }

            for (Contender i: allTeams) {
                int randomGEN2 = generateNumber();
                if (vs.size() == 2){
                    return;
                }
                if (i.isNotKnockedOut() && i != vs.get(0) && randomGen1 != randomGEN2){
                    vs.add(allTeams.get(randomGEN2));
                }
            }
        }
    }
     */

    private void knockOut(Contender contender){
        contender.setNotKnockedOut(false);
    }

    private void setContenderRoundWinner(Contender contender){
        contenderRoundWinner = contender;
    }

    public void Run(int bestOf) throws InterruptedException {
        System.out.println(currentTournament.getTournamentName() + " is about to commence...");
        BuildBrackets();
        TimeUnit.SECONDS.sleep(1);


        while (teamsLeft != 1){
            for (int i = 0; i < vs.size(); i++){
                System.out.println(i +" "+ vs.get(i).getName());
            }
            teamsLeft = 1;
        }

    }
}
