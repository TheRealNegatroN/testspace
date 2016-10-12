package com.raysono.patterns.strategy;

@SuppressWarnings("WeakerAccess")
public class RunCycleSwim implements CompeteBehaviour{
	@Override
	public void compete() {
		System.out.println("First running, then cycling then swimming.");
	}
}
