import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StartTournament {

    private final Tournament currentTournament;
    private int teamsLeft = 0;
    private final List<Contender> allTeams = new ArrayList<>();
    private final List<Contender> vs = new ArrayList<>();
    private Contender contenderWinner;
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

    private String scanInput(int bracketNr){
        Contender tmp1 = bracket[bracketNr][0];
        Contender tmp2 = bracket[bracketNr][1];

        Scanner myObj = new Scanner(System.in);

        System.out.println("1. Select round winner: " + tmp1.getName());
        System.out.println("2. Select round winner: " + tmp2.getName());
        System.out.println("3. quit\n");

        return myObj.nextLine();
    }

    private void boText(int bo){
        System.out.println("" +
                "\n-----------------------" +
                "\n----------BO"+bo+"----------" +
                "\n-----------------------" +
                "\n");
    }

    public void Run(int bestOf) throws InterruptedException {
        System.out.println(currentTournament.getTournamentName() + " is about to commence...\n");
        BuildBrackets();
        TimeUnit.SECONDS.sleep(1);

        int bracketNum = 0;

        while (teamsLeft != 1){
            boText(bestOf);
            System.out.println(scanInput(bracketNum));

            teamsLeft = 1;
        }

    }
}
