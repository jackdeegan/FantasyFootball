package Points;

import DAL.DatabaseService;
import java.util.*;

public class StrategyPattern {  
	public StrategyPattern() {}
	  
	  public void updatePlayerPoints() { 
	  
	  Context context = new Context(new PlayerConcedes());		
	  
	  DatabaseService db_players = new DatabaseService("data/Players.txt");
	  List<String> player_list = new ArrayList<String>();
	  player_list = db_players.getData();
	  
	  DatabaseService db_fixtures = new DatabaseService("data/Fixtures.txt");
	  List<String> fixture_list = new ArrayList<String>();
	  fixture_list = db_fixtures.getData();
	  
	  DatabaseService db_result = new DatabaseService("data/Results.txt");
	  List<String> result_list = new ArrayList<String>();
	  result_list = db_result.getData();
	  
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
	  
	  for(int i = 0; i < 10; i++) {
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
						db_players.changeData(newRow);
						System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
					 }
					 else if(playerTeam.equals(awayTeam) && homeScore == 2) { //away team concedes 2 goals, deduct -1
							totalDeducted = context.executeStrategy(num1,0); 
							int totalPoints = playerPoints + totalDeducted + 2;
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							db_players.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
					 
					 else if(playerTeam.equals(homeTeam) && awayScore > 2) { //home team concedes more than 2 goals, deduct -2
							totalDeducted = context.executeStrategy(num1,num2); 
							int totalPoints = playerPoints +totalDeducted + 2;
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							db_players.changeData(newRow);
							System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
					 
					 else if(playerTeam.equals(awayTeam) && homeScore > 2) { //away team concedes more than 2 goals, deduct -2
							totalDeducted = context.executeStrategy(num1,num2); 
							int totalPoints = playerPoints + totalDeducted + 2;
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							db_players.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
					 
					 else if(playerTeam.equals(homeTeam) && awayScore < 2) { //home team concedes less than 2 goals, deduct 0;
						 int totalPoints = context.executeStrategy(playerPoints,2);
						 if(awayScore == 0) 
						  		totalPoints = context.executeStrategy(totalPoints,newCL.accept(bPoint));
						 String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
						 db_players.changeData(newRow);
						 System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
					 } 
					 
					 else if(playerTeam.equals(awayTeam) && homeScore < 2) { //away team concedes less than 2 goals, deduct 0;
						 int totalPoints = context.executeStrategy(playerPoints,2); 
						 if(awayScore == 0) 
						  		totalPoints = context.executeStrategy(totalPoints,newCL.accept(bPoint));
						 String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
						 db_players.changeData(newRow);
						 System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
					 } 
				  }
				  
				  if(playerPosition.equals("M")) {
					  
					  if(playerTeam.equals(homeTeam)) {
						  	int totalPoints = context.executeStrategy(playerPoints,2); 
						  	String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							db_players.changeData(newRow);
							System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 } 
					  
					  else if(playerTeam.equals(awayTeam)) {
							int totalPoints = context.executeStrategy(playerPoints,2); 
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							db_players.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
				  }
				  
				  if(playerPosition.equals("F")) {
					  
					  if(playerTeam.equals(homeTeam)) {
						  	int totalPoints = context.executeStrategy(playerPoints,2);
						  	if(homeScore > 0) 
						  		totalPoints = context.executeStrategy(totalPoints,newGoal.accept(bPoint)); 
						  	String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							db_players.changeData(newRow);
							System.out.println("Players Playing at Home: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 } 
					  
					  else if(playerTeam.equals(awayTeam)) {
							int totalPoints = context.executeStrategy(playerPoints,2); 
							if(awayScore > 0) 
								totalPoints = context.executeStrategy(totalPoints,newGoal.accept(bPoint)); 
							String newRow = playerID + "," +playerName+ "," +playerPosition+","+playerInjured+","+playerTeam+","+totalPoints;
							db_players.changeData(newRow);
							System.out.println("Players Playing Away: " +playerName+" Team: "+playerTeam+" Total: "+totalPoints);
						 }
				  }
			  } 
		  }
	  } 
   }
}