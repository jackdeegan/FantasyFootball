package Points;

import DAL.AccessPlayers;
import DAL.AccessFixtures;
import DAL.AccessResults;
import DAL.DatabaseService;
import java.util.*;

public class StrategyPattern { 
	private static DatabaseService playersDB = new AccessPlayers();
	private static DatabaseService fixturesDB = new AccessFixtures();
	private static DatabaseService resultsDB = new AccessResults();
	public StrategyPattern() {}
	  
	  
	public void gameWeek() {
		
		List<String> results = new ArrayList<String>();
		results = resultsDB.getData();
		for(int i = 0; i < 380;i++) {
		 String resultTemp = results.get(i);
		 String resultNo = resultTemp.substring(0,resultTemp.indexOf(","));
	     int gameWeek = 2;
	        int gameWeekInt;
	        switch (gameWeek) {
	            case 1:  gameWeekInt = 1;
	            		 if(resultNo.equals("1"))
	            			 updatePlayerPoints(0); //gw1
	                     break;
	            case 2:  gameWeekInt = 2;
	            		 if(resultNo.equals("11"))
	            			 updatePlayerPoints(10); //gw2
	                     break;
	            case 3:  gameWeekInt = 3;
	            		 if(resultNo.equals("21"))
	            			 updatePlayerPoints(20); //gw3
	                     break;
	            case 4:  gameWeekInt = 4;
	            		 if(resultNo.equals("31"))
	            			 updatePlayerPoints(30); //gw4
	            		 break;
	            case 5:  gameWeekInt = 5;
	            		 if(resultNo.equals("41"))
	            			 updatePlayerPoints(40); //gw5
	            		 break;
	            case 6:  gameWeekInt = 6;
       		 			 if(resultNo.equals("51"))
       		 				 updatePlayerPoints(50); //gw6
       		 			 break;
	            case 7:  gameWeekInt = 7;
	            		 if(resultNo.equals("61"))
	            			 updatePlayerPoints(60); //gw7
	                     break;
	            case 8:  gameWeekInt = 8;
	            		 if(resultNo.equals("71"))
	            			 updatePlayerPoints(70); //gw8
	                     break;
	            case 9:  gameWeekInt = 9;
	            		 if(resultNo.equals("81"))
	            			 updatePlayerPoints(80); //gw9
	                     break;
	            case 10: gameWeekInt = 10;
	            		 if(resultNo.equals("91"))
	            			 updatePlayerPoints(90); //gw10
	                     break;
	            case 11: gameWeekInt = 11;
	            		 if(resultNo.equals("101"))
	            			 updatePlayerPoints(100); //gw11
	                     break;
	            case 12: gameWeekInt = 12;
	            		 if(resultNo.equals("111"))
	            			 updatePlayerPoints(110); //gw12
	                     break;
	            default: gameWeekInt = 0;
	                     break;
	        }
		}
		
	}
	
