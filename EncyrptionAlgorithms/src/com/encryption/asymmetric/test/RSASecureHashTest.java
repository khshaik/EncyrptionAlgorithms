package com.encryption.asymmetric.test;

import java.security.KeyPair;
import java.util.Base64;

import org.junit.Assert;
import org.junit.Test;

import com.encryption.asymmetric.RSASecureHash;
public class RSASecureHashTest {

    private static String ORIGINAL_TEXT = "Plain text which need to be encrypted by Java RSA Encryption in ECB Mode";
    
	@Test public void testRSAEncryptionDecryption() throws Exception {
		
        // Get an instance of the RSA key generator
    	KeyPair keyPair = RSASecureHash.getGeneratedKeyPair();
        
        // Get the public and private key
        System.out.println("Original Text : "+ORIGINAL_TEXT);
        
        // Encryption.
        byte[] cipherText = RSASecureHash.encrypt(ORIGINAL_TEXT, keyPair.getPublic());
        String encryptedText = Base64.getEncoder().encodeToString(cipherText);
        System.out.println("Encrypted Text: "+encryptedText);
        
        // Decryption.
        String decryptedText = RSASecureHash.decrypt(cipherText, keyPair.getPrivate());
        System.out.println("DeCrypted Text: "+decryptedText);
        
		Assert.assertTrue("Encrypted and Decrypted values for RSA, must be exactly same", ORIGINAL_TEXT.equals(decryptedText));

    }
}