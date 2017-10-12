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
		frmTeamSetUp.setBounds(100, 100, 476, 426);
		frmTeamSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamSetUp.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblCsFantasyFootball.setBounds(10, 11, 440, 40);
		frmTeamSetUp.getContentPane().add(lblCsFantasyFootball);
		
		JLabel lblSelectYourTeam = new JLabel("Select Your Team");
		lblSelectYourTeam.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblSelectYourTeam.setBounds(31, 80, 145, 30);
		frmTeamSetUp.getContentPane().add(lblSelectYourTeam);
		
		JLabel userLabel = new JLabel("Welcome: " + username);
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		userLabel.setBounds(10, 55, 267, 24);
		frmTeamSetUp.getContentPane().add(userLabel);
		frmTeamSetUp.setBounds(100, 100, 509, 412);
		frmTeamSetUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTeamName = new JLabel("Team Name: ");
		lblTeamName.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTeamName.setBounds(31, 121, 87, 24);
		frmTeamSetUp.getContentPane().add(lblTeamName);
		
		textField = new JTextField();
		textField.setBounds(128, 121, 112, 23);
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
		btnNewButton.setBounds(0, 364, 89, 23);
		frmTeamSetUp.getContentPane().add(btnNewButton);
	}
	

}
