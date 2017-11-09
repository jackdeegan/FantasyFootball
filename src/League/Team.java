package League;

import java.util.ArrayList;
import Model.Player;

public class Team extends TeamComponent{
	
	//Contains teams/league that are added to the ArrayList

	private String user;
	public int points;
	ArrayList <Player> players  = new ArrayList<Player>();
	
	public Team(String newUser, ArrayList <Player> newPlayers) {
		user = newUser;
		players = newPlayers;	
	}
	
	public String getTeamUser() {return user;}
	public ArrayList <Player> getPlayers() {return players;}
	
	public void updatePoints(int latestPoints) {
		points += latestPoints;
	}
	  
    public String displayTeamInfo(){
    	String info = "";

    	        info = getTeamUser() + " " + getPoints() + "\n";
    	        return info;
    }


}
