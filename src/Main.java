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

        team1.addTeamMember(karl);
        team2.addTeamMember(igor);
        team3.addTeamMember(bud);
        team4.addTeamMember(man);

        Tournament league = new Tournament("Super Duper League");
        league.AddContender(team1);
        league.AddContender(team2);
        league.AddContender(team3);
        league.AddContender(team4);

        StartTournament start = new StartTournament(league);

        start.Run(3);

    }
}