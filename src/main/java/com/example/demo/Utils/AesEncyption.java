package com.example.demo.Utils;

import java.security.Key;
import java.util.Base64;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.mindrot.jbcrypt.BCrypt;

public class AesEncyption {
	

	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'P', 'i', '@', 'a', 'T', 'o', 'm', '#', '$', 't', 'e', 'c', 'h',
			'1', '2', '3' };

	public static String encrypt(String data) {
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(data.getBytes());
			String encodeToString = Base64.getEncoder().encodeToString(encVal);
			if (Pattern.compile("\\/").matcher(encodeToString).find()) {
				encodeToString = encodeToString.replaceAll("/", "_");
			}
//			if (Pattern.compile("+").matcher(encodeToString).find()) {
//				encodeToString = encodeToString.replaceAll("+", "-");
//			}
			return encodeToString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
		private static Key generateKey() throws Exception {
			return new SecretKeySpec(keyValue, ALGO);
		}

		public static String decrypt(String encryptedData) {
			try {
				if (Pattern.compile("_").matcher(encryptedData).find()) {
					encryptedData = encryptedData.replaceAll("_", "/");
				}
				Key key = generateKey();
				Cipher c = Cipher.getInstance(ALGO);
				c.init(Cipher.DECRYPT_MODE, key);
				byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
				byte[] decValue = c.doFinal(decordedValue);
				return new String(decValue);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		

}
