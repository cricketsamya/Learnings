package com.myspring.spring.basics.springin5steps.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeCDIBusinessTest {

	@InjectMocks
	SomeCDIBusiness business;

	@Mock
	SomeCDIDao daoMock;

	@Test
	public void testBasicScenario() {

		Mockito.when(daoMock.getData()).thenReturn(
				new int[] { 14, 5, 6, 834, 234, 1000 });
		int result = business.findGreatest();
		assertEquals(1000, result);
	}

	@Test
	public void testBasicScenario_WithNegative() {

		Mockito.when(daoMock.getData()).thenReturn(
				new int[] { -14, -5, -6, -834, -34, -1000, -12, -23 });
		int result = business.findGreatest();
		assertEquals(-5, result);
	}
}
