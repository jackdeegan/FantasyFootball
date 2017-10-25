package Model;

import java.util.ArrayList;
import java.util.List;


public class Team {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String[] getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(String[] player_id) {
		this.player_id = player_id;
	}
	private String[] player_id;
}
	