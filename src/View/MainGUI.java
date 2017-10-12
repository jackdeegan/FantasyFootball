package View;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainGUI {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 511, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateAccount createAccountWindow = new CreateAccount();
				frame.hide();
				createAccountWindow.startCreateAccount();
				
			}
		});
		btnCreateAccount.setBackground(Color.WHITE);
		btnCreateAccount.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnCreateAccount.setBounds(174, 109, 136, 45);
		frame.getContentPane().add(btnCreateAccount);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogInWindow LogInWindow = new LogInWindow();
				frame.hide();
				LogInWindow.startLogInWindow();
			}
		});
		btnNewButton.setBounds(174, 182, 136, 45);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblCsFantastyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantastyFootball.setHorizontalAlignment(SwingConstants.CENTER);
		lblCsFantastyFootball.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblCsFantastyFootball.setBounds(10, 11, 475, 53);
		frame.getContentPane().add(lblCsFantastyFootball);
	}
}
