package League;
import java.util.ArrayList;
import java.util.Iterator;

import Model.Player;
import DAL.AccessTeams;


public class Fixtures extends TeamComponent{
	
	
	protected LeaguePublic league = new LeaguePublic("League");
	//test
	public Fixtures() {
		createNewStandings(league);
	}

	public TeamComponent getTeamList(){
		return league;
	}
	
	//runs current leaderboard against fixtures played	
	public void createNewStandings(TeamComponent teamList) {
		int numberOfTeams;
		String [] teamLine;
		
		AccessTeams accessTeam = new AccessTeams();
		numberOfTeams = accessTeam.getData().size();	
		for(int i = 0; i<numberOfTeams; i++) {
			teamLine = accessTeam.getRowData(i);
			for(int j = 1; j<teamLine.length - 1; j++) {				
				updatePoints(Integer.parseInt(teamLine[j]),numberOfTeams,league);//goes and looks up player in played fixtures 
			}		
		}
	}	
	
	public void updatePoints(int playerID,int numTeams,LeaguePublic league) {
		
        for(int i = 0; i<numTeams; i++) {
        	league.getComponent(i);
        }
	}


}