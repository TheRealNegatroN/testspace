package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class Spectator extends EventAttendee{
	protected Spectator(String name) {
		super(name);
		behaviour = new DontCompete();
	}
}
