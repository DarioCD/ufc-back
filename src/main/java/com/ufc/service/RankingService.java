package com.ufc.service;

import java.util.Optional;

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

}
