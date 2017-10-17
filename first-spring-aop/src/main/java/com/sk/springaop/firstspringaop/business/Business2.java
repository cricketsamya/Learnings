package com.sk.springaop.firstspringaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.springaop.firstspringaop.data.Dao2;

@Service
public class Business2 {

	@Autowired
	private Dao2 dao2;

	public String calculateSomething() {
		return dao2.retreiveSomething();
	}

}
