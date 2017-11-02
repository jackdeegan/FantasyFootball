package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Model.User;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;

public class TeamSetUp extends CreateAccount{

	JFrame frmTeamSetUp;
	private JTextField textField;
	public static String username = CreateAccount.username;

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
		frmTeamSetUp.setBounds(100, 100, 509, 458);
		frmTeamSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamSetUp.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblCsFantasyFootball.setBounds(10, 11, 366, 40);
		frmTeamSetUp.getContentPane().add(lblCsFantasyFootball);
		
		JLabel lblSelectYourTeam = new JLabel("Select Your Team");
		lblSelectYourTeam.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblSelectYourTeam.setBounds(10, 77, 172, 30);
		frmTeamSetUp.getContentPane().add(lblSelectYourTeam);
		
		JLabel userLabel = new JLabel("Welcome: " + username);
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		userLabel.setBounds(10, 55, 267, 24);
		frmTeamSetUp.getContentPane().add(userLabel);
		frmTeamSetUp.setBounds(100, 100, 509, 412);
		frmTeamSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTeamName = new JLabel("Team Name: ");
		lblTeamName.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTeamName.setBounds(10, 105, 87, 24);
		frmTeamSetUp.getContentPane().add(lblTeamName);
		
		textField = new JTextField();
		textField.setBounds(95, 107, 112, 23);
		frmTeamSetUp.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeamSetUp.hide();
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.setBounds(394, 25, 89, 23);
		frmTeamSetUp.getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(117, 338, 101, -138);
		frmTeamSetUp.getContentPane().add(list);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 154, 287, 183);
		frmTeamSetUp.getContentPane().add(textPane);
		
		JLabel lblPickPlayers = new JLabel("Pick Players");
		lblPickPlayers.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblPickPlayers.setBounds(10, 129, 101, 24);
		frmTeamSetUp.getContentPane().add(lblPickPlayers);
		
		JButton btnConfirmTeam = new JButton("Confirm Team");
		btnConfirmTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmTeam.setBounds(10, 339, 101, 23);
		frmTeamSetUp.getContentPane().add(btnConfirmTeam);
		
		JButton btnViewGoalkeepers = new JButton("View Goalkeepers");
		btnViewGoalkeepers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewGoalkeepers.setBounds(356, 154, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewGoalkeepers);
		
		JButton btnViewDefenders = new JButton("View Defenders");
		btnViewDefenders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewDefenders.setBounds(356, 189, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewDefenders);
		
		JButton btnViewMidfielders = new JButton("View Midfielders");
		btnViewMidfielders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewMidfielders.setBounds(356, 223, 117, 23);
		frmTeamSetUp.getContentPane().add(btnViewMidfielders);
		
		JButton btnViewForwards = new JButton("View Forwards");
		btnViewForwards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	}
}
