package com.encryption.test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Assert;
import org.junit.Test;

import com.encryption.PBKDF2SecureHash;

public class PBKDF2SecureHashTest {

	String  ORIGINAL_PASSWORD = "password";

	@Test public void testPBKDF2SecureEncryptionDecryption() throws NoSuchAlgorithmException, InvalidKeySpecException {

		System.out.println("Input value:"+ORIGINAL_PASSWORD);

		String encryptedValue = PBKDF2SecureHash.encrypt(ORIGINAL_PASSWORD);
		System.out.println("Encrypted value:"+encryptedValue);

		boolean decryptedValue = PBKDF2SecureHash.decrypt(ORIGINAL_PASSWORD, encryptedValue);
		System.out.println("Is the encrypted Password, successfully decrypted:"+decryptedValue);		

		Assert.assertTrue("Encrypted and Decrypted values for PBKDF2, must be exactly same", decryptedValue);
	}
}