package Model;

public class Test{
	PlayerComponent playerList;
	
	public Test(PlayerComponent newPlayerList) {
		playerList = newPlayerList;
	}
	
	public void getPlayerList() {
		playerList.displayPlayerInfo();
	}
}