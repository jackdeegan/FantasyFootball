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
		btnLogOut.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnLogOut.setBounds(394, 11, 89, 34);
		frmLoggedUser.getContentPane().add(btnLogOut);
		
		JLabel userLabel = new JLabel("Welcome back: " + currentUser.getUsername());
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		userLabel.setBounds(10, 55, 267, 24);
		frmLoggedUser.getContentPane().add(userLabel);
		frmLoggedUser.setBounds(100, 100, 509, 412);
		frmLoggedUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
