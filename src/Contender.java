import java.util.ArrayList;
import java.util.List;

public class Contender {

    private static String name;
    private static String description;
    private final List<Person> teamMembers = new ArrayList<>();
    public Contender(String teamName){
        name = teamName;
    }

    public void addTeamMember(Person person){
        teamMembers.add(person);
    }


    //Getter, Setter
    public static String getContenderName() {
        return name;
    }

    public static void setContenderName(String name) {
        Contender.name = name;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Contender.description = description;
    }

    public List<Person> getTeamMembers() {
        return teamMembers;
    }

}
