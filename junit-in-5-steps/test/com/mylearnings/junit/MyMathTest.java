package com.mylearnings.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mylearnings.MyMath;

public class MyMathTest {

	MyMath m = new MyMath();

	@Before
	public void before() {
		System.out.println("Before");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

	@Test
	public void sum_withThreeNumbers() {
		System.out.println("Test1");
		assertEquals(6, m.sum(new int[] { 1, 2, 3 }));

	}

	@Test
	public void sum_withOneNumbers() {
		System.out.println("Test2");
		assertEquals(1, m.sum(new int[] { 1 }));

	}

	@Test
	public void sum_withNegativeNumbers() {
		System.out.println("Test3");
		assertEquals(-6, m.sum(new int[] { 1, -1, 3, -9 }));

	}
}
