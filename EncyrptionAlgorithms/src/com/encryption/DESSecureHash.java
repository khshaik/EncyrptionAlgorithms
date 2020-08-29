package com.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESSecureHash {  

	/**
	 * Encrypt a string using DES encryption, and return the encrypted
	 * string as a base64 encoded string.
	 * @param unencryptedString The string to encrypt.
	 * @return String The DES encrypted and base 64 encoded string.
	 * @throws Exception If an error occurs.
	 */
	public static String encrypt(SecretKeyFactory keyFactory, DESKeySpec key, String password) throws Exception {

		SecretKey secretKey = keyFactory.generateSecret(key);

		Cipher encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

		// Encode the string into bytes using utf-8
		byte[] unencryptedByteArray = password.getBytes("UTF8");

		// Encrypt
		byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);

		// Encode bytes to base64 to get a string
		byte [] encodedBytes = Base64.encodeBase64(encryptedBytes);

		return new String(encodedBytes);
	}

	/**
	 * Decrypt a base64 encoded, DES encrypted string and return
	 * the unencrypted string.
	 * @param encryptedString The base64 encoded string to decrypt.
	 * @return String The decrypted string.
	 * @throws Exception If an error occurs.
	 */
	public static String decrypt(SecretKeyFactory keyFactory, DESKeySpec key, String encryptedPassword) throws Exception {

		Cipher decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, keyFactory.generateSecret(key));

		// Encode bytes to base64 to get a string
		byte [] decodedBytes = Base64.decodeBase64(encryptedPassword.getBytes());

		// Decrypt
		byte[] unencryptedByteArray = decryptCipher.doFinal(decodedBytes);

		// Decode using utf-8
		return new String(unencryptedByteArray, "UTF8");
	}    
}