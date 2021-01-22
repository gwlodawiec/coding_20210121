package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BetterOccurenciesCounter implements OccurenciesCounter {

	@Override
	public Map<String, Integer> count(String[] input) {
		Map<String, Integer> result = new HashMap<>();

		if (input == null || input.length == 0) {
			return result;
		}
		List<String> asList = Arrays.asList(input);
		int currIndex = -1;
		while (currIndex < input.length-1) {
			String elem = input[currIndex + 1];
			int index = asList.lastIndexOf(elem);
			//int index = Arrays.binarySearch(input, currIndex < 0 ? 0 : currIndex, input.length, elem);
			result.put(elem, index - currIndex);
			currIndex = index;
		}
		
		return result;
	}

}
