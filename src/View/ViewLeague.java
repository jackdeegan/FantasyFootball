package View;

import java.awt.EventQueue;
import League.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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


public class ViewLeague{
	
	public static int GameWeeks = 0;
	public static TeamComponent league = new LeaguePublic("League");
	public static int currentWeek = 0;
	
    LeagueCaretaker caretaker = new LeagueCaretaker();//allows adding and retrieval of league states
	LeagueOriginator originator = new LeagueOriginator();//sets values for league, create new mementos, stores league in current memento	
	private JFrame frame;

	public void StartLeagueTable () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					ViewLeague window = new ViewLeague();
					window.frame.setVisible(true);
					GenerateTeams();//generate current leaderboard into team objects
				 }catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewLeague(){		
		initialize();
		}
	
	private void GenerateTeams() {
		int teamCount;
		String [] team;
		Team newTeam;
		ArrayList <Player> players = new ArrayList<Player>();	
	    
		AccessTeams accessTeam = new AccessTeams();
			
			teamCount = accessTeam.getData().size();
			for(int i = 1; i <= teamCount; i++)
			{
				team = accessTeam.getRowData(i);//shanekenny123,1,12,13,2,4,15,14,16,17,18,5,6,20,10,11
			    players = GeneratePlayersForTeams(team);
			    newTeam = new Team(team[1],players);	 //TeamName,points	    
				league.add(newTeam);
			}
			//display
			originator.set(league);
			
		    				
	}
	public ArrayList <Player> GeneratePlayersForTeams(String [] team) 
	{
		ArrayList <Player> players = new ArrayList<Player>();
		Player selectedPlayer;
		String [] player;
		AccessPlayers accessPlayer = new AccessPlayers();
		for(int i = 2; i<team.length; i++) 
		{		
			player = accessPlayer.getRowData(Integer.parseInt(team[i]));//access specific player from team line
			selectedPlayer = new Player(Integer.parseInt(player[0]),player[1],player[2],player[3],Integer.parseInt(player[4]),player[5],Integer.parseInt(player[6]));
			players.add(selectedPlayer);
		}		
		return players;
	}

	private void initialize()
	{		
		
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
                    league.displayTeamInfo();
				}
					
			}
		});
		btnNewButton.setBounds(60, 16, 116, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next Week");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if((GameWeeks - 1) > currentWeek)
				   {
					   currentWeek++;

					   league = originator.restoreFromMemento(caretaker.getLeagueMemento(currentWeek));
					   league.displayTeamInfo();
					   
			       }
				
			}
		});
					
		btnNewButton_1.setBounds(433, 16, 116, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnGenerateFixtureResults = new JButton("Play Game Week");
		btnGenerateFixtureResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fixtures newStandings = new Fixtures(league);
				originator.set(league);
				caretaker.addMemento(originator.storeInMemento());
				
				GameWeeks++;
				currentWeek++;
				
				JOptionPane.showMessageDialog(null, "Fixture results Procesed, Game Week Saved");
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
	}
}