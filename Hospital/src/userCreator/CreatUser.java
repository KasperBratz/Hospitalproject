package userCreator;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import Server.Sha;

public class CreatUser {

	public static void main(String[] args) {
		int lenghtOfSalt=10;
		String password="password1";
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random r = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < lenghtOfSalt; i++) {
			double index = Math.random() * characters.length();
			buffer.append(characters.charAt((int) index));
		}
		try {
			System.out.println(buffer.toString());
			System.out.println(buffer.toString()+Sha.hash256(password,buffer.toString()));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
