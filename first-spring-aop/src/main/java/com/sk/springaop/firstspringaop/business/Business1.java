package com.sk.springaop.firstspringaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.springaop.firstspringaop.aspect.TrackTime;
import com.sk.springaop.firstspringaop.data.Dao1;

@Service
public class Business1 {

	@Autowired
	private Dao1 dao1;

	@TrackTime
	public String calculateSomething() {
		return dao1.retreiveSomething();
	}

}
