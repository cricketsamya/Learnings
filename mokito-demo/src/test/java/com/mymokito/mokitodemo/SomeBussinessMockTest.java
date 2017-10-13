package com.mymokito.mokitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBussinessMockTest {

	@Test
	public void testFindGreatestFromAllData() {
		DataService mock1 = mock(DataService.class);
		// mock1.getAllData() => new int[]{43,54,23,1}
		when(mock1.getAllData()).thenReturn(new int[] { 43, 54, 23, 1 });
		SomeBussinessImpl sbi = new SomeBussinessImpl(mock1);
		int result = sbi.findGreatestFromAllData();
		assertEquals(54, result);
	}

	@Test
	public void testFindGreatestFromAllData_ForOneVal() {
		DataService mock1 = mock(DataService.class);
		// mock1.getAllData() => new int[]{43,54,23,1}
		when(mock1.getAllData()).thenReturn(new int[] { 43 });
		SomeBussinessImpl sbi = new SomeBussinessImpl(mock1);
		int result = sbi.findGreatestFromAllData();
		assertEquals(43, result);
	}
}
