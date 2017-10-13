package com.mymokito.mokitodemo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

	@Test
	public void testListSize() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(10);
		assertEquals(10, mockList.size());
		assertEquals(10, mockList.size());
	}

	@Test
	public void testListReturnMultiple() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, mockList.size());
		assertEquals(20, mockList.size());
		assertEquals(20, mockList.size());
	}

	@Test
	public void testGet_SpecificParams() {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("someString");
		assertEquals("someString", mockList.get(0));
		assertEquals(null, mockList.get(1));

	}

	@Test
	public void testGet_GenericParams() {
		List mockList = mock(List.class);
		when(mockList.get(Mockito.anyInt())).thenReturn("someString");
		assertEquals("someString", mockList.get(0));
		assertEquals("someString", mockList.get(1));

	}
}
