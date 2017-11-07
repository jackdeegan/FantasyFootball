package Points;

import DAL.DatabaseService;
import java.util.*;

public class StrategyPattern {
   public static void main(String[] args) {
	  
	  Context context = new Context(new PlayerConcedes());		
      //if goalie/def concedes 1 or 2 goals num1 = -2
	  //if goalie/def concedes more than 2 goals num2 = -4
	  
	  //get players/fixtures/scores DONE
	  
	  //get home team from fixtures DONE
	  //get away team from fixtures DONE
	  
	  //get home team score from results DONE
	  //get away team score from results DONE
	  
	  //get player position from players DONE
	  //get player team from players DONE
	  
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
	  int homeScore;
	  int awayScore;
	  String playerPosition;
	  String playerTeam;
	  String playerName;
	  
	  int num1 = -1;
	  int num2 = -2;
	  int totalDeducted = 0;
	  
	  /*for(int i = 0; i <= 9; i++) {
		  String fixture = fixture_list.get(i);
		  homeTeam[i] = fixture.substring(fixture.indexOf(",")+1, fixture.indexOf(",")+4);
		  awayTeam[i] = fixture.substring(fixture.indexOf(",")+5,fixture.indexOf(",")+8);
		  System.out.println(homeTeam[i] +" v "+awayTeam[i]);
	  }*/
	  for(int i = 0; i < 10; i++) {
		  String fixture = fixture_list.get(i);
		  homeTeam = fixture.substring(fixture.indexOf(",")+1, fixture.indexOf(",")+4);
		  awayTeam = fixture.substring(fixture.indexOf(",")+5,fixture.indexOf(",")+8);
		  //System.out.println(homeTeam +" v "+awayTeam);
		  for(int j = 0; j < 10; j++) {
			  String result = result_list.get(j);
			  homeScore = Integer.parseInt(result.substring(result.indexOf(",")+1, result.indexOf(",")+2));
			  awayScore = Integer.parseInt(result.substring(result.indexOf(",")+3, result.indexOf(",")+4));
			  //System.out.println(homeScore +" v "+awayScore);
			  for(int k = 0; k < player_list.size();k++) {
				  String player = player_list.get(k);
				  playerTeam = player.substring(player.lastIndexOf(",")-3, player.lastIndexOf(","));
				  playerPosition = player.substring(player.lastIndexOf(",")-7, player.lastIndexOf(",")-6);
				  playerName = player.substring(player.indexOf(",")+1, player.lastIndexOf(",") - 8);
				  
				  if(playerPosition.equals("G") || playerPosition.equals("D")) {
					  
					  //System.out.println(playerTeam + " " +playerName);
					  
					  if(playerTeam.equals(homeTeam) && awayScore == 1 || awayScore == 2) {
						  totalDeducted = context.executeStrategy(num1,0);
						  //System.out.println("WENT TO FIRST IF: " +totalDeducted);
					  }
					  else if(playerTeam.equals(homeTeam) && awayScore > 2) 
						  totalDeducted = context.executeStrategy(num1,num2);
						  
					  
					  else if(playerTeam.equals(awayTeam) && homeScore == 1 || homeScore == 2) {
						  totalDeducted = context.executeStrategy(num1,0);
						  
					  }
					  else if(playerTeam.equals(awayTeam) && homeScore > 2) 
						  totalDeducted = context.executeStrategy(num1,num2);
					  else
						  totalDeducted = context.executeStrategy(0, 0);
					  
					 
				  }  System.out.println(totalDeducted);
			  }
		  }
	  }
	  //System.out.println("Total points" + totalDeducted);
   }
}