package Authentication;

public class Role {
	
		private boolean isAdmin = false;
		private boolean isPlayer = false;
		
		// The token can hold the state and the perms of a user. We can check the UI against the perms
		// If the Token has manager as false, then that use cannot purchase more stock for the books.
		// I am considering that I should have different setStates() since a manager will have all perms
		// and sales will have member perms too.
		public Role(String rankNumber){
			
			if(rankNumber.equals("1")) {
				
				this.isAdmin = false;
				this.isPlayer = true;
				
			}
			else if(rankNumber.equals("2")) {
				
				this.isAdmin = true;
				this.isPlayer = false;
			}
			
		}

		public boolean getAdmin(){
			return this.isAdmin;
		}

		public boolean getPlayer(){
			return this.isPlayer;
		}

		

		
	}


