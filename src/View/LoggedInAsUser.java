package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Model.Admin;
import Model.User;
import View.LogInWindow;
import Model.CompositePattern;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class LoggedInAsUser extends LogInWindow{

	private JFrame frmLoggedUser;
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();
	public JTextArea userlist = new JTextArea();
	private FileReader aFile;
	private Scanner in;

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
		btnLogOut.setFont(new Font("Arial Black", Font.PLAIN, 9));
		btnLogOut.setBounds(404, 20, 79, 24);
		frmLoggedUser.getContentPane().add(btnLogOut);
		
		JLabel userLabel = new JLabel("Welcome back: " + currentUser.getUsername());
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		userLabel.setBounds(10, 55, 267, 24);
		frmLoggedUser.getContentPane().add(userLabel);
		
		JTextArea userList = new JTextArea();
		userList.setBounds(10, 135, 364, 229);
		frmLoggedUser.getContentPane().add(userList);
		JScrollPane scroll = new JScrollPane(userList);
		scroll.setBounds(10, 156, 353, 233);
		scroll.setViewportView(userList);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmLoggedUser.getContentPane().add(scroll);
		
		JButton btnViewStandings = new JButton("View Standings");
		btnViewStandings.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnViewStandings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLeague leagueWindow = new ViewLeague();
				leagueWindow.StartLeagueTable();
			}
		});
		btnViewStandings.setBounds(10, 90, 112, 24);
		frmLoggedUser.getContentPane().add(btnViewStandings);
		
		JButton btnEditTeam = new JButton("View Team");
		btnEditTeam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompositePattern myTeam = new CompositePattern();
				//String team = myTeam.printTeam("");
				userList.setText(myTeam.printTeam(""));
				//myTeam.printTeam();	
			}
		});
		btnEditTeam.setBounds(132, 90, 101, 24);
		frmLoggedUser.getContentPane().add(btnEditTeam);
		
		JButton btnPoints = new JButton("View All Points");
		btnPoints.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aFile = new FileReader("data/Players.txt");
					String[] users;
					in = new Scanner(aFile);
					userList.setText("Players/Points:\n");
					while (in.hasNext()) {
						users = in.nextLine().split(",");
						userList.append(users[0] + ", " + users[1] + ", " + users[2] + ", "+ users[3] + ", " + users[4] + "\n");

					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPoints.setBounds(373, 90, 110, 24);
		frmLoggedUser.getContentPane().add(btnPoints);
		
		//When Brian gets total points from league table
		
		JLabel lblYourSquadpoints = new JLabel("Your Points:");
		lblYourSquadpoints.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYourSquadpoints.setBounds(10, 121, 117, 24);
		frmLoggedUser.getContentPane().add(lblYourSquadpoints);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoggedUser.hide();
				LoggedInAsUser window1 = new LoggedInAsUser();
				window1.frmLoggedUser.setVisible(true);
				
			}
		});
		btnClear.setBounds(10, 400, 89, 23);
		frmLoggedUser.getContentPane().add(btnClear);
		frmLoggedUser.setBounds(100, 100, 523, 470);
		frmLoggedUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
