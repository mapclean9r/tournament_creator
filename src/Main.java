public class Main {
    public static void main(String[] args) throws InterruptedException {

        Contender team1 = new Contender("The Pepes");
        Contender team2 = new Contender("Big Rock");
        Contender team3 = new Contender("Fell Blocks");
        Contender team4 = new Contender("p2w group");
        Contender team5 = new Contender("team5");
        Contender team6 = new Contender("team6");
        Contender team7 = new Contender("team7");
        Contender team8 = new Contender("team8");
        Contender team9 = new Contender("team9");
        Contender team10 = new Contender("team10");
        Contender team11 = new Contender("team11");
        Contender team12 = new Contender("team12");
        Contender team13 = new Contender("team13");
        Contender team14 = new Contender("team14");
        Contender team15 = new Contender("team15");
        Contender team16 = new Contender("team16");

        Tournament league = new Tournament("Super Duper League");
        league.AddContender(team1);
        league.AddContender(team2);
        league.AddContender(team3);
        league.AddContender(team4);
        league.AddContender(team5);
        league.AddContender(team6);
        league.AddContender(team7);
        league.AddContender(team8);
        league.AddContender(team9);
        league.AddContender(team10);
        league.AddContender(team11);
        league.AddContender(team12);
        league.AddContender(team13);
        league.AddContender(team14);
        league.AddContender(team15);
        league.AddContender(team16);

        StartTournament start = new StartTournament(league);

        start.Run(3);

    }
}