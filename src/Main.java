public class Main {
    public static void main(String[] args) throws InterruptedException {

        Person igor = new Person("Igor");
        Person karl = new Person("Karl");
        Person bud = new Person("Buddy");
        Person man = new Person("Man Dude");

        Contender team1 = new Contender("The Pepes");
        Contender team2 = new Contender("Big Rock");
        Contender team3 = new Contender("Fell Blocks");
        Contender team4 = new Contender("p2w group");
        Contender team5 = new Contender("team5");
        Contender team6 = new Contender("team6");
        Contender team7 = new Contender("team7");
        Contender team8 = new Contender("team8");

        team1.addTeamMember(karl);
        team2.addTeamMember(igor);
        team3.addTeamMember(bud);
        team4.addTeamMember(man);
        team5.addTeamMember(man);
        team6.addTeamMember(man);
        team7.addTeamMember(man);
        team8.addTeamMember(man);

        Tournament league = new Tournament("Super Duper League");
        league.AddContender(team1);
        league.AddContender(team2);
        league.AddContender(team3);
        league.AddContender(team4);
        league.AddContender(team5);
        league.AddContender(team6);
        league.AddContender(team7);
        league.AddContender(team8);

        StartTournament start = new StartTournament(league);

        start.Run(3);

    }
}