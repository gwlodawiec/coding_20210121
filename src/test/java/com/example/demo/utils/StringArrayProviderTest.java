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

	@Test
	public void shouldReturnProperLastIndexOfCharInArray() {
		String[] stringArray = { "a", "b", "b", "b", "b", "b", "d", "h", "h", "h", "p","x","x" };
		assertTrue(StringArrayProvider.lastIndexOf(stringArray, "a") == 0);
		assertTrue(StringArrayProvider.lastIndexOf(stringArray, "b") == 5);
		assertTrue(StringArrayProvider.lastIndexOf(stringArray, "d") == 6);
		assertTrue(StringArrayProvider.lastIndexOf(stringArray, "h") == 9);
		assertTrue(StringArrayProvider.lastIndexOf(stringArray, "p") == 10);
		assertTrue(StringArrayProvider.lastIndexOf(stringArray, "x") == 12);
	}

}
