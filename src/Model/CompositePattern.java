package Model;

import Model.Player;

public class CompositePattern {
	public static void main (String [] args) {
	
	//at the moment i'm hard coding values in for players
	//will use real values in future
	Player goalie = new Player(55, "Jack Deegan","G", 0, "Manchester United", 7);
	Player goalieSub = new Player (11, "Shane Kenny","G", 0, "Crystal Palace", 1);

    Player defender1  = new Player(21, "Kieran Long","G", 0, "Liverpool", 7);
    Player defender2  = new Player(48, "Brian Walsh","G", 0, "Manchester United", 7);
    Player defender3  = new Player(54, "Troy Dillon","G", 0, "Manchester United", 7);
    Player defender4  = new Player(66, "James Moore","G", 0, "Chelsea", 7);
    Player defenderSub  = new Player(9, "Aaron O Sullivan","G", 0, "Manchester City", 7);

    Player midfielder1 = new Player(76, "Shane Long","G", 0, "Manchester City", 7);
    Player midfielder2 = new Player(34, "Graeme Gullane","G", 0, "Liverpool", 7);
    Player midfielder3 = new Player(22, "Conor Noone","G", 0, "Manchester United", 7);
    Player midfielder4 = new Player(31, "Lord Bendtner","G", 0, "Arsenal", 7);
    Player midfielderSub = new Player(17, "Chris Kamara","G", 0, "Tottenham", 7);

    Player attacker1 = new Player(44, "Paddy Losty","G", 0, "Everton", 7);
    Player attacker2 = new Player(77, "Paddy Frosty","G", 0, "Watford", 7);
    Player attackerSub = new Player(10, "Dan Drake","G", 0, "Manchester United", 7);
    
    goalie.add(goalieSub);
    goalie.add(defender1);
    goalie.add(midfielder1);
    goalie.add(attacker1);
    
    defender1.add(defender2);
    defender1.add(defender3);
    defender1.add(defender4);
    defender1.add(defenderSub);
    
    midfielder1.add(midfielder2);
    midfielder1.add(midfielder3);
    midfielder1.add(midfielder4);
    midfielder1.add(midfielderSub);
    
    attacker1.add(attacker2);
    attacker2.add(attackerSub);

    //print all players on the team
    System.out.println(goalie); 
    
    for (Player start : goalie.getTeamMembers()) {
       System.out.println(start);
       
       for (Player finish : start.getTeamMembers()) {
          System.out.println(finish);
       }
    }		
 }
}

	

