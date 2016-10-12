package com.raysono.patterns.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StragegyTests {

	@Test
	public void canCreateLondonMarathonEvent() {
		String eventName = "London marathon";
		Event event = new Event(eventName);

		assertEquals(event.getName(), eventName);
	}
}