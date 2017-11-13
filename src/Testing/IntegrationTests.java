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

public class IntegrationTests {

    private DatabaseService playersDB = new AccessPlayers();
	private DatabaseService teamsDB = new AccessTeams();
	
    @Test
    public void testCreateValidTeam() {
    	
    	String teamName = "testTeam";
    	List<String> goalkeeperList = playersDB.getAllGoalkeepers();
    	List<String> defenderList = playersDB.getAllDefenders();
    	List<String> midfielderList = playersDB.getAllMidfielders();
    	List<String> forwardList = playersDB.getAllForwards();
    	String testTeam = "testName";
    	int randId;
    	for (int i = 0; i < 15; i++) {
    		if (i == 0 || i == 11) {
    			randId = genRandomNumber();
    			String g = goalkeeperList.get(randId);
    			testTeam = testTeam + "," + g.substring(0,g.indexOf(","));
    			goalkeeperList.remove(randId);
    		}
    		else if (i > 0 && i < 5 || i == 12) {
    			randId = genRandomNumber();
    			String d = defenderList.get(randId);
    			testTeam = testTeam + "," + d.substring(0,d.indexOf(","));
    			defenderList.remove(randId);
    		}
    		else if (i > 4 && i < 9 || i == 13) {
    			randId = genRandomNumber();
    			String m = midfielderList.get(randId);
    			testTeam = testTeam + "," + m.substring(0,m.indexOf(","));
    			midfielderList.remove(randId);
    		}
    		else if (i > 8 && i < 11 || i == 14) {
    			randId = genRandomNumber();
    			String f = forwardList.get(randId);
    			testTeam = testTeam + "," + f.substring(0,f.indexOf(","));
    			forwardList.remove(randId);
    		}
    	}
    	
    	String result = Team.checkTeam(testTeam);
        if (result.equals("Team Created Successfully!"))
        	teamsDB.deleteData(teamName);
        try {
        	assertTrue("Team was Found in the DB!", result.equals("Team Created Successfully!"));
            System.out.println("Test 1 Pass [IntegrationTests Suite]!\nCreated Team was successfully stored in database!");
        }
        catch (AssertionError e) {
            System.out.println("Test 1 Fail [IntegrationTests Suite]!\nCreated Team could not be found in database!");
            fail();
        }	
    }
    
    private int genRandomNumber() {
    	int maxNum = 5;
    	int newNum = (int) (Math.random() * maxNum);
    	return newNum;
    }
}