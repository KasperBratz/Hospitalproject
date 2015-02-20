package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Login {
	
	HashMap<String, String> logins;
	
	public Login(){
		logins = new HashMap<String, String>();
		parsePasswords();
	}
	
	public void parsePasswords(){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("PasswordFile")));
			String line = br.readLine();
			while(line!=null){
				String[] user = line.split("\t",2);
				logins.put(user[0], user[1]);
				line=br.readLine();
			} 
			br.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkAccess(String uid, String password){
		String pass = logins.get(uid);
		if(pass.compareTo(password)==0){
			return true;
		}
		return false;
	}
	
	
}
