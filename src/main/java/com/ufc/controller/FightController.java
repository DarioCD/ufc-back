package com.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.entity.Fight;
import com.ufc.entity.Fighter;
import com.ufc.service.FightService;
import com.ufc.service.FighterService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class FightController {
	
	@Autowired
	FightService fightService;
	
	@Autowired
	FighterService fighterService;
	
	@PostMapping("/fightToFighter/{id}")
	public ResponseEntity<?> addFighter(@RequestBody Fight fight, @PathVariable Long id){
		
		Fighter fighter = fighterService.getFighterById(id);
		try {
			return new ResponseEntity<>(fightService.addFightToFighter(fight, fighter), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
