package Testing;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAL.AccessPlayers;
import DAL.AccessTeams;
import DAL.DatabaseService;
import Model.Player;
import Model.Team;

public class UnitTests {

    private DatabaseService playersDB = new AccessPlayers();
	private DatabaseService teamsDB = new AccessTeams();
	
    @Test
    public void testSelectInvalidPlayer() {
    	
    	List<String> playerList = playersDB.getData();
    	int randNum = genRandomNumber();
    	int invalidPlayer = playerList.size() + randNum;
    	String playerInfo[] = Player.checkPlayer(Integer.toString(invalidPlayer));

        try {
        	assertTrue("Invalid Player Successfully Rejected!", playerInfo == null);
            System.out.println("Test 1 Pass [UnitTests Suite]!\nInvalid Player Selection Successfully Rejected!");
        }
        catch (AssertionError e) {
            System.out.println("Test 1 Fail [UnitTests Suite]!\nInvalid Player Selection was Accepted!");
            fail();
        }
    }
    
    @Test
    public void testCreateInvalidTeam() {
    	
    	int teamSize = 15;
    	List<String> playerList = playersDB.getData();
    	String result = "";
    	int randNum = genRandomNumber();
    	String teamSelection = "testTeam";
    	for (int i = randNum; i < randNum + teamSize; i++) {
    		 teamSelection = teamSelection + "," + playerList.get(i).substring(0, playerList.get(i).indexOf(","));
    	}
    	result = Team.checkTeam(teamSelection);
        try {
        	assertTrue("Invalid Team Successfully Rejected!", result == "Invalid Team, Please Clear Selections and Try Again!");
            System.out.println("Test 2 Pass [UnitTests Suite]!\nInvalid Team Selection Successfully Rejected!");
        }
        catch (AssertionError e) {
            System.out.println("Test 2 Fail [UnitTests Suite]!\nInvalid Team Selection was Accepted!");
            fail();
        }	
    }
    
    private int genRandomNumber() {
    	int maxNum = 5;
    	int newNum = (int) (Math.random() * maxNum);
    	return newNum;
    }
}