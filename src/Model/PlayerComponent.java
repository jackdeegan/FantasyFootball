package Model;


//acts as interface for every Player(Leaf) and Team(composite) we create

public abstract class PlayerComponent{
	//public String printTeam(String team);
	
	public void add(PlayerComponent newPlayerComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(PlayerComponent newPlayerComponent) {
		throw new UnsupportedOperationException();
	}
	
	public PlayerComponent getComponent(int componentIndex) {
		throw new UnsupportedOperationException();
	}
	
	public int getPlayerID() {
		throw new UnsupportedOperationException();
	}
	public String getPlayerFName() {
		throw new UnsupportedOperationException();
	}
	
	public String getPlayerLName() {
		throw new UnsupportedOperationException();
	}
	
	public String getPlayerPosition() {
		throw new UnsupportedOperationException();
	}
	
	public int getPlayerInjured() {
		throw new UnsupportedOperationException();
	}
	
	public String getPlayerTeam() {
		throw new UnsupportedOperationException();
	}
	
	public int getPlayerPoints() {
		throw new UnsupportedOperationException();
	}
	
	public String displayPlayerInfo() {
		throw new UnsupportedOperationException();
	}
}