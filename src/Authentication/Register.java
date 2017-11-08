package Authentication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Register {
	
private static String username;
		private static String password;
		private PrintWriter pw;
		final private File usersFile = new File("data/Users.txt");
		
		public Register(String usrName, String pasWord){
			
			username = usrName.toLowerCase();
			password = pasWord;
			
		}
		
		public boolean isUserValid() throws IOException{
			// Make sure the username contains alphanumeric, dots, dashes underscores and no spaces or anything else
			usersFile.createNewFile();
			boolean found = false;
			String[] info;
			if(!username.matches("[^a-zA-Z0-9.-_]") || username == null){ // If user matches any char not in the [] 
				
				Scanner in = new Scanner(usersFile);

				while(in.hasNext()){
					info = in.nextLine().split(",");
					if (info[0].equals(username))	 found = true;
				}
				in.close();
				if(found){
					// Some error
					System.out.println("Account already created");
					// Print error out to user, name already in use
					return false;
				}
				else return true;
			}
			System.out.println("Username is invalid");
			// Print error out to user, name contains wrong characters
			return false;
			
		}
		
		public boolean isPassValid() throws IOException{
			// Must have 8 chars, lowercase and caps, numbers. 
			
			if(password.length() < 8){  // Less than 8
				return false;
			}
			if(password.contains(" ")){ // Has a space
				return false;
			}
			if(!password.matches(".*[a-z].*")) {// Missing a lowercase alphabetic char
				return false;
			}
			if(!password.matches(".*[A-Z].*")) {// Missing a uppercase alphabetic char
				return false;
			}
			if(!password.matches(".*[0-9].*")) {// Missing numbers
				return false;
			}
			return true;
		}
		
		public void storeUser() throws Exception{
			
			String Password = Hashing.HashPassword(password);
			
			String details = username + "," + Password + ",1";
			// The 1 is for the type of user. Normal members are 1, sales are 2 and managers as 3.

			pw = new PrintWriter( new FileWriter(usersFile, true));
			pw.println(details);
			pw.close();

		} 
	}


