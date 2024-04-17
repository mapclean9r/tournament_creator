import java.util.ArrayList;
import java.util.List;

public class Contender {

    private String name;
    private String description;
    private final List<Person> teamMembers = new ArrayList<>();
    private boolean isNotKnockedOut = true;
    public Contender(String teamName){
        name = teamName;
    }

    public void addTeamMember(Person person){
        teamMembers.add(person);
    }


    //Getter, Setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNotKnockedOut() {
        return isNotKnockedOut;
    }

    public void setNotKnockedOut(boolean notKnockedOut) {
        isNotKnockedOut = notKnockedOut;
    }

    public List<Person> getTeamMembers() {
        return teamMembers;
    }

}
