package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class Marshall extends EventAttendee{

	protected Marshall(String name) {
		super(name);
		behaviour = new DontCompete();
	}

}
