package CommandDP;

public class UnBanUser implements Command{
	
	
	BanDevice ban;
	
	public UnBanUser(BanDevice newBan){
		ban = newBan;
	}

	@Override
	public void execute() {
		
		ban.UnBanUser();
		
	}

	@Override
	public void undo() {
		
		ban.TempBan();
		
	}

}
