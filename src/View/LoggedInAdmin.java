package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Model.User;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.io.FileWriter;
import java.io.IOException;

public class LoggedInAdmin extends LogInWindow{

	private JFrame frmLoggedAdmin;
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();
	public JTextArea userlist = new JTextArea();
	private FileReader aFile;
	private Scanner in;
	private PrintWriter pw;

	/**
	 * Launch the application.
	 */
	public void startLoggedAdmin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoggedInAdmin window = new LoggedInAdmin();
					window.frmLoggedAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoggedInAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoggedAdmin = new JFrame();
		frmLoggedAdmin.getContentPane().setBackground(Color.GREEN);
		frmLoggedAdmin.setBounds(100, 100, 529, 447);
		frmLoggedAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoggedAdmin.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setHorizontalAlignment(SwingConstants.LEFT);
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblCsFantasyFootball.setBounds(10, 11, 396, 35);
		frmLoggedAdmin.getContentPane().add(lblCsFantasyFootball);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoggedAdmin.hide();
				frame.setVisible(true);
			}
		});
		btnLogOut.setBounds(404, 24, 99, 23);
		frmLoggedAdmin.getContentPane().add(btnLogOut);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back Admin: " + currentUser.getUsername());
		lblWelcomeBack.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblWelcomeBack.setBounds(10, 57, 308, 23);
		frmLoggedAdmin.getContentPane().add(lblWelcomeBack);
		
		JTextArea userList = new JTextArea();
		userList.setBounds(10, 135, 364, 229);
		frmLoggedAdmin.getContentPane().add(userList);
		JScrollPane scroll = new JScrollPane(userList);
		scroll.setBounds(10, 135, 314, 229);
		scroll.setViewportView(userList);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmLoggedAdmin.getContentPane().add(scroll);
		
		JButton btnViewWeeklyStandings = new JButton("View Standings");
		btnViewWeeklyStandings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLeague leagueWindow = new ViewLeague();
				leagueWindow.StartLeagueTable();
			}
		});
		btnViewWeeklyStandings.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnViewWeeklyStandings.setBounds(7, 91, 117, 23);
		frmLoggedAdmin.getContentPane().add(btnViewWeeklyStandings);
		
		
		JButton btnViewbanUsers = new JButton("View/Ban Users");
		btnViewbanUsers.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnViewbanUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
					aFile = new FileReader("data/Users.txt");
					String[] users;
					in = new Scanner(aFile);
					while (in.hasNext()) {
						users = in.nextLine().split(",");
						userList.append(users[0] + "," + users[1] + "," + users[2] + "\n");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JButton btnSave = new JButton("Save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String details = userList.getText();
						try {
							
							pw = new PrintWriter(new FileWriter("data/Users.txt"), true);
							pw.println(details);
							pw.close();
						}
						
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}		
					}
				});
				btnSave.setBounds(109, 375, 89, 23);
				frmLoggedAdmin.getContentPane().add(btnSave);
				}
			}
		);
		
		btnViewbanUsers.setBounds(132, 91, 114, 23);
		frmLoggedAdmin.getContentPane().add(btnViewbanUsers);
		
		JButton btnViewFixtures = new JButton("View Fixtures");
		btnViewFixtures.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnViewFixtures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aFile = new FileReader("data/Fixtures.txt");
					String[] fixtures;
					in = new Scanner(aFile);
					userList.setText("Week 1 Fixtures:\n");
					while (in.hasNext()) {
						fixtures = in.nextLine().split(",");
						userList.append("Game " + fixtures[0] + ": " + fixtures[1] + " vs " + fixtures[2] + "\n");
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					}
			
		});
		btnViewFixtures.setBounds(259, 91, 115, 23);
		frmLoggedAdmin.getContentPane().add(btnViewFixtures);
		
		JButton btnAddResult = new JButton("Add Result");
		btnAddResult.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAddResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultsPage results = new ResultsPage();
				results.startResults();
			}
			
		});
		btnAddResult.setBounds(388, 91, 115, 23);
		frmLoggedAdmin.getContentPane().add(btnAddResult);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoggedAdmin.hide();
				LoggedInAdmin window1 = new LoggedInAdmin();
				window1.frmLoggedAdmin.setVisible(true);
			}
		});
		btnClear.setBounds(10, 374, 89, 23);
		frmLoggedAdmin.getContentPane().add(btnClear);
	}
}
