package Model;

import Model.Player;
import DAL.DatabaseService;

import java.util.*;

public class CompositePattern {
	public static void main (String [] args) {
	//List<String> player_list = new ArrayList<String>();
	List<String> team_list = new ArrayList<String>();
	DatabaseService db_players = new DatabaseService("data/Players.txt");
	DatabaseService db_teams = new DatabaseService("data/Teams.txt");
	team_list = db_teams.getData();
	
	String[] teamPlayersID = new String[14];
	String row = team_list.get(0);
	teamPlayersID = row.substring(row.indexOf(",") + 1).split(",");
	String[] test = new String[6];
		
	for(int i = 0; i < 14; i++) {
	int player = Integer.parseInt(teamPlayersID[i]);
	//System.out.println(player);
	
	test  = db_players.getRowData(player);
	//System.out.println(teamPlayersID[i] + test[1]+ test[2]+ test[3]+ test[4]+ test[5]+ test[6]);
	
	Player goalie = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
	Player goalieSub = new Player (Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));

    Player defender1  = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player defender2  = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player defender3  = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player defender4  = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player defenderSub  = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));

    Player midfielder1 = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player midfielder2 = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player midfielder3 = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player midfielder4 = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player midfielderSub = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));

    Player attacker1 = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player attacker2 = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
    Player attackerSub = new Player(Integer.parseInt(teamPlayersID[i]),test[1], test[2], test[3], Integer.parseInt(test[4]), test[5], Integer.parseInt(test[6]));
	
    goalie.add(goalieSub);
    goalie.add(defender1);
    goalie.add(midfielder1);
    goalie.add(attacker1);
    
    defender1.add(defender2);
    defender1.add(defender3);
    defender1.add(defender4);
    defender1.add(defenderSub);
    
    midfielder1.add(midfielder2);
    midfielder1.add(midfielder3);
    midfielder1.add(midfielder4);
    midfielder1.add(midfielderSub);
    
    attacker1.add(attacker2);
    attacker2.add(attackerSub);
	
    //print all players on the team
    System.out.println(goalie); 
	
   /* for (Player start : goalie.getTeamMembers()) {
       System.out.println(start);
    
       for (Player finish : start.getTeamMembers()) {
          System.out.println(finish);
       }
    }	*/
 }}
}

	

