package com.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.service.RankingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class RankingController {
	
	@Autowired
	RankingService rankingService;
	
	@PostMapping("/fighterToRanking/{idRanking}/{idFighter}/{rankingNumber}")
	public ResponseEntity<?> addFighter(@PathVariable Long idRanking,@PathVariable Long idFighter, @PathVariable Integer rankingNumber){
		
		try {
			return new ResponseEntity<>(rankingService.addFighterToRank(idFighter, idRanking, rankingNumber), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
