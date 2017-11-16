package League;
import View.ViewLeague;
public class LeagueOriginator {
	
	TeamComponent leagueTemp;
	
	public void set(TeamComponent newLeague) {
		System.out.println("From Originator: Current league standings\n");
		 ViewLeague.league.displayTeamInfo();
		
		leagueTemp = newLeague;
	}
	
	public LeagueMemento storeInMemento() {
		
		System.out.println("From Originator: Saving to Memento");
		
		return new LeagueMemento(leagueTemp);
	}
	
	public TeamComponent restoreFromMemento(LeagueMemento memento) {
		leagueTemp = memento.getSavedLeague();
		
		System.out.println("From Originator: Previous Article Saved in Memento\n");
		return leagueTemp;
	}

}