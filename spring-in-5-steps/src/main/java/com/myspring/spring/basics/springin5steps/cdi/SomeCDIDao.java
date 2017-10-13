package com.myspring.spring.basics.springin5steps.cdi;

import javax.inject.Named;

@Named
public class SomeCDIDao {

	public int[] getData() {

		return new int[] { 123, 14, 52 };
	}

}
