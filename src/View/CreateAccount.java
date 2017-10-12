package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import Authentication.Register;
import View.MainGUI;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends MainGUI{

	private JFrame frmCreateAcc;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	protected static String username;
	private String password;
	private String cpassword;
	public JLabel lblError;
	

	/**
	 * Launch the application.
	 */
	public void startCreateAccount() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
					window.frmCreateAcc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateAcc = new JFrame();
		frmCreateAcc.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCreateAcc.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setBounds(0, 0, 483, 40);
		lblCsFantasyFootball.setHorizontalAlignment(SwingConstants.CENTER);
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.BOLD, 28));
		frmCreateAcc.getContentPane().add(lblCsFantasyFootball);
		
		JLabel lblCreateNewAccount = new JLabel("Create New Account");
		lblCreateNewAccount.setBounds(31, 71, 146, 25);
		lblCreateNewAccount.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmCreateAcc.getContentPane().add(lblCreateNewAccount);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(31, 107, 63, 20);
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmCreateAcc.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(31, 138, 86, 25);
		lblUsername.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmCreateAcc.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(172, 108, 119, 20);
		frmCreateAcc.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 141, 119, 20);
		frmCreateAcc.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(31, 168, 63, 25);
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmCreateAcc.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 171, 119, 20);
		frmCreateAcc.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(172, 274, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username = textField_1.getText().toString();
				password = textField_3.getText().toString();
				cpassword = textField_4.getText().toString();
				lblError = new JLabel();
				lblError.setForeground(Color.red);
			    lblError.setBounds(270, 273, 152, 28);
			    frmCreateAcc.getContentPane().add(lblError);
				if(password.equals(cpassword)){
					
					Register account = new Register(username, password);
					try {
						if (account.isUserValid()) {
							if (account.isPassValid()) {
								account.storeUser();
								JOptionPane.showMessageDialog(null, "New Account Created!\nWelcome " + username + "\nYou can now log in!");
								frmCreateAcc.hide();
								TeamSetUp main = new TeamSetUp();
								main.frmTeamSetUp.setVisible(true);
							}
							else
								lblError.setText("* Password is invalid");
						}
						else
							lblError.setText("* Username is invalid");
							
					} catch (Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Account Invalid");
						
						e1.printStackTrace();
					}

				}
				else{
					// Show the user some error
					lblError.setText("");
					lblError.setText("* Passwords do not match");
				}
			}
		});
				
		btnSubmit.setFont(new Font("Arial Black", Font.BOLD, 12));
		frmCreateAcc.getContentPane().add(btnSubmit);
		
		textField_3 = new JTextField();
		textField_3.setBounds(172, 202, 119, 20);
		frmCreateAcc.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(31, 205, 86, 17);
		lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmCreateAcc.getContentPane().add(lblPassword);
		
		textField_4 = new JTextField();
		textField_4.setBounds(172, 233, 119, 20);
		frmCreateAcc.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblRetypePassword = new JLabel("Retype Password:");
		lblRetypePassword.setBounds(31, 236, 131, 17);
		lblRetypePassword.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmCreateAcc.getContentPane().add(lblRetypePassword);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreateAcc.hide();
				frame.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnBack.setBounds(0, 354, 89, 23);
		frmCreateAcc.getContentPane().add(btnBack);
		frmCreateAcc.setBounds(100, 100, 499, 416);
		frmCreateAcc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
