package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class Run implements CompeteBehaviour{
	@Override
	public void compete() {
		System.out.println("I'm running in the event.");
	}
}
