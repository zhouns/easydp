package com.sgepm.easydp.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

public class StringUtils {
	
	public static Double objIsNullToDbl(Object obj) {
		if (obj == null) {
			return null;
		}
		else return Double.parseDouble(obj.toString()); 
	}
	
	public static String objIsNullToStr(Object obj) {
		if (obj == null) {
			return "";
		}
		else return obj.toString();
	}
	
	public static boolean isNullOrEmpty(String s) {
		boolean isNull = false;
		if (s == null || s.equals("")) {
			isNull = true;
		}
		
		return isNull;
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static String toGBK(String resource) throws UnsupportedEncodingException{
		return new String (resource.getBytes(), "GBK");
	}
	
	public static String decodeURI(String resource) throws UnsupportedEncodingException {
		return URLDecoder.decode(URLEncoder.encode(resource, "ISO8859-1"), "UTF-8");
	}
	
	public static String handleId(String ids){
		String[] idArray = ids.split(",");
		String result = "";
		for (int i = 0; i < idArray.length; i++) {
			result += idArray[i] + "','";
		}
		return result.substring(0, result.length() - 3);
	}

}
