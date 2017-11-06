package League;

import java.util.ArrayList;

public class LeagueMemento {
	
	TeamComponent league;
	
	 public LeagueMemento(TeamComponent leagueTemp){
		 league = leagueTemp;
		 }
	 public TeamComponent getSavedLeague(){
		 return league;
		 }
	 


}
