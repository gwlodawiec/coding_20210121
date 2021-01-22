package com.example.demo.utils;

import java.util.Arrays;
import java.util.Random;

public class StringArrayProvider {

	public final static String[] AVAILABLE_CHARS = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "w", "x", "y", "z" };

	public static String[] getArray(int size) {

		if (size <= 0) {
			throw new IllegalArgumentException("Array size must be greater than 0");
		}

		String[] result = new String[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
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

	public static int lastIndexOf(String[] array, String elem) {

		int first = 0;
		int last = array.length - 1;

		int result = -1;

		while (first <= last) {
			int middle = (first + last) / 2;
			if (elem.equals(array[middle])) {
				result = middle;
				first = middle + 1;
			} else if (elem.compareTo(array[middle]) < 0) {
				last = middle - 1;
			} else {
				first = middle + 1;
			}
		}
		return result;
	}

}
