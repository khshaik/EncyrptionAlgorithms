package com.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHAHash {

	private final static String SHA_1 = "SHA-1";
	private final static String SHA_256 = "SHA-256";
	private final static String SHA_384 = "SHA-384";
	private final static String SHA_512 = "SHA-512";

	public static void main(String[] args) throws NoSuchAlgorithmException 
	{
		String passwordToHash = "password";
		byte[] salt = getSalt();

		String securePassword = getSecurePassword(SHA_1, passwordToHash, salt);
		System.out.println("Password encrypted using SHA-1:"+ securePassword);

		securePassword = getSecurePassword(SHA_256, passwordToHash, salt);
		System.out.println("Password encrypted using SHA-256:"+ securePassword);

		securePassword = getSecurePassword(SHA_384, passwordToHash, salt);
		System.out.println("Password encrypted using SHA-384:"+ securePassword);

		securePassword = getSecurePassword(SHA_512, passwordToHash, salt);
		System.out.println("Password encrypted using SHA-512:"+ securePassword);
	}

	private static String getSecurePassword(String algorithm, String passwordToHash, byte[] salt)
	{
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		return generatedPassword;
	}     

	//Add salt
	private static byte[] getSalt() throws NoSuchAlgorithmException
	{
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}
}