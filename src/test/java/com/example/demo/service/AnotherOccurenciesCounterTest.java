package com.example.demo.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;

import com.example.demo.utils.StringArrayProvider;

public class AnotherOccurenciesCounterTest {
	
	@Test
	public void occurenciesShouldBeCountedProperly() {
		
		OccurenciesCounter counter = new AnotherOccurenciesCounter();
		String[] stringArray = {"a","b","b","b","b","b","d","h","h"};
		Map<String, Integer> result = counter.count(stringArray);
		
		Map<String, Integer> expected = new HashMap<>();
		expected.put("a", 1);
		expected.put("b", 5);
		expected.put("d", 1);
		expected.put("h", 3);
		expected.put("p", 1);
		
		assertThat(result.isEmpty(), is(false));
		
		assertThat(result, IsMapContaining.hasEntry("a", 1));
		assertThat(result, IsMapContaining.hasEntry("b", 5));
		assertThat(result, IsMapContaining.hasEntry("d", 1));
		assertThat(result, IsMapContaining.hasEntry("h", 2));
		//assertThat(result, IsMapContaining.hasEntry("p", 1));
		
		result = counter.count(StringArrayProvider.getSortedArray(1000));
		assertThat(result.isEmpty(), is(false));
		
	}

}
