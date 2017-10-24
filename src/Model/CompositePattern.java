package Model;

import Model.Player;

public class CompositePattern {
	public static void main (String [] args) {
	
	//at the moment i'm hard coding values in for players
	//will use real values in future
	Player goalie = new Player(55,"G", "Jack Deegan", "A", 7);
	Player goalieSub = new Player (78,"G","Shane Kenny", "A", 2);

    Player defender1  = new Player(56,"D", "Kieran Long", "A", 7);
    Player defender2  = new Player(58,"D", "John Roberts", "A", 6);
    Player defender3  = new Player(42,"D", "Brian Walsh", "A", 6);
    Player defender4  = new Player(33,"D", "Troy Dillon", "A", 3);
    Player defenderSub  = new Player(98,"D", "Aaron Moore", "A", 0);

    Player midfielder1 = new Player(29,"M", "Des Bishop", "A", 2);
    Player midfielder2 = new Player(30,"M", "James O'Sullivan", "A", 8);
    Player midfielder3 = new Player(43,"M", "John Aherne", "A", 3);
    Player midfielder4 = new Player(44,"M", "Jacob O'Neill", "A", 3);
    Player midfielderSub = new Player(88,"M", "Paddy Power", "A", 1);

    Player attacker1 = new Player(39,"A", "Paddy Losty", "A", 6);
    Player attacker2 = new Player(72,"A", "Paddy Frosty", "A", 9);
    Player attackerSub = new Player(66,"A", "Seamus Hanz", "A", 0);
    
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

	

