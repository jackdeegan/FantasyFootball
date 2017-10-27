package Model;

import Model.Player;
import Model.Team;
import DAL.DatabaseService;
import View.LogInWindow;
import View.LoggedInAsUser;
import Model.User;
import java.util.*;

public class CompositePattern extends LogInWindow implements I_Composite{
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();
	
	public CompositePattern() {}
	
	public String printTeam(String team) {
	
		//System.out.println(username);
		//List<String> teamWithNames = new ArrayList<String>();
		List<String> team_list = new ArrayList<String>();
		DatabaseService db_players = new DatabaseService("data/Players.txt");
		DatabaseService db_teams = new DatabaseService("data/Teams.txt");
		team_list = db_teams.getData();
		
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
					col  = db_players.getRowData(player);
	
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
	
					//Team my_Team = new Team();
					
					team += goalie.toString() + "\n";
					
					//System.out.println(goalie);
				}
			/*for (Player start : goalie.getTeamMembers()) {
       			System.out.println(start);
    	
       			for (Player finish : start.getTeamMembers()) {
          		System.out.println(finish);
       			}*/
    		}
		}return team;
	}
}