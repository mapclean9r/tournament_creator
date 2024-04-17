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
    public StartTournament(Tournament tournament){
        currentTournament = tournament;
    }

    private void BuildBrackets(){
        allTeams.clear();
        for (Contender i: currentTournament.getTeams()) {
            teamsLeft++;
            allTeams.add(i);
        }
            CreateVersus();
    }

    private int generateNumber(){
        Random r = new Random();
        return r.nextInt(allTeams.size());
    }

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
