package Authentication;

import java.util.List;

public class RemoveAllBans implements Command{
	
	List<BanDevice> AllBans;
	
	public RemoveAllBans(List<BanDevice> newBans){
		
		AllBans = newBans;
	}

	@Override
	public void execute() {

		for(BanDevice Bans : AllBans){
			
			Bans.UnBanUser();
		}
		
	}

	@Override
	public void undo() {
		
		for(BanDevice Bans : AllBans){
			
			Bans.TempBan();
		}
		
	}
	

}
