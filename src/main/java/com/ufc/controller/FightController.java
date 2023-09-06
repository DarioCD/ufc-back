package com.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.entity.Fight;
import com.ufc.service.FightService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class FightController {

	@Autowired
	FightService fightService;

	@PostMapping("/fight")
	public Fight createfight(@RequestBody Fight fight) {
		try {
			return fightService.createFight(fight);
		} catch (Exception e) {
			throw e;
		}
	}

	@PostMapping("/fightToFighter/{fightId}/{fighter1Id}/{fighter2Id}")
	public String AddFighterToFight(@PathVariable Long fightId, @PathVariable Long fighter1Id,
			@PathVariable Long fighter2Id) {
		try {
			return fightService.addFighterToFight(fightId, fighter1Id, fighter2Id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/fight/{fightId}")
	public Fight addResultFight(@PathVariable Long fightId, @RequestBody Fight result) {
		try {
			return fightService.addResultFight(fightId, result);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/fight/{id}")
	public Fight getFightById(@PathVariable Long id) {
		try {
			return fightService.getFightById(id);
		} catch (Exception e) {
			throw e;
		}
	}

}
