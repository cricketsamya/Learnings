package com.mylearnings.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertTest {

	@Test
	public void test() {
		int[] a = new int[] { 1, 2 };
		assertEquals(1, 1);
		assertTrue("a".equals("a"));
		assertFalse("b".equals("a"));
		assertNotNull("string");
		assertNull(null);
		assertArrayEquals(a, new int[] { 1, 2 });
	}
}
