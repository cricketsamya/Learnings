/**
 * 
 */
package com.myspring.spring.basics.springin5steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author S.Kulkarni
 *
 */
@Service
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm {

	@Override
	public int[] sort(int[] numbers) {
		return numbers;
	}

}
