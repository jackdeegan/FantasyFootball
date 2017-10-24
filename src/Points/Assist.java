package Points;

public class Assist implements Visitable{
	
private int bonus;
	
	Assist(int score){
	
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
