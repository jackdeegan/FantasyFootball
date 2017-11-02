package CommandDP;

public class WarnUser implements Command{
	
	
	BanDevice ban;
	
	public WarnUser(BanDevice newBan){
		ban = newBan;
	}

	@Override
	public void execute() {
		
		ban.WarnUser();
		
	}

	@Override
	public void undo() {
		ban.UnBanUser();
		
	}

}
