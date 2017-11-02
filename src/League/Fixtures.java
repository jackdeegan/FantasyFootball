package League;

public class Fixtures {
	
	TeamComponent teamList;
	
	public Fixtures(TeamComponent newTeamList) {
		teamList = newTeamList;
	}
	
	public void getTeamList() {
		teamList.displayTeamInfo();
	}

}
