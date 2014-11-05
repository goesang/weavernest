package com.forweaver.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebUtil {
	
	public static String convertMD5(String str) {
		// TODO Auto-generated method stub
		String email = str;
		try{
		   MessageDigest md = MessageDigest.getInstance("MD5");
		   byte[] messageDigest = md.digest(email.getBytes());
		   BigInteger number = new BigInteger(1, messageDigest);
		   return number.toString(16);
		 } catch (Exception e) {
			 return "";
		 }

	}
	
	public static String intToTimeString(int time){
		Date date = new Date(time*1000L);
		SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		return df.format(date); 
	}
	
	public static String converter(String str){
		
		return str.replaceAll("\n", "q0@").replaceAll("'", "q1@").replaceAll("\"", "q2@").replaceAll("/", "q3@");
	}
}
