package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Admin;
import Model.User;
import View.LogInWindow;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class LoggedInAsUser extends LogInWindow{

	private JFrame frmLoggedUser;
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();

	/**
	 * Launch the application.
	 */
	public void startLoggedUser() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoggedInAsUser window = new LoggedInAsUser();
					window.frmLoggedUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoggedInAsUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoggedUser = new JFrame();
		frmLoggedUser.getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmLoggedUser.getContentPane().setBackground(new Color(189, 183, 107));
		frmLoggedUser.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setHorizontalAlignment(SwingConstants.LEFT);
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblCsFantasyFootball.setBounds(10, 11, 378, 33);
		frmLoggedUser.getContentPane().add(lblCsFantasyFootball);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoggedUser.hide();
				frame.setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnLogOut.setBounds(404, 20, 79, 24);
		frmLoggedUser.getContentPane().add(btnLogOut);
		
		JLabel userLabel = new JLabel("Welcome back: " + currentUser.getUsername());
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		userLabel.setBounds(10, 55, 267, 24);
		frmLoggedUser.getContentPane().add(userLabel);
		
		JButton btnViewStandings = new JButton("View Standings");
		btnViewStandings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewStandings.setBounds(355, 178, 117, 33);
		frmLoggedUser.getContentPane().add(btnViewStandings);
		
		JButton btnEditTeam = new JButton("Edit Team");
		btnEditTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditTeam.setBounds(355, 222, 117, 33);
		frmLoggedUser.getContentPane().add(btnEditTeam);
		
		JButton btnEditTeamName = new JButton("Edit Team Name");
		btnEditTeamName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditTeamName.setBounds(355, 266, 117, 33);
		frmLoggedUser.getContentPane().add(btnEditTeamName);
		
		JButton btnPoints = new JButton("View All Points");
		btnPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPoints.setBounds(355, 310, 117, 33);
		frmLoggedUser.getContentPane().add(btnPoints);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 115, 257, 228);
		frmLoggedUser.getContentPane().add(textPane);
		
		JLabel lblYourSquadpoints = new JLabel("Your Squad/Points");
		lblYourSquadpoints.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYourSquadpoints.setBounds(20, 90, 117, 24);
		frmLoggedUser.getContentPane().add(lblYourSquadpoints);
		
		JLabel lblWeekNo = new JLabel("Week No: ");
		lblWeekNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWeekNo.setBounds(355, 115, 117, 33);
		frmLoggedUser.getContentPane().add(lblWeekNo);
		frmLoggedUser.setBounds(100, 100, 509, 412);
		frmLoggedUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
