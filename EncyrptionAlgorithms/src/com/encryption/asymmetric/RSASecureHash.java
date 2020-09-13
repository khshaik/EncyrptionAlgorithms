package com.encryption.asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
public class RSASecureHash {

	static String plainText = "Plain text which must be encrypted by Java RSA Encryption in ECB Mode";

	public static byte[] encrypt (String plainText,PublicKey publicKey ) throws Exception
	{
		//Get Cipher Instance RSA With ECB Mode and OAEPWITHSHA-512ANDMGF1PADDING Padding
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");

		//Initialize Cipher for ENCRYPT_MODE
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		//Perform Encryption
		return cipher.doFinal(plainText.getBytes());
	}

	public static String decrypt (byte[] cipherTextArray, PrivateKey privateKey) throws Exception
	{
		//Get Cipher Instance RSA With ECB Mode and OAEPWITHSHA-512ANDMGF1PADDING Padding
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");

		//Initialize Cipher for DECRYPT_MODE
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		//Perform Decryption
		byte[] decryptedTextArray = cipher.doFinal(cipherTextArray);

		return new String(decryptedTextArray);
	}

	public static KeyPair getGeneratedKeyPair() throws NoSuchAlgorithmException {
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(4096);

		// Generate the KeyPair
		return keyPairGenerator.generateKeyPair();
	}
}