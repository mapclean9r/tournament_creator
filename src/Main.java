public class Main {
    public static void main(String[] args) {

        Person igor = new Person("Igor");
        Person karl = new Person("Karl");

        Contender team1 = new Contender("The Pepes");

        team1.addTeamMember(karl);
        team1.addTeamMember(igor);

        for (int i = 0; i < team1.getTeamMembers().size(); i++){
            System.out.println(team1.getTeamMembers().get(i).getName());
        }

        System.out.println();


    }
}