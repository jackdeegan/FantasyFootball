package Authentication;

public class PermanentBan implements Command {

	BanDevice ban;
	
	public PermanentBan(BanDevice newBan){
		ban = newBan;
	}
	
	@Override
	public void execute() {
		ban.PermBan();
	}

	@Override
	public void undo() {
		
		ban.UnBanUser();
		
	}

}
