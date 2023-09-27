package com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.entity.Fighter;
import com.ufc.entity.RankingP4P;
import com.ufc.service.Rankingp4pService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class RankingP4PController {
	
	@Autowired
	Rankingp4pService rankingp4pService;
	
	@PostMapping("/fighterToRankingp4p/{idRanking}/{idFighter}/{rankingNumber}")
	public ResponseEntity<?> addFighter(@PathVariable Long idRanking,@PathVariable Long idFighter, @PathVariable Integer rankingNumber){
		try {
			return new ResponseEntity<>(rankingp4pService.addFighterToRank(idFighter, idRanking, rankingNumber), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/fighters/rankingp4p/{id}")
	public List<Fighter> getAllFighters(@PathVariable Long id){
		return rankingp4pService.getAllFightersFromRanking(id);
	}
	
	@GetMapping("/rankingp4p/fighter/{id}")
	public RankingP4P getRankingByFighterId(@PathVariable Long id){
		return rankingp4pService.getRankingByFighterId(id);
	}
	
	@GetMapping("/rankingp4p")
	public List<RankingP4P> getAll(){
		return rankingp4pService.getAll();
	}

}
