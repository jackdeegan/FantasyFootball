package League;

public class LeagueMemento {
	
	TeamComponent leagueState = new LeaguePublic("Public League");
	
	 public LeagueMemento(TeamComponent leagueSave){
		 leagueState = leagueSave;
		 }
	 public TeamComponent getSavedLeague(){
		 return leagueState;
		 }
}
