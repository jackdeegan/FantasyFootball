package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Model.User;
import Model.Team;
import DAL.AccessPlayers;
import DAL.DatabaseService;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class TeamSetUp extends CreateAccount{

	private DatabaseService playersDB = new AccessPlayers();
	JFrame frmTeamSetUp;
	public static String username = CreateAccount.username;

	public JTextArea textArea = new JTextArea();
	private FileReader aFile;
	private Scanner in;
	private JTextField playerEntryField;
	private String teamSelection = username;
	private String regex = "[0-9]+";



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
		
		JLabel lblPickPlayers = new JLabel("Pick Players");
		lblPickPlayers.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblPickPlayers.setBounds(10, 100, 101, 24);
		frmTeamSetUp.getContentPane().add(lblPickPlayers);
		
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
				goalkeeperList = playersDB.getAllGoalkeepers();
				textArea.setText("Goalkeepers: \n");
				for (int i = 0; i < goalkeeperList.size(); i++) {
					textArea.append(goalkeeperList.get(i) + "\n");				//FOR KIERAN TO FIX
				}
			}
		});
		btnViewGoalkeepers.setBounds(356, 154, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewGoalkeepers);
		
		JButton btnViewDefenders = new JButton("View Defenders");
		btnViewDefenders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Defenders: \n");
				List<String> defenderList = new ArrayList<String>();
				defenderList = playersDB.getAllDefenders();
				for (int i = 0; i < defenderList.size(); i++) {
					textArea.append(defenderList.get(i) + "\n");				//FOR KIERAN TO FIX
				}
			}
		});
		btnViewDefenders.setBounds(356, 189, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewDefenders);
		
		JButton btnViewMidfielders = new JButton("View Midfielders");
		btnViewMidfielders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Midfielders: \n");
				List<String> midfielderList = new ArrayList<String>();
				midfielderList = playersDB.getAllMidfielders();
				for (int i = 0; i < midfielderList.size(); i++) {
					textArea.append(midfielderList.get(i) + "\n");				//FOR KIERAN TO FIX
				}
			}
		});
		btnViewMidfielders.setBounds(356, 223, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewMidfielders);
		
		JButton btnViewForwards = new JButton("View Forwards");
		btnViewForwards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Forwards: \n");
				List<String> forwardList = new ArrayList<String>();
				forwardList = playersDB.getAllForwards();
				for (int i = 0; i < forwardList.size(); i++) {
					textArea.append(forwardList.get(i) + "\n");					//FOR KIERAN TO FIX
				}
			}
		});
		btnViewForwards.setBounds(356, 257, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewForwards);
		
		JButton btnViewPlayersPoints = new JButton("Player's Points");
		btnViewPlayersPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewPlayersPoints.setBounds(356, 291, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewPlayersPoints);
		
		textArea.setBounds(10, 135, 307, 192);
		frmTeamSetUp.getContentPane().add(textArea);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 135, 307, 182);
		scroll.setViewportView(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmTeamSetUp.getContentPane().add(scroll);
		
		playerEntryField = new JTextField();
		playerEntryField.setBounds(117, 338, 101, 20);
		frmTeamSetUp.getContentPane().add(playerEntryField);
		playerEntryField.setColumns(10);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = playerEntryField.getText();
				String playerRow[];
				if (!(input.matches(regex)))
					JOptionPane.showMessageDialog(null, "Invalid Selection!");
				else {
					teamSelection = teamSelection + "," + input;
					try {
						playerRow = playersDB.getRowData(Integer.parseInt(input));
						for (int i = 0; i < playerRow.length; i++) {
							if (i == (playerRow.length - 1))
								textArea.append(playerRow[i] + "\n");
							else
								textArea.append(playerRow[i] + ",");
						}
					}
					catch(InputMismatchException e1) {
						JOptionPane.showMessageDialog(null, "Invalid Selection!");
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
