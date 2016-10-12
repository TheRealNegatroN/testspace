package com.raysono.patterns.strategy;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Event {
	public final String name;
	public List<EventAttendee> eventAttendees;

	public Event(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<EventAttendee> getEventAttendees() {
		return eventAttendees;
	}

	public void setEventAttendees(List<EventAttendee> eventAttendees) {
		this.eventAttendees = eventAttendees;
	}
}
