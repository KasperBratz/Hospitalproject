package Server;

import java.security.*;

public class Sha {
	/**
	 * Returns the SHA-256 hash of the salt and data
	 * @param data the password
	 * @param salt salt that belong to the password
	 * @return 
	 * @throws NoSuchAlgorithmException
	 */
	public static String hash256(String data,String salt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update((salt+data).getBytes());
		return bytesToHex(md.digest());
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte byt : bytes)
			result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(
					1));
		return result.toString();
	}
}