package Points;

public class Test {
	
	public static void main(String[]args){
		
		BonusPoint test = new BonusPoint();
		Goal defender = new Goal(5);
		Assist midfielder = new Assist(3);
		CleanSheet gk = new CleanSheet(3);
		
		System.out.println("Points scored: " + defender.accept(test));
		System.out.println("Points scored: " + midfielder.accept(test));
		System.out.println("Points scored: " + gk.accept(test));

		
	}

}
