package com.encryption;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptSecureHash {

	public static String encrypt(String password) throws NoSuchAlgorithmException
	{
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	public static boolean decrypt(String originalPassword, String generatedSecuredPasswordHash) throws NoSuchAlgorithmException
	{
		return BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
	}
}
