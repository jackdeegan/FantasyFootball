package Points;

public class Context {
	   private I_Strategy strategy;

	   public Context(I_Strategy strategy){
	      this.strategy = strategy;
	   }

	   public int executeStrategy(int num1, int num2){
	      return strategy.doOperation(num1, num2);
	   }
	}