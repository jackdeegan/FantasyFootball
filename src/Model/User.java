package Model;

import Authentication.Role;

public class User {
	protected String username;
	protected Role role;
	
	public User() {}
	
    public User(String username, Role rol) {
    	this.username = username;
	    this.role = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
    	this.username = username;
	}
   
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
    	this.role = role;
    }
}


