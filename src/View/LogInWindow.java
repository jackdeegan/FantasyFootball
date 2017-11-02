package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Authentication.Role;
import Model.User;
import Authentication.LogIn;
import View.LoggedInAsUser;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LogInWindow extends MainGUI{

	private JFrame frmLogIn;
	private JTextField unametxtField;
	private JTextField passwordField;
	public static String username;
	private String password;
	public Role role;
	protected static User member;

	/**
	 * Launch the application.
	 */
	public void startLogInWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInWindow window = new LogInWindow();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(new Color(175, 238, 238));
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setHorizontalAlignment(SwingConstants.CENTER);
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblCsFantasyFootball.setBounds(10, 11, 475, 40);
		frmLogIn.getContentPane().add(lblCsFantasyFootball);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblUsername.setBounds(45, 93, 127, 30);
		frmLogIn.getContentPane().add(lblUsername);
		
		unametxtField = new JTextField();
		unametxtField.setFont(new Font("Arial Black", Font.PLAIN, 12));
		unametxtField.setBounds(182, 99, 150, 20);
		frmLogIn.getContentPane().add(unametxtField);
		unametxtField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPassword.setBounds(45, 134, 107, 20);
		frmLogIn.getContentPane().add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(182, 135, 150, 20);
		frmLogIn.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = unametxtField.getText();
				password = passwordField.getText();
				try {
				    member = null;
					member = (User) LogIn.main(username, password);
				} catch (IOException e1) { e1.printStackTrace(); }

				role = (member != null) ? member.getRole() : null;
				if (role == null) {
                	// True if failed, no match.
					JLabel errorLabel = new JLabel();
					errorLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
					errorLabel.setBounds(238, 248, 146, 29);
					errorLabel.setForeground(Color.red);
					frmLogIn.getContentPane().add(errorLabel);
					errorLabel.setText("* Log in failed");
				
				} else if(role.getPlayer()){
					// Success
					LoggedInAsUser window = new LoggedInAsUser();
					frmLogIn.hide();
					window.startLoggedUser();

                }
				else if (role.getAdmin()){
					LoggedInAdmin window = new LoggedInAdmin();
					frmLogIn.hide();
					window.startLoggedAdmin();
				}
				
				else if (role.getBannedUser()){
					BannedView window = new BannedView();
					frmLogIn.hide();
					window.startBannedUser();
				}
				
			}
				
			
		});
		btnSubmit.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnSubmit.setBounds(182, 181, 89, 23);
		frmLogIn.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogIn.hide();
				frame.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnBack.setBounds(0, 364, 89, 23);
		frmLogIn.getContentPane().add(btnBack);
		frmLogIn.setBounds(100, 100, 511, 426);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
