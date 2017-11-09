package View;

import java.awt.EventQueue;
import League.Fixtures;
import javax.swing.JFrame;
import javax.swing.JLabel;
import DAL.AccessTeams;
import DAL.AccessPlayers;
import League.LeagueCaretaker;
import League.LeagueOriginator;
import League.LeaguePublic;
import League.Team;
import League.TeamComponent;
import Model.Player;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class ViewLeague {
	
	public static int GameWeek = 0;

	int currentWeek = 0;
	TeamComponent league = new LeaguePublic("League");
    LeagueCaretaker caretaker = new LeagueCaretaker();//allows adding and retrieval of league states
	LeagueOriginator originator = new LeagueOriginator();//sets values for league, create new mementos, stores league in current memento	
	private JFrame frame;

	public void StartLeagueTable () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLeague window = new ViewLeague();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewLeague()
	{
		
		initialize();
		
	}

	private void GenerateTeams() {
		

			ArrayList <Player> players = new ArrayList<Player>();
			int teamCount;
			String [] team;
			AccessTeams accessTeam = new AccessTeams();
			teamCount = accessTeam.getData().size();
			for(int i = 0; i < teamCount; i++)
			{
				team = accessTeam.getRowData(teamCount);
			    players = GeneratePlayersForTeams(team);
			    Team newTeam = new Team(team[0],players);	 //name,points,players	    
				league.add(newTeam);
			}
			//display
		    				
	}
	public ArrayList <Player> GeneratePlayersForTeams(String [] line) 
	{
		ArrayList <Player> players = new ArrayList<Player>();
		Player selectedPlayer;
		String [] player;
		AccessPlayers accessPlayer = new AccessPlayers();
		for(int i = 1; i<line.length - 1; i++) 
		{
			player = accessPlayer.getRowData(i);
			selectedPlayer = new Player(Integer.parseInt(player[0]),player[1],player[2],player[3],Integer.parseInt(player[4]),player[5],Integer.parseInt(player[6]));
			players.add(selectedPlayer);
		}		
		return players;
	}

	private void initialize()
	{
		
		GenerateTeams();//generate current leaderboard into team objects
		
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 650);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblView = new JLabel("View League");
		lblView.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblView.setBounds(240, 0, 111, 55);
		frame.getContentPane().add(lblView);
		
		JButton btnNewButton = new JButton("Previous week");//Back
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentWeek >= 1)
				{
					currentWeek--;

                    league = originator.restoreFromMemento(caretaker.getLeagueMemento(currentWeek));

                    //display 
				}
					
			}
		});
		btnNewButton.setBounds(60, 16, 116, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next Week");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if((GameWeek - 1) > currentWeek)
				   {
					   currentWeek++;

					   league = originator.restoreFromMemento(caretaker.getLeagueMemento(currentWeek) );
					   //display
			       }
			}
		});
			
		
		btnNewButton_1.setBounds(433, 16, 116, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnGenerateFixtureResults = new JButton("Generate fixture results");
		btnGenerateFixtureResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fixtures newStandings = new Fixtures(league);
				originator.set(league);
				caretaker.addMemento(originator.storeInMemento());
				
				GameWeek++;
				currentWeek++;
			}
		});
		btnGenerateFixtureResults.setBounds(382, 547, 167, 25);
		frame.getContentPane().add(btnGenerateFixtureResults);
			
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(60, 547, 116, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblTeamUser = new JLabel("Team User");
		lblTeamUser.setBounds(70, 66, 76, 16);
		frame.getContentPane().add(lblTeamUser);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(167, 66, 56, 16);
		frame.getContentPane().add(lblPlayers);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(443, 66, 56, 16);
		frame.getContentPane().add(lblPoints);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 118, 558, 388);
		frame.getContentPane().add(textArea);
		textArea.append(league.displayLeagueTeams());//iterate through each team and display team and points in order
				
	}

}
	
