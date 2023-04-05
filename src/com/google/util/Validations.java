package com.google.util;

public class Validations {

	
	public static boolean isEmpty(String data) {
		if(data == null || data.trim().length() == 0 ) {
			return true;
		}
		return false;
	}
}
