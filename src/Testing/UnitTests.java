package Testing;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAL.AccessPlayers;
import DAL.AccessTeams;
import DAL.DatabaseService;
import Model.Team;

public class UnitTests {

    private DatabaseService playersDB = new AccessPlayers();
	private DatabaseService teamsDB = new AccessTeams();
	
    @Test
    public void testGoalkeeperList() {
    	
    	String result = ""; 
    	List<String> goalkeeperList = playersDB.getAllGoalkeepers();
    	for (int i = 0; i < goalkeeperList.size(); i++) {
    	
    	}
    	
        try {
        	assertTrue("Team was Found in the DB!", result.equals("Team Created Successfully!"));
            System.out.println("Test 1 Pass [UnitTests Suite]!\nCreated Team was successfully stored in database!");
        }
        catch (AssertionError e) {
            System.out.println("Test 1 Fail [UnitTests Suite]!\nCreated Team could not be found in database!");
            fail();
        }	
    }
    
    //List<String> defenderList = playersDB.getAllDefenders();
	//List<String> midfielderList = playersDB.getAllMidfielders();
	//List<String> forwardList = playersDB.getAllForwards();
    
    private int genRandomNumber() {
    	int maxNum = 5;
    	int newNum = (int) (Math.random() * maxNum);
    	return newNum;
    }

}