package Points;

public class BonusPoint implements Visitor{
	
	public BonusPoint() {}
	
	public int visit(Goal goalBonus){
		System.out.println("Bonus points added for Goal ");
		return goalBonus.getBonusScore();
	}
	
	public int visit(Assist assistBonus){
		System.out.println("Bonus points added for Assist ");
		return assistBonus.getBonusScore();
	}
	
	public int visit(CleanSheet clBonus){
		System.out.println("Bonus points added for Clean Sheet ");
		return clBonus.getBonusScore();
	}
}
