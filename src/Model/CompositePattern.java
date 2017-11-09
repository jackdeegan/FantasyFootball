package Model;

import DAL.AccessPlayers;
import DAL.DatabaseService;
import View.LogInWindow;
import Model.User;
import java.util.*;
import Model.Player;

public class CompositePattern extends LogInWindow{
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();
	private static DatabaseService playersDB = new AccessPlayers();
	private static DatabaseService teamsDB = new AccessPlayers();
	
	public CompositePattern() {}
	
	public String printTeam(String team) {
		
		List<String> team_list = new ArrayList<String>();
		team_list = teamsDB.getData();
		
		String[] teamPlayersID = new String[14];
		String uname;
		
		for(int j = 0; j < team_list.size(); j++) {
			String row = team_list.get(j);
		
			uname = row.substring(0, row.indexOf(","));
			//System.out.println(uname);
		
			if(uname.equals(username)) {
				teamPlayersID = row.substring(row.indexOf(",") + 1).split(",");
				String[] col = new String[6];
		
				for(int i = 0; i < 14; i++) {
					int player = Integer.parseInt(teamPlayersID[i]);
					col  = playersDB.getRowData(player);
					
					/*Player goalie = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player goalieSub = new Player (Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));

					Player defender1  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defender2  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defender3  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defender4  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defenderSub  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));

					Player midfielder1 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielder2 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielder3 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielder4 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielderSub = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));

					Player attacker1 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player attacker2 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player attackerSub = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					
					
					PlayerComponent goa = new Team("Goalies", "2");
					PlayerComponent def = new Team("\nDefenders","5");
					PlayerComponent mid = new Team("\nMidfielders","5");
					PlayerComponent att = new Team("\nForwards","3");
					
					PlayerComponent everyPlayer = new Team("Player List","Every Player Available");
					
					everyPlayer.add(goa);
					
					goa.add(goalie);
					goa.add(goalieSub);
					
					goa.add(def);
					
					def.add(defender1);
					def.add(defender2);
					def.add(defender3);
					def.add(defender4);
					def.add(defenderSub);
					
					def.add(mid);
					
					mid.add(midfielder1);
					mid.add(midfielder2);
					mid.add(midfielder3);
					mid.add(midfielder4);
					mid.add(midfielderSub);
					
					mid.add(att);
					att.add(attacker1);
					att.add(attacker2);
					att.add(attackerSub);
					
					Test x = new Test(everyPlayer);
					x.getPlayerList();

					//team += everyPlayer.displayPlayerInfo() + "\n";*/
					
					
					Player goalie = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player goalieSub = new Player (Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));

					Player defender1  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defender2  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defender3  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defender4  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player defenderSub  = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));

					Player midfielder1 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielder2 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielder3 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielder4 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player midfielderSub = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));

					Player attacker1 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player attacker2 = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					Player attackerSub = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
					
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
	
					team += goalie.toString() + "\n";
					}
       			}
    		}
		return team;
	}
}
    		
    		
    		
