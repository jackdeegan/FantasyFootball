package League;
import java.util.ArrayList;
import View.ViewLeague;
public class LeagueCaretaker {
	
	ArrayList<LeagueMemento> savedLeagues = new ArrayList<LeagueMemento>();
	
	public void addMemento(LeagueMemento m) {
		savedLeagues.add(m);
	}
	public LeagueMemento getLeagueMemento(int index) {
		return savedLeagues.get(index);
	}
}