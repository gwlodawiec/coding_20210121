package com.example.demo.utils;

import java.util.Arrays;
import java.util.Random;

public class StringArrayProvider {
	
	private final static String[] AVAILABLE_CHARS = {"a", "b", "c", "d", "e", 
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "w", "x", "y", "z" };
	
	public static String[] getArray(int size) {
		
		if(size <= 0) {
			throw new IllegalArgumentException("Array size must be greater than 0");
		}
		
		String[] result = new String[size];
		Random random = new Random();
		for(int i = 0; i<size; i++) {
			int nextInt = random.nextInt(25);
			result[i] = AVAILABLE_CHARS[nextInt];
		}
		
		return result;
	}
	
	public static String[] getSortedArray(int size) {
		String[] result = getArray(size);
		Arrays.sort(result);
		
		return result;
	}

}
