package Model;

public class Player {
	
	private int player_id;
	private String player_name;
	private String player_availability;
	private int player_points;

	Player(){
		
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public String getPlayer_availability() {
		return player_availability;
	}

	public void setPlayer_availability(String player_availability) {
		this.player_availability = player_availability;
	}
	
	public int getPlayer_points() {
		return player_points;
	}

	public void setPlayer_points(int player_points) {
		this.player_points = player_points;
	}

}
