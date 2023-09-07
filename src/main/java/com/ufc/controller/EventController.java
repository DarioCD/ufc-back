package com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.entity.Event;
import com.ufc.service.EventService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class EventController {

	@Autowired
	EventService eventService;

	@PostMapping("/event")
	public Event createEvent(@RequestBody Event event) {
		try {
			return eventService.createEvent(event);
		} catch (Exception e) {
			throw e;
		}
	}

	@PostMapping("/event/{eventId}/{fightId}")
	public String addFightToEvent(@PathVariable Long eventId, @PathVariable Long fightId) {
		try {
			return eventService.addFightToEvent(eventId, fightId);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/event")
	public List<Event> getEvents() {
		try {
			return eventService.getAllEvents();
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/event/{id}")
	public Event getEventById(@PathVariable Long id) {
		try {
			return eventService.getEventById(id);
		} catch (Exception e) {
			throw e;
		}
	}
}
