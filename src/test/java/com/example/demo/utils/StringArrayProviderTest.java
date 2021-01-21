package com.example.demo.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringArrayProviderTest {
	
	@Test
	public void testGeneratingArray() {
		String[] result = StringArrayProvider.getSortedArray(1000);
		assertTrue(result.length == 1000);
	}
	
	@Test
	public void shouldThrowIllegalArgumentExceptionOnInputLessThanOrEqualToZero() {
		assertThrows(IllegalArgumentException.class, () -> StringArrayProvider.getArray(0));
		assertThrows(IllegalArgumentException.class, () -> StringArrayProvider.getArray(-1));
	}

}
