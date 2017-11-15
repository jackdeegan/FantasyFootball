package Model;

import DAL.AccessPlayers;
import DAL.AccessTeams;
import DAL.DatabaseService;
import View.LogInWindow;
import Model.User;
import java.util.*;
import Model.Player;

import Model.PlayerComponent;
import Model.Team;

public class CompositePattern extends LogInWindow{
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();
	private static DatabaseService playersDB = new AccessPlayers();
	private static DatabaseService teamsDB = new AccessTeams();
	
	public CompositePattern() {}
	
	public String printTeam(String team) {
		
		List<String> team_list = new ArrayList<String>();
		team_list = teamsDB.getData();
		
		String[] teamPlayersID = new String[14];
		String uname;
		
		for(int j = 0; j < team_list.size(); j++) {
			String row = team_list.get(j);
		
			uname = row.substring(0, row.indexOf(","));
		
			if(uname.equals(username)) {
				teamPlayersID = row.substring(row.indexOf(",") + 1).split(",");
				String[] col = new String[6];
				for(int i = 0; i <= 14; i++) {
					int player = Integer.parseInt(teamPlayersID[i]);
					col  = playersDB.getRowData(player);
					
					Player goals = new Player(Integer.parseInt(teamPlayersID[i]),col[1], col[2], col[3], Integer.parseInt(col[4]), col[5], Integer.parseInt(col[6]));
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
					
					PlayerComponent goalie = new Team("Goalies");
					PlayerComponent def = new Team("Defenders");
					PlayerComponent mid = new Team("Midfielders");
					PlayerComponent forw = new Team("Forwards");
					
					PlayerComponent everyPlayer = new Team("All Players");
					
					everyPlayer.add(goalie);
					
					goalie.add(goals);
					goalie.add(goalieSub);
					
					goalie.add(def);
					
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
					
					everyPlayer.add(forw);
					
					forw.add(attacker1);
					forw.add(attacker2);
					forw.add(attackerSub);
					
					team += attackerSub.displayPlayerInfo() + "\n";
					}
       			}
    		}
		return team;
	}
}