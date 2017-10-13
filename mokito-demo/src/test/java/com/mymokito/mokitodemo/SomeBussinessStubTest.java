package com.mymokito.mokitodemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBussinessStubTest {

	@Test
	public void testFindGreatestFromAllData() {
		SomeBussinessImpl sbi = new SomeBussinessImpl(new DataServiceStub());
		int result = sbi.findGreatestFromAllData();
		assertEquals(7, result);
	}

}

class DataServiceStub implements DataService {

	@Override
	public int[] getAllData() {

		return new int[] { 1, 4, 6, 7 };
	}
}