package com.ufc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.entity.Fighter;
import com.ufc.entity.Ranking;
import com.ufc.repository.FighterRepository;
import com.ufc.repository.RankingRepository;

@Service
public class RankingService {

	@Autowired
	RankingRepository rankingRepository;

	@Autowired
	FighterRepository fighterRepository;

	public Ranking addFighterToRank(Long idFighter, Long idRanking, Integer rankingNumber) {

		Optional<Fighter> fighter = fighterRepository.findById(idFighter);
		Optional<Ranking> ranking = rankingRepository.findById(idRanking);

		if (fighter.isPresent() && ranking.isPresent()) {
			ranking.get().getFighters().add(fighter.get());
			fighter.get().setRanking(ranking.get());
			fighter.get().setRankingNumber(rankingNumber);

			rankingRepository.save(ranking.get());
			fighterRepository.save(fighter.get());

		}

		return ranking.get();
	}

	public List<Fighter> getAllFightersFromRanking(Long idRanking) {
	    Optional<Ranking> rankingOptional = rankingRepository.findById(idRanking);
	    
	    if (rankingOptional.isPresent()) {
	        Ranking ranking = rankingOptional.get();

	        List<Fighter> fighters = ranking.getFighters()
	                .stream()
	                .sorted(Comparator.comparing(Fighter::getRankingNumber))
	                .collect(Collectors.toList());
	        
	        return fighters;
	    } else {
	        return Collections.emptyList(); 
	    }
	}
	
	public Ranking getRankingByFighterId (Long id) {
		Fighter fighter = fighterRepository.findById(id).get();
		return fighter.getRanking();
	}
	
	public List<Ranking> getAll () {
		return rankingRepository.findAll();
	}

}
