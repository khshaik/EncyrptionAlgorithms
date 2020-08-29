package com.encryption.test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Assert;
import org.junit.Test;

import com.encryption.SCryptSecureHash;

public class SCryptSecureHashTest {

	String  ORIGINAL_PASSWORD = "password";

	@Test public void testSCryptEncryptionDecryption() throws NoSuchAlgorithmException, InvalidKeySpecException {

		System.out.println("Input value:"+ORIGINAL_PASSWORD);

		String encryptedValue = SCryptSecureHash.encrypt(ORIGINAL_PASSWORD);
		System.out.println("Encrypted value:"+encryptedValue);

		boolean decryptedValue = SCryptSecureHash.decrypt(ORIGINAL_PASSWORD, encryptedValue);
		System.out.println("Is the encrypted Password, successfully decrypted:"+decryptedValue);		

		Assert.assertTrue("Encrypted and Decrypted values for SCrypt, must be exactly same", decryptedValue);
	}
}
