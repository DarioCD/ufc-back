package com.ufc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.entity.Fight;
import com.ufc.entity.Fighter;
import com.ufc.repository.FightRepository;
import com.ufc.repository.FighterRepository;

@Service
public class FightService {

	@Autowired
	FightRepository fightRepository;

	@Autowired
	FighterRepository fighterRepository;

	public Fight addFightToFighter(Fight fight, Fighter fighter) {

		fighter.getFights().add(fight);
		fight.setFighter(fighter);

		if (fight.getResult().equals("Win")) {
			fighter.setWinFights(fighter.getWinFights() + 1);
		} else if (fight.getResult().equals("Lost")) {
			fighter.setLostFights(fighter.getLostFights() + 1);
		} else {
			fighter.setDrawFights(fighter.getDrawFights() + 1);
		}

		fighter.updateRecord();

		fighterRepository.save(fighter);
		fightRepository.save(fight);

		return fight;
	}

}
