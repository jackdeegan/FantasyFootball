package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Model.Player;
import Model.Team;
import DAL.AccessPlayers;
import DAL.DatabaseService;
import Interceptor.InfoLogContext;
import Interceptor.Interceptor;
import Interceptor.LoggingDispatcher;
import Interceptor.LoggingInterceptor;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TeamSetUp extends CreateAccount{

	private DatabaseService playersDB = new AccessPlayers();
	JFrame frmTeamSetUp;
	public static String username = CreateAccount.username;

	public JTextArea textArea = new JTextArea();
	public JTextArea textArea_1 = new JTextArea();
	private FileReader aFile;
	private Scanner in;
	private JTextField playerEntryField;
	private String teamSelection = username;

/*	public void GenerateTeam(){//place in team setup
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
	}*/

	/**
	 * Launch the application.
	 */
	public void startSetUp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamSetUp window = new TeamSetUp();
					window.frmTeamSetUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeamSetUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeamSetUp = new JFrame();
		frmTeamSetUp.getContentPane().setBackground(new Color(240, 230, 140));
		frmTeamSetUp.setBounds(100, 100, 607, 508);
		frmTeamSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamSetUp.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblCsFantasyFootball.setBounds(10, 11, 366, 40);
		frmTeamSetUp.getContentPane().add(lblCsFantasyFootball);
		
		JLabel lblSelectYourTeam = new JLabel("Select Your Team");
		lblSelectYourTeam.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblSelectYourTeam.setBounds(10, 77, 172, 30);
		frmTeamSetUp.getContentPane().add(lblSelectYourTeam);
		
		JLabel userLabel = new JLabel("Welcome: " + username);
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		userLabel.setBounds(10, 55, 267, 24);
		frmTeamSetUp.getContentPane().add(userLabel);
		frmTeamSetUp.setBounds(100, 100, 509, 412);
		frmTeamSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JList list = new JList();
		list.setBounds(117, 338, 101, -138);
		frmTeamSetUp.getContentPane().add(list);
		
		JButton btnConfirmTeam = new JButton("Confirm Team");
		btnConfirmTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				result = Team.checkTeam(teamSelection);
				if (result.equals("Team Created Successfully!")) {
					JOptionPane.showMessageDialog(null, result);
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, result + "\n\nResetting...");
					teamSelection = username;
					textArea.setText("");
				}
			}
		});
		btnConfirmTeam.setBounds(10, 339, 101, 23);
		frmTeamSetUp.getContentPane().add(btnConfirmTeam);
		
		JButton btnViewGoalkeepers = new JButton("View Goalkeepers");
		btnViewGoalkeepers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> goalkeeperList = new ArrayList<String>();
				
				Date databaseRequestTime = new Date();											//Creates new Date Object	
				InfoLogContext requestTimeContext = new InfoLogContext(databaseRequestTime);	//Creates new InfoLogContext using Date Object
				aLoggingDispatcher.onDatabaseRequest(requestTimeContext);						//Execute onDatabaseRequest Method
				
				goalkeeperList = playersDB.getAllGoalkeepers();									//Retrieve Info from Database
				
				aLoggingDispatcher.onDatabaseReply(requestTimeContext);							//Execute onDatabaseReply Method

				textArea_1.setText("Goalkeepers: \n");
				for (int i = 0; i < goalkeeperList.size(); i++) {
					
					textArea_1.append(goalkeeperList.get(i) + "\n");
				}
			}
		});
		btnViewGoalkeepers.setBounds(10, 106, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewGoalkeepers);
		
		JButton btnViewDefenders = new JButton("View Defenders");
		btnViewDefenders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("Defenders: \n");
				List<String> defenderList = new ArrayList<String>();
				defenderList = playersDB.getAllDefenders();
				for (int i = 0; i < defenderList.size(); i++) {
					textArea_1.append(defenderList.get(i) + "\n");
				}
			}
		});
		btnViewDefenders.setBounds(137, 106, 109, 23);
		frmTeamSetUp.getContentPane().add(btnViewDefenders);
		
		JButton btnViewMidfielders = new JButton("View Midfielders");
		btnViewMidfielders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("Midfielders: \n");
				List<String> midfielderList = new ArrayList<String>();
				midfielderList = playersDB.getAllMidfielders();
				for (int i = 0; i < midfielderList.size(); i++) {
					textArea_1.append(midfielderList.get(i) + "\n");
				}
			}
		});
		btnViewMidfielders.setBounds(256, 106, 109, 23);
		frmTeamSetUp.getContentPane().add(btnViewMidfielders);
		
		JButton btnViewForwards = new JButton("View Forwards");
		btnViewForwards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("Forwards: \n");
				List<String> forwardList = new ArrayList<String>();
				forwardList = playersDB.getAllForwards();
				for (int i = 0; i < forwardList.size(); i++) {
					textArea_1.append(forwardList.get(i) + "\n");
				}
			}
		});
		btnViewForwards.setBounds(375, 106, 109, 23);
		frmTeamSetUp.getContentPane().add(btnViewForwards);
		
		textArea.setBounds(10, 135, 307, 192);
		frmTeamSetUp.getContentPane().add(textArea);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 135, 237, 182);
		scroll.setViewportView(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmTeamSetUp.getContentPane().add(scroll);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(267, 140, 216, 177);
		frmTeamSetUp.getContentPane().add(textArea_1);
		JScrollPane scroll1 = new JScrollPane(textArea_1);
		scroll1.setBounds(267, 140, 216, 177);
		scroll1.setViewportView(textArea_1);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmTeamSetUp.getContentPane().add(scroll1);
		
		
		playerEntryField = new JTextField();
		playerEntryField.setBounds(117, 338, 101, 20);
		frmTeamSetUp.getContentPane().add(playerEntryField);
		playerEntryField.setColumns(10);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = playerEntryField.getText();
				String playerRow[] = Player.checkPlayer(input);
				if (playerRow == null) {
					JOptionPane.showMessageDialog(null, "Invalid Selection!");
				}
				else if (teamSelection.contains("," + input + ","))
					JOptionPane.showMessageDialog(null, "Player Already Selected!");
				else {
					teamSelection = teamSelection + "," + input;
					for (int i = 0; i < playerRow.length; i++) {
						if (i == (playerRow.length - 1))
							textArea.append(playerRow[i] + "\n");
						else
							textArea.append(playerRow[i] + ",");
					}
				}
			}
		});
		btnSelect.setBounds(228, 338, 89, 23);
		frmTeamSetUp.getContentPane().add(btnSelect);
		
		JButton btnClearSelection = new JButton("Clear Selection");
		btnClearSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teamSelection = username;
				JOptionPane.showMessageDialog(null, "Selections Cleared!");
				textArea.setText("");
			}
		});
		btnClearSelection.setBounds(326, 338, 117, 23);
		frmTeamSetUp.getContentPane().add(btnClearSelection);
	
	}

}
