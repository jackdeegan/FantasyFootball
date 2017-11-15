package Model;

import java.util.ArrayList;
import java.util.Iterator;

import DAL.AccessTeams;
import DAL.AccessPlayers;
import DAL.DatabaseService;

public class Team extends PlayerComponent {
	
	private static DatabaseService teamsDB = new AccessTeams();
	private static DatabaseService playersDB = new AccessPlayers();
	
	public static String checkTeam(String createdTeam) {
		
		String teamSelection = createdTeam;
		createdTeam = createdTeam.substring(createdTeam.indexOf(",") + 1);
		String regex = "[0-9, /,]+";
		if (!(createdTeam.matches(regex)) || (createdTeam.length() < 1))
			return "Invalid Team, Please Clear Selections and Try Again!";
		
		boolean validTeam = false;
        String pos = "";
        int g = 0;
        int d = 0;
        int m = 0;
        int f = 0;
        String[] team = createdTeam.split(",");
        for (int i = 0; i < team.length; i++) {
        	pos = playersDB.verifyData(team[i]);
        	if ((i == 0 || i == 11) && pos.equals("G"))
        		g++;
        	else if ((i >= 0 && i < 5 || i == 12)  && pos.equals("D"))
        		d++;
        	else if ((i > 4 && i < 9 || i == 13) && pos.equals("M"))
        		m++;
        	else if ((i > 8 && i < 11 || i == 14) && pos.equals("F"))
        		f++;
        	else
        		return "Invalid Team, Please Clear Selections and Try Again!";
        }
        
        if (g == 2 && d == 5 && m == 5 && f == 3)
        	validTeam = true;
        
        if (validTeam == false) {
        	return "Invalid Team, Please Clear Selections and Try Again!";
        }
        else {
        	teamsDB.addData(teamSelection);
        	return "Team Created Successfully!";
        }
    }
	
	ArrayList playerComponents = new ArrayList();
	
	String teamName; //username
	
	public Team(String newTeamName) {
		teamName = newTeamName;
	}
	
	public String getTeamName() {return teamName;}

	public void add(PlayerComponent newPlayerComponent) {
		playerComponents.add(newPlayerComponent);
	}
	
	public void remove(PlayerComponent newPlayerComponent) {
		playerComponents.remove(newPlayerComponent);
	}
	
	public PlayerComponent getComponent(int componentIndex) {
		return (PlayerComponent)playerComponents.get(componentIndex);
	}
	
	public String displayPlayerInfo() {		
		System.out.println(getTeamName());
	
		Iterator playerIterator = playerComponents.iterator();
		
		while(playerIterator.hasNext()) {
			PlayerComponent playerInfo = (PlayerComponent) playerIterator.next();
			playerInfo.displayPlayerInfo();
		}
		return (getTeamName());
	}
	
}
	