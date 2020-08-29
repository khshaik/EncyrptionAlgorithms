package com.encryption;

import org.junit.Assert;
import org.junit.Test;

public class SecureHashTest {

	@Test public void testEncryptDecryptNumber() {

		String inputValue = "AXBHi987654KJIO9087";

		System.out.println("Input value:"+inputValue);

		String encryptedValue = AESSecureHash.encrypt(inputValue);
		System.out.println("Encrypted value:"+encryptedValue);

		String decryptedValue =AESSecureHash.decrypt(encryptedValue);
		System.out.println("Decrypted value:"+decryptedValue);		

		Assert.assertTrue("Encrypted and Decrypted values must be exactly same", inputValue.equals(decryptedValue));
	}
}