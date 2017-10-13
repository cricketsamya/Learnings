package com.myspring.spring.basics.springin5steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCDIBusiness {

	@Inject
	SomeCDIDao someCDIDao;

	public SomeCDIDao getSomeCDIDao() {
		return someCDIDao;
	}

	public void setSomeCDIDao(SomeCDIDao someCDIDao) {
		this.someCDIDao = someCDIDao;
	}

	public int findGreatest() {
		int[] data = someCDIDao.getData();
		int greatest = Integer.MIN_VALUE;
		for (int i : data) {
			if (greatest < i) {
				greatest = i;
			}
		}
		return greatest;
	}

}
