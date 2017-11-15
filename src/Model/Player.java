package Model;

import DAL.AccessPlayers;
import DAL.DatabaseService;

public class Player extends PlayerComponent {
	
	private int playerID;
	private String playerFName;
	private String playerLName;
	private String playerPosition;
	private int playerInjured;
	private String playerTeam;
	private int playerPoints;
	
	public Player(int newPlayerID, String newPlayerFName, String newPlayerLName, String newPlayerPosition, int newPlayerInjured, String newPlayerTeam, int newPlayerPoints) {
		playerID = newPlayerID;
		playerFName = newPlayerFName;
		playerLName = newPlayerLName;
		playerPosition = newPlayerPosition;
		playerInjured = newPlayerInjured;
		playerTeam = newPlayerTeam;
		playerPoints = newPlayerPoints;
	}
	
	public int getPlayerID() {
		return playerID;
	}

	public String getPlayerFName() {
		return playerFName;
	}
	
	public String getPlayerLName() {
		return playerLName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public int getPlayerInjured() {
		return playerInjured;
	}
	
	public String getPlayerTeam() {
		return playerTeam;
	}

	public int getPlayerPoints() {
		return playerPoints;
	}	
	
	public String displayPlayerInfo() {
		//System.out.println(getPlayerID() + "," +getPlayerFName() +","+ getPlayerLName() +","+getPlayerPosition()+","+getPlayerInjured()+","+getPlayerTeam()+","+getPlayerPoints());
		
		return ("Name: "+getPlayerFName() +" "+ getPlayerLName() +"\tPosition: "+getPlayerPosition()+"\tInjured: "+getPlayerInjured()+"\tTeam: "+getPlayerTeam()+"\tPoints: "+getPlayerPoints());
	}
	
	public static String[] checkPlayer(String selectedPlayer) {
		
		DatabaseService playersDB = new AccessPlayers();
		String regex = "[0-9]+";
		String playerInfo[] = null;
		if (!(selectedPlayer.matches(regex)))
			return playerInfo;
		else {
			playerInfo = playersDB.getRowData(Integer.parseInt(selectedPlayer));
		}
		
		return playerInfo;
    }
}	