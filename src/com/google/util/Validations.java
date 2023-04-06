package com.google.util;

public class Validations {

	public static boolean isEmpty(String data) {
		if (data == null || data.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isAlpha(String data) {
		String alpha = "[a-zA-Z]+"; // min 1 max N
		return data.matches(alpha);
	}
}
