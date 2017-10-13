package com.mymokito.mokitodemo;

public class SomeBussinessImpl {

	private DataService dataService;

	public SomeBussinessImpl(DataService dataService) {
		this.dataService = dataService;
	}

	public int findGreatestFromAllData() {
		int[] data = dataService.getAllData();
		int largest = 0;
		for (int value : data) {
			if (value > largest) {
				largest = value;
			}
		}
		return largest;
	}
}
