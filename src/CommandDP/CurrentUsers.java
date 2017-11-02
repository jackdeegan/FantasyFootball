package CommandDP;

public class CurrentUsers implements BanDevice{

	int warnings = 0;
	@Override
	public void TempBan() {
		System.out.println("User is temporarily banned");
		
	}

	@Override
	public void PermBan() {
		System.out.println("User is permanently banned");

		
	}

	@Override
	public void WarnUser() {
		warnings++;
		if (warnings>=3)
		{
			TempBan();
		}
		System.out.println("User now has " + warnings +" warnings, 3 warnings will lead to temporary bans");

		
	}

	@Override
	public void UnBanUser() {
		System.out.println("User is now unbanned");

		
	}

}
