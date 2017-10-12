package Model;

import java.util.ArrayList;
import java.util.List;


public class Player {
	
	private int player_id;
	private String player_name;
	private String player_availability;
	private int player_points;
	private List<Player> goalies;
	private List<Player> defenders;
	private List<Player> midfielders;
	private List<Player> attackers;

	public Player(int player_id, String player_name, String player_availability, int player_points){
		this.player_name = player_name;
	    this.player_id = player_id;
	    this.player_availability = player_availability;
	    this.player_points = player_points;
	    goalies = new ArrayList<Player>();
	    defenders = new ArrayList<Player>();
	    midfielders = new ArrayList<Player>();
	    attackers = new ArrayList<Player>();
	}
	
	//goalies
	public void addGoalie(Player p) {
	      goalies.add(p);
	   }

	   public void removeGoalie(Player p) {
	      goalies.remove(p);
	   }

	   public List<Player> getGoalies(){
	     return goalies;
	   }

	public String goaliesToString(){
	      return ("Goalies :[ Name : " + player_name + ", Availability : " + player_availability + ", Points :" + player_points+" ]");
	   }   
	
	//defenders
	public void addDef(Player p) {
	      defenders.add(p);
	   }

	   public void removeDef(Player p) {
		   defenders.remove(p);
	   }

	   public List<Player> getDefenders(){
	     return defenders;
	   }
	   
	public String defendersToString(){
	      return ("Defenders :[ Name : " + player_name + ", Availability : " + player_availability + ", Points :" + player_points+" ]");
	   }   
	
	//midfielders
	public void addMid(Player p) {
	      midfielders.add(p);
	   }

	   public void removeMid(Player p) {
		   midfielders.remove(p);
	   }

	   public List<Player> getMid(){
	     return midfielders;
	   }
	   
	public String MidToString(){
	      return ("Midfielders :[ Name : " + player_name + ", Availability : " + player_availability + ", Points :" + player_points+" ]");
	   }  
	
	//attackers
		public void addAtt(Player p) {
			attackers.add(p);
		   }

		   public void removeAtt(Player p) {
			   attackers.remove(p);
		   }

		   public List<Player> getAtt(){
		     return attackers;
		   }
		   
		public String AttToString(){
		      return ("attackers :[ Name : " + player_name + ", Availability : " + player_availability + ", Points :" + player_points+" ]");
		   }  
	
	
	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public String getPlayer_availability() {
		return player_availability;
	}

	public void setPlayer_availability(String player_availability) {
		this.player_availability = player_availability;
	}
	
	public int getPlayer_points() {
		return player_points;
	}

	public void setPlayer_points(int player_points) {
		this.player_points = player_points;
	}

}
