package League;
import Model.Player;
import java.util.ArrayList;
import java.util.Iterator;

public class Team extends TeamComponent{
	
	//Contains teams/league that are added to the ArrayList
	
	ArrayList TeamComponents = new ArrayList();

	private String user;
	private String name;
	private int position;
	private int gamesPlayed;
	private int win;
	private int loss;
	private int points;
	ArrayList <Player> players  = new ArrayList<Player>();
}
