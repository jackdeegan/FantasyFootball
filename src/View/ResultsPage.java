package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Model.User;
import java.awt.Color;

public class ResultsPage extends LoggedInAdmin{

	private JFrame frmResults;
	protected static User currentUser = LogInWindow.member;
	public static String username = currentUser.getUsername();
	public JTextArea userlist = new JTextArea();
	private FileReader aFile;
	private Scanner in;
	private PrintWriter pw;
	
	
	/**
	 * Launch the application.
	 */
	public static void startResults() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsPage window = new ResultsPage();
					window.frmResults.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResults = new JFrame();
		frmResults.getContentPane().setBackground(new Color(65, 105, 225));
		frmResults.setBounds(100, 100, 462, 360);
		frmResults.getContentPane().setLayout(null);
		
		JLabel lblCsFantasyFootball = new JLabel("CS4227 Fantasy Football");
		lblCsFantasyFootball.setForeground(new Color(255, 255, 255));
		lblCsFantasyFootball.setHorizontalAlignment(SwingConstants.LEFT);
		lblCsFantasyFootball.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCsFantasyFootball.setBounds(10, 16, 190, 35);
		frmResults.getContentPane().add(lblCsFantasyFootball);
		
		JLabel lblWelcome = new JLabel("Welcome: " + currentUser.getUsername());
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblWelcome.setBounds(224, 21, 183, 24);
		frmResults.getContentPane().add(lblWelcome);
		
		JLabel lblEnterResults = new JLabel("Enter Results:");
		lblEnterResults.setForeground(new Color(255, 255, 255));
		lblEnterResults.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEnterResults.setBounds(10, 50, 105, 26);
		frmResults.getContentPane().add(lblEnterResults);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 87, 350, 175);
		frmResults.getContentPane().add(textArea);
		
			
			JButton btnShow = new JButton("Show");
			btnShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						aFile = new FileReader("data/Fixtures.txt");
						String[] fixtures;
						in = new Scanner(aFile);
						textArea.setText("Week 1 Fixtures:\n");
					
					while (in.hasNext()) {
						fixtures = in.nextLine().split(",");
						textArea.append("Game " + fixtures[0] + ": " + fixtures[1] + " vs " + fixtures[2] + "\n");
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
					
				
			});
			btnShow.setBounds(111, 53, 80, 23);
			frmResults.getContentPane().add(btnShow);
			
			JButton btnSaveResults = new JButton("Save Results");
			btnSaveResults.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String details = textArea.getText();
					List<String> myList = new ArrayList<String>(Arrays.asList(details.split(",")));
					for(int i = 0; i < myList.size();i++) {
						String temp = myList.get(i);
						
					
					
					try {
						
						pw = new PrintWriter(new FileWriter("data/Results1.txt"), true);
						pw.println(details);
						pw.close();
					}
					
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			});
			btnSaveResults.setBounds(10, 273, 105, 23);
			frmResults.getContentPane().add(btnSaveResults);
		
		
		
		
		
	}
}
