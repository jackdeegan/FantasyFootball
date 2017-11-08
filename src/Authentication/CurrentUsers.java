package Authentication;

import javax.swing.JOptionPane;

public class CurrentUsers implements BanDevice{

	int warnings = 0;
	@Override
	public void TempBan() {
		System.out.println("Your account temporarily banned");		
	}

	@Override
	public void PermBan() {
		System.out.println("Your account is permanently banned");
	}

	@Override
	public void WarnUser() {
		warnings++;
		if (warnings>=3)
		{
			TempBan();
		}
		else 
			JOptionPane.showMessageDialog(null, "User now has " + warnings +" warnings, 3 warnings will lead to temporary bans");
	}

	@Override
	public void UnBanUser() {
		JOptionPane.showMessageDialog(null, "Your account is now unbanned\n " + "\nYou can now log in!");
	}
}