package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.InputMismatchException;
import java.util.List;
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
        	pos = playersDB.verifyData(Integer.parseInt(team[i]));
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
	
	/*private String username;
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	private String[] player_id;
	public String[] getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(String[] player_id) {
		this.player_id = player_id;
	}*/
	
	ArrayList playerComponents = new ArrayList();
	
	String teamName; //username
	String teamDescription; //playerIDS
	
	public Team(String newTeamName, String newTeamDescription) {
		teamName = newTeamName;
		teamDescription = newTeamDescription;
	}
	
	public String getTeamName() {return teamName;}
	
	public String getTeamDescription() {return teamDescription;}
	
	public void add(PlayerComponent newPlayerComponent) {
		playerComponents.add(newPlayerComponent);
	}
	
	public void remove(PlayerComponent newPlayerComponent) {
		playerComponents.add(newPlayerComponent);
	}
	
	public PlayerComponent getPlayerComponent(int componentIndex) {
		return (PlayerComponent)playerComponents.get(componentIndex);
	}
	
	public String displayPlayerInfo() {		
		Iterator playerIterator = playerComponents.iterator();
		
		while(playerIterator.hasNext()) {
			PlayerComponent playerInfo = (PlayerComponent) playerIterator.next();
			playerInfo.displayPlayerInfo();
		}
		return (getTeamName() +getTeamDescription());
	}
	
}
	