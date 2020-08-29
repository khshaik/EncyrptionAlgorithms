package com.encryption;

import java.security.NoSuchAlgorithmException;

import com.lambdaworks.crypto.SCryptUtil;

public class SCryptSecureHash {

	public static String encrypt(String password) throws NoSuchAlgorithmException
	{
		return SCryptUtil.scrypt(password, 16, 16, 16);
	}

	public static boolean decrypt(String originalPassword, String generatedSecuredPasswordHash) throws NoSuchAlgorithmException
	{
		return SCryptUtil.check(originalPassword, generatedSecuredPasswordHash);
	}
}
