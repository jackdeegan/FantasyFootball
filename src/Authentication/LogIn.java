package Authentication;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Model.Admin;
import Model.User;

public class LogIn {
	
final private static File usersFile = new File("data/Users.txt");
		private static Scanner in;
		
		public static User main(String usrName, String pasWord) throws IOException{

			usersFile.createNewFile();
			in = new Scanner(usersFile);
			
		    String username = usrName.toLowerCase();
		    String password = "";
			
		    String[] info;
			try {
				password = pasWord;
			} catch (Exception e) { e.printStackTrace(); }

		    while(in.hasNext()){

		        info = in.nextLine().split(",");
		        if (info[0].equals(username)) {

		            if (info[1].equals(password)) {

		            	in.close();

						switch (info[2]) {
							case "1":  
								return new Admin(info[0], new Role(info[2]));
							case "2":  
								return new User(info[0], new Role(info[2]));
							
						}

		            }
		        }
		    }
		    in.close();
			return null;
			
		}
	}
