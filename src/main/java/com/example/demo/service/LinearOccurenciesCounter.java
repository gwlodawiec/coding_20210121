package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

public class LinearOccurenciesCounter implements OccurenciesCounter {

	@Override
	public Map<String, Integer> count(String[] input) {
		Map<String, Integer> result = new HashMap<>();

		if (input == null || input.length == 0) {
			return result;
		}

		for (int i = 0; i < input.length; i++) {
			result.merge(input[i], 1, Integer::sum);
		}

		return result;
	}

}
