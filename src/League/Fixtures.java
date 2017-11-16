package League;

import java.util.ArrayList;
 import View.ViewLeague;
 import DAL.AccessFixtures;
 import DAL.AccessPlayers;
 import DAL.AccessTeams;
 
 
 public class Fixtures extends TeamComponent{
 	
	public TeamComponent league;

	public Fixtures(TeamComponent newLeagueValues) {
		league = newLeagueValues;
 		createNewStandings(league);
		ViewLeague.GameWeeks++;

		
 	}
 
 	public void getTeamList(){
 		league.displayTeamInfo();
 	}
 	

	//runs current leaderboard against fixtures played and updates teams points from players who have played and gained points	
	public void createNewStandings(TeamComponent league) {
 		int numberOfTeams;
 		String [] teamLine;
 		AccessTeams accessTeam = new AccessTeams();
 		numberOfTeams = accessTeam.getData().size();
 		
 		for(int i = 1; i<numberOfTeams; i++) 
 		{
 			teamLine = accessTeam.getRowData(i);
			for(int j = 2; j < teamLine.length; j++)
			{
 				updatePoints(Integer.parseInt(teamLine[j]),numberOfTeams,league);//goes and looks up player in played fixtures
			}
 		}					
 	}

	public void updatePoints(int playerID,int numTeams,TeamComponent league) {
		Team team;
		int Points = 0;//Start,Finish;
		String [] teamName;
		String [] teamFixtureName;
		ArrayList<String> FixtureTeams = new ArrayList<String>();
		AccessPlayers players = new AccessPlayers();
		AccessFixtures fixtures = new AccessFixtures();
		
		for(int j = 1; j < 11; j++) //gets team name strings who have played eg. MUN and adds to arraylist
		{
			teamFixtureName = fixtures.getRowData(j);
			FixtureTeams.add(teamFixtureName[1]);
			FixtureTeams.add(teamFixtureName[2]);
		}
		
         for(int i = 0; i<numTeams; i++) //runs through current leaderboard and updates teams points based on individual players
         {        	
        	teamName = players.getRowData(playerID);
        	if(FixtureTeams.contains(teamName[5]))
        	{
        	team = (Team) league.getComponent(i);
        	Points += Integer.parseInt(teamName[6]);
        	team.updatePoints(Points);
        	Points = 0;
         	}
        	
         }
 	}
 }