	public void updatePlayerPoints(int gw) { 
	  
	  Context context = new Context(new PlayerConcedes());		
	  
	  List<String> player_list = new ArrayList<String>();
	  player_list = playersDB.getData();
	  
	  List<String> fixture_list = new ArrayList<String>();
	  fixture_list = fixturesDB.getData();
	  
	  List<String> result_list = new ArrayList<String>();
	  result_list = resultsDB.getData();
	  
	  String homeTeam;
	  String awayTeam;
	  int homeScore = 0;
	  int awayScore = 0;
	  String playerPosition;
	  String playerTeam;
	  String playerName;
	  String playerID;
	  String playerInjured;
	  int playerPoints;
	  int num1 = -1;
	  int num2 = -2;
	  int totalDeducted = 0;
	  
	  BonusPoint bPoint = new BonusPoint();
	  Goal newGoal = new Goal(4);
	  CleanSheet newCL = new CleanSheet(3);
	   
	  for(int i = gw; i < gw + 10; i++) {
		  String fixture = fixture_list.get(i);
		  homeTeam = fixture.substring(fixture.indexOf(",")+1, fixture.indexOf(",")+4);
		  awayTeam = fixture.substring(fixture.indexOf(",")+5,fixture.indexOf(",")+8);
		  for(int j = i; j <= i ; j++) {
			  String result = result_list.get(j);
			  homeScore = Integer.parseInt(result.substring(result.indexOf(",")+1, result.indexOf(",")+2));
			  awayScore = Integer.parseInt(result.substring(result.indexOf(",")+3, result.indexOf(",")+4));
			  System.out.println(homeTeam +" v "+awayTeam);
			  System.out.println(homeScore +" v "+awayScore);
			  
			  for(int k = 0; k < player_list.size();k++) {
				  
				  String player = player_list.get(k);
				  
				  playerID = player.substring(0, player.indexOf(","));
				  playerTeam = player.substring(player.lastIndexOf(",")-3, player.lastIndexOf(","));
				  playerPosition = player.substring(player.lastIndexOf(",")-7, player.lastIndexOf(",")-6);
				  playerName = player.substring(player.indexOf(",")+1, player.lastIndexOf(",") - 8);
				  playerPoints = Integer.parseInt(player.substring(player.lastIndexOf(",")+1));
				  playerInjured = player.substring(player.lastIndexOf(",")-5, player.lastIndexOf(",")-4);
				  //System.out.println(playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+playerPoints);
				  
				  if(playerPosition.equals("G") || playerPosition.equals("D")) {
					 
					 if(playerTeam.equals(homeTeam) && awayScore == 2) { //home team concedes 2 goals, deduct -1
						totalDeducted = context.executeStrategy(num1,0); 
						int totalPoints = playerPoints + totalDeducted + 2;
						String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
						playersDB.changeData(newRow);
						System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
					 }
					 else if(playerTeam.equals(awayTeam) && homeScore == 2) { //away team concedes 2 goals, deduct -1
							totalDeducted = context.executeStrategy(num1,0); 
							int totalPoints = playerPoints + totalDeducted + 2;
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							playersDB.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
					 
					 else if(playerTeam.equals(homeTeam) && awayScore > 2) { //home team concedes more than 2 goals, deduct -2
							totalDeducted = context.executeStrategy(num1,num2); 
							int totalPoints = playerPoints +totalDeducted + 2;
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							playersDB.changeData(newRow);
							System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
					 
					 else if(playerTeam.equals(awayTeam) && homeScore > 2) { //away team concedes more than 2 goals, deduct -2
							totalDeducted = context.executeStrategy(num1,num2); 
							int totalPoints = playerPoints + totalDeducted + 2;
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							playersDB.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
					 
					 else if(playerTeam.equals(homeTeam) && awayScore < 2) { //home team concedes less than 2 goals, deduct 0;
						 int totalPoints = context.executeStrategy(playerPoints,2);
						 if(awayScore == 0) 
						  		totalPoints = context.executeStrategy(totalPoints,newCL.accept(bPoint));
						 String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
						 playersDB.changeData(newRow);
						 System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
					 } 
					 
					 else if(playerTeam.equals(awayTeam) && homeScore < 2) { //away team concedes less than 2 goals, deduct 0;
						 int totalPoints = context.executeStrategy(playerPoints,2); 
						 if(homeScore == 0) 
						  		totalPoints = context.executeStrategy(totalPoints,newCL.accept(bPoint));
						 String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
						 playersDB.changeData(newRow);
						 System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
					 } 
				  }
				  
				  if(playerPosition.equals("M")) {
					  
					  if(playerTeam.equals(homeTeam)) {
						  	int totalPoints = context.executeStrategy(playerPoints,2); 
						  	String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							playersDB.changeData(newRow);
							System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 } 
					  
					  else if(playerTeam.equals(awayTeam)) {
							int totalPoints = context.executeStrategy(playerPoints,2); 
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							playersDB.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
				  }
				  
				  if(playerPosition.equals("F")) {
					  
					  if(playerTeam.equals(homeTeam)) {
						  	int totalPoints = context.executeStrategy(playerPoints,2);
						  	if(homeScore > 0) 
						  		totalPoints = context.executeStrategy(totalPoints,newGoal.accept(bPoint)); 
						  	String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							playersDB.changeData(newRow);
							System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 } 
					  
					  else if(playerTeam.equals(awayTeam)) {
							int totalPoints = context.executeStrategy(playerPoints,2); 
							if(awayScore > 0) 
								totalPoints = context.executeStrategy(totalPoints,newGoal.accept(bPoint)); 
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							playersDB.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
				  }
			  } 
		  }
	  } 
   }
}