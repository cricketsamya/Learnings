/**
 * 
 */
package com.myspring.spring.basics.springin5steps.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myspring.spring.basics.springin5steps.SpringIn5StepsBasicApplication;

/**
 * @author S.Kulkarni
 *
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {
	private static Logger LOG = org.slf4j.LoggerFactory
			.getLogger(BinarySearchImpl.class);

	@Autowired
	@Qualifier("quick")
	private SortAlgorithm sortAlgorithm;

	public int binarySearch(int[] numbers, int numbersToSearch) {
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		return 3;
	}

	@PostConstruct
	public void postConstruct() {
		LOG.info("postConstruct");
	}

	@PreDestroy
	public void preDestory() {
		LOG.info("preDestory");
	}
}
