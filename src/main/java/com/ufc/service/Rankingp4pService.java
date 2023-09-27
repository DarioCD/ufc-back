package com.ufc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.entity.Fighter;
import com.ufc.entity.RankingP4P;
import com.ufc.repository.FighterRepository;
import com.ufc.repository.Rankingp4pRepository;

@Service
public class Rankingp4pService {

	@Autowired
	Rankingp4pRepository rankingp4pRepository;

	@Autowired
	FighterRepository fighterRepository;

	public RankingP4P addFighterToRank(Long idFighter, Long idRanking, Integer rankingNumber) {

		Optional<Fighter> fighter = fighterRepository.findById(idFighter);
		Optional<RankingP4P> rankingp4p = rankingp4pRepository.findById(idRanking);

		if (fighter.isPresent() && rankingp4p.isPresent()) {
			rankingp4p.get().getFighters().add(fighter.get());
			fighter.get().setRankingP4P(rankingp4p.get());
			fighter.get().setRankingNumber(rankingNumber);
			rankingp4pRepository.save(rankingp4p.get());
			fighterRepository.save(fighter.get());

		}

		return rankingp4p.get();
	}

	public List<Fighter> getAllFightersFromRanking(Long idRanking) {
	    Optional<RankingP4P> rankingOptional = rankingp4pRepository.findById(idRanking);
	    
	    if (rankingOptional.isPresent()) {
	        RankingP4P ranking = rankingOptional.get();

	        List<Fighter> fighters = ranking.getFighters()
	                .stream()
	                .sorted(Comparator.comparing(Fighter::getRankingNumber))
	                .collect(Collectors.toList());
	        
	        return fighters;
	    } else {
	        return Collections.emptyList(); 
	    }
	}
	
	public RankingP4P getRankingByFighterId (Long id) {
		Fighter fighter = fighterRepository.findById(id).get();
		return fighter.getRankingP4P();
	}
	
	public List<RankingP4P> getAll () {
		return rankingp4pRepository.findAll();
	}

}
