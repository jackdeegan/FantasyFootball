package League;
import java.util.ArrayList;
import Model.Player;
import DAL.AccessTeams;
import DAL.AccessPlayers;

public class Fixtures {
	
	private TeamComponent teamList;
	
	//test
	public Fixtures(TeamComponent teamList) {
		createNewStandings(teamList);
	}
	public Fixtures() {
		GenerateTeam();
	}
	
	public TeamComponent getTeamList(){
		return teamList;
	}
	
	//runs current leaderboard against fixtures played
	
	public void createNewStandings(TeamComponent teamList) {
		int numberOfTeams;
		String [] teamLine;
		
		AccessTeams accessTeam = new AccessTeams();
		numberOfTeams = accessTeam.getData().size();	
		for(int i = 0; i<numberOfTeams; i++) {
			teamLine = accessTeam.getRowData(i);
			for(int j = 1; j<teamLine.length - 1; j++) {				
				updatePoints(Integer.parseInt(teamLine[j]),teamList);//goes and looks up player in played fixtures 
			}
		}

	}
	
	public void GenerateTeam(){
		ArrayList <Player> players = new ArrayList<Player>();
		int addedTeam;
		String [] team;
		AccessTeams accessTeam = new AccessTeams();
		addedTeam = accessTeam.getData().size();	
	    team = accessTeam.getRowData(addedTeam);
	    players = GeneratePlayers(team);
	    Team newTeam = new Team(team[0],players);	 //name,points,players	    
		teamList.add(newTeam);		
	}
	
	public ArrayList <Player> GeneratePlayers(String [] line) {
		ArrayList <Player> players = new ArrayList<Player>();
		Player selectedPlayer;
		String [] player;
		AccessPlayers accessPlayer = new AccessPlayers();
		for(int i = 1; i<line.length - 1; i++) {
			player = accessPlayer.getRowData(i);
			selectedPlayer = new Player(Integer.parseInt(player[0]),player[1],player[2],player[3],Integer.parseInt(player[4]),player[5],Integer.parseInt(player[6]));
			players.add(selectedPlayer);
		}		
		return players;
	}
	public void updatePoints(int playerID,TeamComponent teamList) {
		teamList.updatePoints();
		getTeamList();
	}

}