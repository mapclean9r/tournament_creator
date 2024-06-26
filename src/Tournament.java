import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private String tournamentName;
    private List<Contender> team = new ArrayList<>();

    public Tournament(String name){
        tournamentName = name;
    }

    public void AddContender(Contender contender){
        team.add(contender);
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public List<Contender> getTeams() {
        return team;
    }

    public int getAmountTeams() {
        return team.size();
    }
}
