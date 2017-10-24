package Points;

public class Goal implements Visitable{
	
	private int bonus;
	
	Goal(int score){
	
		bonus = score;
	}
	
	public int getBonusScore(){
		
		return bonus;
	}

	@Override
	public int accept(Visitor visitor) {
		
		return visitor.visit(this);
		
	}

}
