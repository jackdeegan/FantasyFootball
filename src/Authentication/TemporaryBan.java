package Authentication;

public class TemporaryBan implements Command {
	
	BanDevice ban;
	
	public TemporaryBan(BanDevice newBan){
		ban = newBan;
	}

	@Override
	public void execute() {
		ban.TempBan();
		
	}

	@Override
	public void undo() {
		
		ban.UnBanUser();	
	}
}
