package Authentication;

import java.util.ArrayList;
import java.util.List;

public class UseRemote {
	
	public static void main(String[]args){
		
		BanDevice newBan = BanRemote.getDevice();
		TemporaryBan tBanCommand = new TemporaryBan(newBan);
		banButton onPressed = new banButton(tBanCommand);
		onPressed.press();
		
		// --------------------------------
		
		PermanentBan pBanCommand = new PermanentBan(newBan);
		onPressed = new banButton(pBanCommand);
		onPressed.press();
		
		// ---------------------------------
		
		WarnUser warnCommand = new WarnUser(newBan);
		onPressed = new banButton(warnCommand);
		onPressed.press();
		onPressed.press();
		
		//-----------------------
		
		CurrentUsers theUsers = new CurrentUsers();
		List<BanDevice> allBans = new ArrayList<BanDevice>();
		
		allBans.add(theUsers);
		RemoveAllBans removeBans = new RemoveAllBans(allBans);
		banButton remove = new banButton(removeBans);
		remove.press();
	}
}
