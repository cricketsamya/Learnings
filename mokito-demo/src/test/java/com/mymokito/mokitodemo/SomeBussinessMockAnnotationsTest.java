package com.mymokito.mokitodemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBussinessMockAnnotationsTest {

	@Mock
	DataService mock1;

	@InjectMocks
	SomeBussinessImpl sbi;

	@Test
	public void testFindGreatestFromAllData() {
		// mock1.getAllData() => new int[]{43,54,23,1}
		when(mock1.getAllData()).thenReturn(new int[] { 43, 54, 23, 1 });
		assertEquals(54, sbi.findGreatestFromAllData());
	}

	@Test
	public void testFindGreatestFromAllData_ForOneVal() {
		// mock1.getAllData() => new int[]{43,54,23,1}
		when(mock1.getAllData()).thenReturn(new int[] { 43 });
		assertEquals(43, sbi.findGreatestFromAllData());
	}

	@Test
	public void testFindGreatestFromAllData_NoVal() {
		// mock1.getAllData() => new int[]{43,54,23,1}
		when(mock1.getAllData()).thenReturn(new int[] {});
		assertEquals(0, sbi.findGreatestFromAllData());
	}
}
