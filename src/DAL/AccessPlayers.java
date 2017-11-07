package DAL;

import java.util.ArrayList;
import java.util.List;

public class AccessPlayers  extends DatabaseService  {

    public AccessPlayers() {
        super("./data/Players.txt");

    }
    
    @Override
    public List<String> getAllGoalkeepers() {
    	List<String> goalkeeperList = new ArrayList<String>();
    	goalkeeperList = retrievePositionList("G");
    	return goalkeeperList;
    }
    
    @Override
    public List<String> getAllDefenders() {
    	List<String> defenderList = new ArrayList<String>();
    	defenderList = retrievePositionList("D");
		return defenderList;
    }
    
    @Override
    public List<String> getAllMidfielders() {
    	List<String> midfielderList = new ArrayList<String>();
    	midfielderList = retrievePositionList("M");
		return midfielderList;
    }
    
    @Override
    public List<String> getAllForwards() {
    	List<String> forwardList = new ArrayList<String>();
    	forwardList = retrievePositionList("F");
		return forwardList;
    }
    
    private List<String> retrievePositionList(String pos) {
    	
    	List<String> goalkeeperList = new ArrayList<String>();
    	String rowElements[];
        for(int i = 0; i < data.size(); i++) {
        	rowElements = data.get(i).split(",");
    		if (rowElements[3].equals("G")) {
    			goalkeeperList.add(data.get(i));
    		}
    	}
		return goalkeeperList;
    }
    
}