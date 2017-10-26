package League;

import java.util.ArrayList;

public class LeagueMemento {
	
	ArrayList<Team> league = new ArrayList<Team>();
	
	 public LeagueMemento(ArrayList<Team> leagueSave){
		 league = leagueSave;
		 }
	 public ArrayList<Team> getSavedLeague(){
		 return league;
		 }
	 


}
