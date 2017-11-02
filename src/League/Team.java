package League;
<<<<<<< Upstream, based on origin/master
import Model.Player;
import java.util.ArrayList;
import java.util.Iterator;

public class Team extends TeamComponent{
	
	//Contains teams/league that are added to the ArrayList
	
	ArrayList TeamComponents = new ArrayList();

	private String user;
	private String name;
	private int position;
	private int gamesPlayed;
	private int win;
	private int loss;
	private int points;
	ArrayList <Player> players  = new ArrayList<Player>();
=======

import java.util.ArrayList;
import java.util.Iterator;

import Model.Player;

public class Team extends TeamComponent{
	
	//Contains teams/league that are added to the ArrayList

	private String user;
	private int position;
	private int gamesPlayed;
	private int win;
	private int loss;
	private int points;
	ArrayList <Player> players  = new ArrayList<Player>();
	
	public Team(String newUser,int newPosition,int newGamesPlayed, int newWin,int newLoss,int newPoints) {
		user = newUser;
		position = newPosition;
		gamesPlayed = newGamesPlayed;
		win = newWin;
		loss = newLoss;
		points = newPoints;
	
	}
	
	public String getTeamUser() {return user;}
	public int getPosition() {return position;}
	public int getGamesPlayed() {return gamesPlayed;}
	public int getWins() {return win;} 
	public int getLoss() {return loss;}
	public int getPoints() {return points;}
	
	public void updatePoints() {
		
	}
	  
    public void displayTeamInfo(){

    	        System.out.println(getTeamUser() + " " + getPosition() + " " + getGamesPlayed() +
    	        		" " + getWins() + " " + getLoss() + " " + getPoints());
    }


>>>>>>> f96ce45 League update
}
