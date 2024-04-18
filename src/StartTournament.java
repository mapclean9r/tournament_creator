import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StartTournament {

    private final Tournament currentTournament;
    private int teamsLeft = 0;
    private final List<Contender> allTeams = new ArrayList<>();
    private final List<Contender> vs = new ArrayList<>();
    private Contender contenderRoundWinner;
    Contender[][] bracket = new Contender[1000][2];

    public StartTournament(Tournament tournament){
        currentTournament = tournament;
        UpdateTeamsData();
    }

    private void BuildBrackets() throws InterruptedException {
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
        if (vs.size() == 0) {
            return num;
        }
        for (Contender v : vs) {
            if (v != allTeams.get(num) && allTeams.get(num).isAvailable()) {
                return num;
            }
        }
        return generateNumber();
    }

    private void CreateVersus() throws InterruptedException {
        for (int i = 0; i < teamsLeft/2; i++){
            for (int k = 0; k < 2; k++){
                bracket[i][k] = allTeams.get(generateNumber());
                vs.add(bracket[i][k]);
                bracket[i][k].setAvailable(false);
            }
        }
        for (int l = 0; l < teamsLeft/2; l++){
            int round = 1+l;
            System.out.print("Bracket "+round+": [  ");
            for (int u = 0; u < 2; u++){
                System.out.print(bracket[l][u].getName() + "  ");
            }
            System.out.print("]\n");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void Run(int bestOf) throws InterruptedException {
        System.out.println(currentTournament.getTournamentName() + " is about to commence...\n");
        BuildBrackets();
        TimeUnit.SECONDS.sleep(1);


        while (teamsLeft != 1){
            System.out.println();
            /*
            for (int i = 0; i < vs.size(); i++){
                System.out.println(i +" "+ vs.get(i).getName());
            }
            */
            teamsLeft = 1;
        }

    }
}
