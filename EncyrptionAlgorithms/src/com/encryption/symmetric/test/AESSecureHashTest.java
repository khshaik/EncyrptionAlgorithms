package com.encryption.symmetric.test;

import org.junit.Assert;
import org.junit.Test;

import com.encryption.symmetric.AES256SecureHash;
import com.encryption.symmetric.AESSecureHash;

public class AESSecureHashTest {

	@Test public void testAESEncryptionDecryption() {

		String inputValue = "AXBHi987654KJIO9087";

		System.out.println("Input value:"+inputValue);

		String encryptedValue = AESSecureHash.encrypt(inputValue);
		System.out.println("Encrypted value:"+encryptedValue);

		String decryptedValue =AESSecureHash.decrypt(encryptedValue);
		System.out.println("Decrypted value:"+decryptedValue);		

		Assert.assertTrue("Encrypted and Decrypted values for AES, must be exactly same", inputValue.equals(decryptedValue));
	}

	@Test public void testAES256EncryptionDecryption() {

		String inputValue = "{0(&UI15998~>/345YUNMBHJIOPER1234";

		System.out.println("Input value:"+inputValue);

		String encryptedValue = AES256SecureHash.encrypt(inputValue);
		System.out.println("Encrypted value:"+encryptedValue);

		String decryptedValue = AES256SecureHash.decrypt(encryptedValue) ;
		System.out.println("Decrypted value:"+decryptedValue);
		
		Assert.assertTrue("Encrypted and Decrypted values for AES256, must be exactly same", inputValue.equals(decryptedValue));
	}
}