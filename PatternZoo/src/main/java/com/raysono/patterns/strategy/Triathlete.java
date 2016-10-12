package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class Triathlete extends EventAttendee{
	protected Triathlete(String name) {
		super(name);
		behaviour = new RunCycleSwim();
	}
}
