package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.utils.StringArrayProvider;

public class BetterOccurenciesCounter implements OccurenciesCounter {

	@Override
	public Map<String, Integer> count(String[] input) {
		Map<String, Integer> result = new HashMap<>();

		if (input == null || input.length == 0) {
			return result;
		}
		int currIndex = -1;
		while (currIndex < input.length - 1) {
			String elem = input[currIndex + 1];
			int index = StringArrayProvider.lastIndexOf(input, elem);
			result.put(elem, index - currIndex);
			currIndex = index;
		}

		return result;
	}

}
