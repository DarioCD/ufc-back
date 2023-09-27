package com.ufc.service;

import java.time.LocalDateTime;
import java.util.List;
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

	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	public String addFightToEvent(Long eventid, Long fightid) {

		Optional<Event> eventOp = eventRepository.findById(eventid);
		Optional<Fight> fightOp = fightRepository.findById(fightid);

		if (eventOp.isPresent()) {
			Event event = eventOp.get();
			if (fightOp.isPresent()) {
				Fight fight = fightOp.get();
				event.getFights().add(fight);
				fight.setEvent(event);

				eventRepository.save(event);
				fightRepository.save(fight);

				return "Se añadió correctamnte la pelea al evento " + event.getTitle();
			}
		}

		return "No se añadió";
	}

	public Event getEventById(Long id) {
		if (id == null) {
			return null;
		}

		Optional<Event> eventOp = eventRepository.findById(id);

		if (eventOp.isPresent()) {
			return eventOp.get();
		}
		return null;
	}

	public Event getEvenByFightId(Long id) {
		if (id == null) {
			return null;
		}

		Optional<Event> eventOp = eventRepository.findById(id);

		if (eventOp.isPresent()) {
			return eventOp.get();
		}
		return null;
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}
	
	public Optional<Event> findNearestEvent() {
		List<Event> events = eventRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        Optional<Event> nearestEvent = Optional.empty();

        for (Event event : events) {
            LocalDateTime eventDate = event.getFightDate();
            if (eventDate.isAfter(now)) {
                if (!nearestEvent.isPresent() || eventDate.isBefore(nearestEvent.get().getFightDate())) {
                    nearestEvent = Optional.of(event);
                }
            }
        }

        return nearestEvent;
    }

	public List<Fight> getFightByEvent(Long id) {
		Event event = eventRepository.findById(id).get();

		return event.getFights();
	}
}
