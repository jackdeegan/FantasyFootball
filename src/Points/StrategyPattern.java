package Points;

public class StrategyPattern {
   public static void main(String[] args) {
	  
	  Context context = new Context(new PlayerConcedes());		
      //if goalie/def concedes 1 or 2 goals num1 = -2
	  //if goalie/def concedes more than 2 goals num2 = -4
	  
	  
	  
	  int num1 = -2;
	  int num2 = -4;
	  int totalDeducted = context.executeStrategy(num1,num2);
	  
	  System.out.println("Total points" + totalDeducted);
   }
}