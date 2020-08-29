package com.encryption.test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Assert;
import org.junit.Test;

import com.encryption.BCryptSecureHash;

public class BCryptSecureHashTest {

	String  ORIGINAL_PASSWORD = "password";

	@Test public void testBCryptEncryptionDecryption() throws NoSuchAlgorithmException, InvalidKeySpecException {

		System.out.println("Input value:"+ORIGINAL_PASSWORD);

		String encryptedValue = BCryptSecureHash.encrypt(ORIGINAL_PASSWORD);
		System.out.println("Encrypted value:"+encryptedValue);

		boolean decryptedValue = BCryptSecureHash.decrypt(ORIGINAL_PASSWORD, encryptedValue);
		System.out.println("Is the encrypted Password, successfully decrypted:"+decryptedValue);		

		Assert.assertTrue("Encrypted and Decrypted values for BCrypt, must be exactly same", decryptedValue);
	}
}
