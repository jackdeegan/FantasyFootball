package Points;

public class CleanSheet implements Visitable{
	
private int bonus;
	
	CleanSheet(int score){
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
