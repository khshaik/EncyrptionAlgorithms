package com.encryption;

import org.junit.Assert;
import org.junit.Test;

public class SecureHashTest {

	@Test public void testEncryptDecryptNumber() {

		String inputValue = "AXBHi987654KJIO9087";

		String encryptedValue = SecureHash.encrypt(inputValue);
		System.out.println("Encrypted value:"+encryptedValue);

		String decryptedValue =SecureHash.decrypt(encryptedValue);
		System.out.println("Decrypted value:"+decryptedValue);		

		Assert.assertTrue("Encrypted and Decrypted values must be exactly same", inputValue.equals(decryptedValue));
	}
}