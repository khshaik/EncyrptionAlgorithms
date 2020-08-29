package com.encryption.test;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.junit.Assert;
import org.junit.Test;

import com.encryption.DESSecureHash;

public class DESSecureHashTest {

	// Generate secret key.
	String ORIGINAL_PASSWORD = "789}Poiu>ZX(*&$#@ASE7612{{+_";

	@Test public void testDESEncryptionDecryption() throws Exception {

		String inputValue = ORIGINAL_PASSWORD;
		System.out.println("Input value:"+ORIGINAL_PASSWORD);

		DESKeySpec key = new DESKeySpec(ORIGINAL_PASSWORD.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

		String encryptedValue = DESSecureHash.encrypt(keyFactory, key, ORIGINAL_PASSWORD);
		System.out.println("Encrypted value:"+encryptedValue);

		String decryptedValue = DESSecureHash.decrypt(keyFactory, key, encryptedValue);
		System.out.println("Decrypted value:"+decryptedValue);		

		Assert.assertTrue("Encrypted and Decrypted values for DES, must be exactly same", inputValue.equals(decryptedValue));
	}
}
