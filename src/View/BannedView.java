package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.User;

import java.awt.Color;
import java.awt.SystemColor;

public class BannedView extends LogInWindow{

	private JFrame frmBannedUser;
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();

	/**
	 * Launch the application.
	 */
	public static void startBannedUser() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BannedView window = new BannedView();
					window.frmBannedUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BannedView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBannedUser = new JFrame();
		frmBannedUser.getContentPane().setBackground(new Color(211, 211, 211));
		frmBannedUser.setBounds(100, 100, 571, 467);
		frmBannedUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmBannedUser.getContentPane().setLayout(null);
	
	JLabel label = new JLabel("Hi " + currentUser.getUsername() +", unfortunately you are currently banned!");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(new Color(255, 0, 0));
	label.setFont(new Font("Arial Black", Font.PLAIN, 12));
	label.setBounds(10, 113, 518, 103);
	frmBannedUser.getContentPane().add(label);
	
	
	JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
	lblCsFantasyFootball.setBounds(10, 11, 378, 33);
	lblCsFantasyFootball.setHorizontalAlignment(SwingConstants.LEFT);
	lblCsFantasyFootball.setFont(new Font("Arial Black", Font.BOLD, 25));
	frmBannedUser.getContentPane().add(lblCsFantasyFootball);
	
	JButton btnLogOut = new JButton("Log Out");
	btnLogOut.setBounds(449, 21, 79, 24);
	btnLogOut.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frmBannedUser.hide();
			frame.setVisible(true);
		}
	});
	btnLogOut.setFont(new Font("Arial Black", Font.PLAIN, 9));
	frmBannedUser.getContentPane().add(btnLogOut);

	
	

}
	
	
}
