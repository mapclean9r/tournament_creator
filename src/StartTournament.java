import java.util.*;
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
        PrintBracket();
    }

    private void UpdateTeamsData(){
        allTeams.clear();
        for (Contender i: currentTournament.getTeams()) {
            teamsLeft++;
            allTeams.add(i);
        }
    }

    private int GenerateNumber(){
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
        return GenerateNumber();
    }

    private void CreateVersus() {
        for (int i = 0; i < teamsLeft/2; i++){
            for (int k = 0; k < 2; k++){
                bracket[i][k] = allTeams.get(GenerateNumber());
                vs.add(bracket[i][k]);
                bracket[i][k].setAvailable(false);
            }
        }
    }

    private void PrintBracket() throws InterruptedException{
        for (int l = 0; l < teamsLeft/2; l++){
            int round = 1+l;
            if (l == teamsLeft/2 /2){
                System.out.println("\n\n----------------------------------------------------------");
            }
            System.out.printf("%-5s","\nBracket "+round+": [        ");
            for (int u = 0; u < 2; u++){
                System.out.printf("%-15s",bracket[l][u].getName() + "  ");
            }
            System.out.printf("%-5s ", "]-------");

            TimeUnit.SECONDS.sleep(1);
        }
    }

    private String ScanInput(int bracketNr){
        Contender tmp1 = bracket[bracketNr][0];
        Contender tmp2 = bracket[bracketNr][1];

        Scanner myObj = new Scanner(System.in);

        System.out.println("1. Select round winner: " + tmp1.getName());
        System.out.println("2. Select round winner: " + tmp2.getName());
        System.out.println("3. quit\n");

        if (Objects.equals(myObj.next(), "1")){
            System.out.println(tmp1.getName());
            return tmp1.getName();
        }
        if (Objects.equals(myObj.next(), "2")){
            System.out.println(tmp2.getName());
            return tmp2.getName();
        }
        return "quit";
    }

    private void BoText(int bo){
        System.out.println("" +
                "\n----------------------------------------------------------" +
                "\n---------------------------BO"+bo+"----------------------------" +
                "\n----------------------------------------------------------");
    }

    private void Battle(int rounds){
        while (rounds != 0){

            rounds--;
        }
    }

    public void Run(int bestOf) throws InterruptedException {
        int bracketNum = 0;

        System.out.println(currentTournament.getTournamentName() + " is about to commence...\n");
        BoText(bestOf);
        BuildBrackets();
        System.out.println("\n\n----------------------------------------------------------");
        TimeUnit.SECONDS.sleep(1);

        while (teamsLeft != 1){

            //String x = ScanInput(bracketNum);
            //if (Objects.equals(x, "quit")){
            //    return;
            //}
            teamsLeft = 1;
        }
    }
}
