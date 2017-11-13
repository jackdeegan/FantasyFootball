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
            System.out.println("Test 1 Fail [UnitTests Suite]!\nCreated Team could not be found in database!");
            fail();
        }
    }
    
    @Test
    public void testCreateInvalidTeam() {
    	
    	int teamSize = 15;
    	List<String> playerList = playersDB.getData();
    	int randNum = genRandomNumber();
    	for (int i = randNum; i < randNum + teamSize; i++)
    	String playerInfo[] = Player.checkPlayer(Integer.toString(invalidPlayer));

        try {
        	assertTrue("Invalid Player Successfully Rejected!", playerInfo == null);
            System.out.println("Test 1 Pass [UnitTests Suite]!\nInvalid Player Selection Successfully Rejected!");
        }
        catch (AssertionError e) {
            System.out.println("Test 1 Fail [UnitTests Suite]!\nCreated Team could not be found in database!");
            fail();
        }	
    }
    
    private int genRandomNumber() {
    	int maxNum = 5;
    	int newNum = (int) (Math.random() * maxNum);
    	return newNum;
    }
}