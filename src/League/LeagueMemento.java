package League;

public class LeagueMemento {
	
	TeamComponent leagueState;
	
	 public LeagueMemento(TeamComponent leagueSave){
		 leagueState = leagueSave;
		 }
	 public TeamComponent getSavedLeague(){
		 return leagueState;
		 }
}
