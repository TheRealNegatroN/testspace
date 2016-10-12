package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class EventAttendee {

	protected final String name;
	protected CompeteBehaviour behaviour;

	protected EventAttendee(String name) {
		this.name = name;
	}

	public void competeInEvent(){
		behaviour.compete();
	}

	public void render(){
		System.out.println("My name is " + name + ".");
	}
}
