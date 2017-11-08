package View;

import java.awt.EventQueue;
import League.Fixtures;
import javax.swing.JFrame;
import javax.swing.JLabel;

import League.LeagueCaretaker;
import League.LeagueOriginator;
import League.LeaguePublic;
import League.TeamComponent;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class ViewLeague {

	int currentWeek = 0;
	int savedLeagues = 0;
	LeaguePublic league = new LeaguePublic("LeaderBoard");	
    LeagueCaretaker caretaker = new LeagueCaretaker();//allows adding and retrieval of league states
	LeagueOriginator originator = new LeagueOriginator();//sets values for league, create new mementos, stores league in current memento	
	private JFrame frame;

	public void StartLeagueTable () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLeague window = new ViewLeague();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewLeague() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblView = new JLabel("View League");
		lblView.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblView.setBounds(240, 0, 111, 55);
		frame.getContentPane().add(lblView);
		
		JButton btnNewButton = new JButton("Previous week");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(60, 16, 116, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next Week");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(433, 16, 116, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnGenerateFixtureResults = new JButton("Generate fixture results");
		btnGenerateFixtureResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fixtures newFixtures = new Fixtures();
				originator.set(newFixtures.getTeamList());
				caretaker.addMemento(originator.storeInMemento());
				savedLeagues++;
				currentWeek++;
			}
		});
		btnGenerateFixtureResults.setBounds(382, 547, 167, 25);
		frame.getContentPane().add(btnGenerateFixtureResults);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(60, 547, 116, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblTeamUser = new JLabel("Team User");
		lblTeamUser.setBounds(70, 66, 76, 16);
		frame.getContentPane().add(lblTeamUser);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(167, 66, 56, 16);
		frame.getContentPane().add(lblPlayers);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(443, 66, 56, 16);
		frame.getContentPane().add(lblPoints);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 118, 558, 388);
		frame.getContentPane().add(textArea);
		
		//textArea.append(arg0);
	}
}
