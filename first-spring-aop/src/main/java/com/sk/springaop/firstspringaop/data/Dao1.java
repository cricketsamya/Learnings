package com.sk.springaop.firstspringaop.data;

import org.springframework.stereotype.Repository;

import com.sk.springaop.firstspringaop.aspect.TrackTime;

@Repository
public class Dao1 {
	@TrackTime
	public String retreiveSomething() {
		return "Dao1";
	}

}
