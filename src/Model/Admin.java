package Model;

import Authentication.Role;

public class Admin extends User{
	
	    public Admin(){

	    }

	    public Admin(String username, Role rol ){

	        this.username = username;
	        this.role = rol;
	    }


	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setRole(Role role1){
	        this.role = role1;
	    }

	    public Role getRole(){
	        return this.role;
	    }

	}

