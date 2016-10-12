package com.raysono.patterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyProgram {
	public static void main(String[] args) {
		StrategyProgram program = new StrategyProgram();
		program.runMarathon();
		program.runTriathlon();
	}

	private void runMarathon() {
		String eventName = "London marathon";
		Event event = new Event(eventName);

		EventAttendee bill = new Runner("Bill");
		EventAttendee josh = new Runner("Josh");
		EventAttendee lisa = new Marshall("Lisa");
		EventAttendee rupert = new Spectator("Rupert");

		List<EventAttendee> attendees = new ArrayList<>();
		attendees.add(bill);
		attendees.add(josh);
		attendees.add(lisa);
		attendees.add(rupert);

		event.setEventAttendees(attendees);

		executeEvent(event);
	}

	private void runTriathlon() {
		String eventName = "Hawaii triathlon";
		Event event = new Event(eventName);

		EventAttendee bill = new Triathlete("Bill");
		EventAttendee josh = new Triathlete("Josh");
		EventAttendee lisa = new Marshall("Lisa");
		EventAttendee rupert = new Spectator("Rupert");

		List<EventAttendee> attendees = new ArrayList<>();
		attendees.add(bill);
		attendees.add(josh);
		attendees.add(lisa);
		attendees.add(rupert);

		event.setEventAttendees(attendees);

		executeEvent(event);

	}
	private void executeEvent(Event event){
		System.out.println("-----");
		System.out.println(event.getName());
		for (EventAttendee attendee : event.getEventAttendees()){
			attendee.render();
			attendee.competeInEvent();
		}
		System.out.println("-----");
	}
}
