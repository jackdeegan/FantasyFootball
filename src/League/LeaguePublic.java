package League;

import java.util.ArrayList;
import java.util.Iterator;

public class LeaguePublic extends TeamComponent{
	
	ArrayList league = new ArrayList();
	
	public String name;
	public String description;
	
	public LeaguePublic(String newName,String newDescription) {
		name = newName;
		description = newDescription;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void add(LeaguePublic newLeague) {
		league.add(newLeague);
	}
	public void remove(LeaguePublic leagueRemove) {
		league.remove(leagueRemove);
	}
	public LeaguePublic getLeague(int index) {
		return (LeaguePublic)league.get(index);
	}
	public void displayLeagueInfo() {
		System.out.println(getName() + " " + getDescription());
		
		Iterator teamIterator = league.iterator();
	}

}
