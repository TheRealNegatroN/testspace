package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class DontCompete implements CompeteBehaviour {
	@Override
	public void compete() {
		System.out.println("I'm not competing.");
	}
}
