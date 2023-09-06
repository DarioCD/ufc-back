package com.ufc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.entity.Event;
import com.ufc.entity.Fight;
import com.ufc.repository.EventRepository;
import com.ufc.repository.FightRepository;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	FightRepository fightRepository;
	
	public Event createEvent (Event event) {
		return eventRepository.save(event);
	}
	
	public String addFightToEvent (Long eventid, Long fightid) {
		
		Optional<Event> eventOp = eventRepository.findById(eventid);
		Optional<Fight> fightOp = fightRepository.findById(fightid);
		
		if (eventOp.isPresent()) {
			Event event = eventOp.get();
			if (fightOp.isPresent()) {
				Fight fight = fightOp.get();
				event.getFights().add(fight);
				fight.setEvent(event);
				
				return "Se añadió correctamnte la pelea al evento" + event.getTitle();
			}
		}
		
		return "No se añadió";
	}

}
