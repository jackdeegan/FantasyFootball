package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import DAL.AccessTeams;
import DAL.AccessPlayers;
import DAL.DatabaseService;

public class Team {
	
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
        	if (i == 0 && pos.equals("G"))
        		g++;
        	else if (i >= 0 && i < 5 && pos.equals("D"))
        		d++;
        	else if (i > 4 && i < 9 && pos.equals("M"))
        		m++;
        	else if (i > 8 && i < 11 && pos.equals("F"))
        		f++;
        	else
        		return "Invalid Team, Please Clear Selections and Try Again!";
        }
        
        if (g == 1 && d == 4 && m == 4 && f == 2)
        	validTeam = true;
        
        if (validTeam == false) {
        	return "Invalid Team, Please Clear Selections and Try Again!";
        }
        else {
        	teamsDB.addData(teamSelection);
        	return "Team Created Successfully!";
        }
    }
	
	private String username;
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String[] getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(String[] player_id) {
		this.player_id = player_id;
	}
	private String[] player_id;
}
	