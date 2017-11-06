package Points;

import Model.Player;

public class PlayerConcedes implements I_Strategy{
	   @Override
	   public int doOperation(int num1, int num2) {
		   //num1 = defender/goalie concedes 1 or 2 goal => -2 points
		   //num2 = defender/goalie concedes more than 2 goal -4 points
		   return num1 + num2;
	   }
	}