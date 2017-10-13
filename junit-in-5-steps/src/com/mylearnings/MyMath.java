/**
 * 
 */
package com.mylearnings;

/**
 * @author S.Kulkarni
 *
 */
public class MyMath {

	{
		System.out.println("1");
	}

	{
		System.out.println("2");
	}

	protected int version = 0;

	public MyMath() {
		System.out.println("3");
	}

	public int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}

}
