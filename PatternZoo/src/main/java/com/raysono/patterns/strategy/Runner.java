package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class Runner extends EventAttendee{

	protected Runner(String name) {
		super(name);
		behaviour = new Run();
	}

}
