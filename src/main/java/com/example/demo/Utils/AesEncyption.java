package com.example.demo.Utils;

import org.mindrot.jbcrypt.BCrypt;

public class AesEncyption {
	
	 public static String hashPassword(String password) {
	        String salt = BCrypt.gensalt();
	        String hashedPassword = BCrypt.hashpw(password, salt);
	        return hashedPassword;
	    }
	 

}
