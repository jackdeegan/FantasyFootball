package Points;

import Model.Player;

public class PlayerConcedes implements I_Strategy{
	   @Override
	   public int doOperation(int num1, int num2) {
		   return num1 + num2;
	   }
	}