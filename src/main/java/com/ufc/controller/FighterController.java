package com.ufc.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.entity.Fight;
import com.ufc.entity.Fighter;
import com.ufc.service.FighterService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class FighterController {

	@Autowired
	FighterService fighterService;
	
	@PostMapping("/fighter")
	public ResponseEntity<?> addFighter(@RequestBody Fighter fighter){
		try {
			return new ResponseEntity<>(fighterService.addFighter(fighter), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/fighters")
	public List<Fighter> getAllFighters(){
		return fighterService.getAllFighters();
	}
	
	@GetMapping("/fighter/{id}")
	public Fighter getFighterById(@PathVariable Long id){
		return fighterService.getFighterById(id);
	}
	
	@GetMapping("/fighter/fights/{id}")
	public Set<Fight> getFightsrById(@PathVariable Long id){
		return fighterService.getAllFights(id);
	}
}
