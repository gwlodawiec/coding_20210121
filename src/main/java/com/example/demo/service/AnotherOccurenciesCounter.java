package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.utils.StringArrayProvider;

public class AnotherOccurenciesCounter implements OccurenciesCounter {

	@Override
	public Map<String, Integer> count(String[] input) {
		Map<String, Integer> result = new HashMap<>();

		if (input == null || input.length == 0) {
			return result;
		}
		List<String> asList = Arrays.asList(input);
		int currIndex = -1;
		for (String elem : StringArrayProvider.AVAILABLE_CHARS) {
			//int index = Arrays.binarySearch(input, 0, input.length, elem);
			int index = asList.lastIndexOf(elem);
			if(index > -1) {
				result.put(elem, index - currIndex);
				currIndex = index;
			}
		}
		
		return result;
	}

}
