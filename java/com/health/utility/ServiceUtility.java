package com.health.utility;

import java.io.File;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Date;


//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




public class ServiceUtility {
	
	private static final String SALT="salt";
	private static String uploadDirectory="src/main/resources/static"+"/Media/content/";
	
//	public static BCryptPasswordEncoder passwordEncoder() {
//		
//		return new BCryptPasswordEncoder(12,new SecureRandom(SALT.getBytes()));
//	}/adminPortal_SchoolProject/src/main/resources/static/Media
//	
	public static Timestamp getCurrentTime() {
		
		Date date=new Date();
		long t=date.getTime();
		Timestamp st=new Timestamp(t);

		return st;
	}
	
	
	public static boolean createFolder(String path) {
		boolean status=false;
		if(!new File(path).exists()) {
			status=new File(path).mkdirs();
		}
		return status;
		
	}
}
