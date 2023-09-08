package com.ufc.service;

import java.util.Optional;
import java.util.Set;

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

	public Fight createFight(Fight fight) {

		return fightRepository.save(fight);
	}

	public Fight getFightById(Long id) {
		return fightRepository.findById(id).get();
	}

	public String addFighterToFight(Long fightId, Long fighterId1, Long fighterId2) {
		Optional<Fight> fightOp = fightRepository.findById(fightId);
		Optional<Fighter> fighter1Op = fighterRepository.findById(fighterId1);
		Optional<Fighter> fighter2Op = fighterRepository.findById(fighterId2);

		if (fightOp.isPresent()) {
			Fight fight = fightOp.get();
			if (fighter1Op.isPresent() && fighter2Op.isPresent()) {
				Fighter fighter1 = fighter1Op.get();
				Fighter fighter2 = fighter2Op.get();

				fight.setTitle(fighter1.getName() + " vs " + fighter2.getName());

				fight.getFighters().add(fighter1);
				fight.getFighters().add(fighter2);
				fighter1.getFights().add(fight);
				fighter2.getFights().add(fight);

				fightRepository.save(fight);
				fighterRepository.save(fighter1);
				fighterRepository.save(fighter2);
				return "Los peleadores " + fighter1.getName() + " / " + fighter2.getName()
						+ " se añadieron correctamente a la pelea";
			}
		}
		return "No se añadió bien la pelea";

	}

	public Fight addResultFight(Long fightId, Fight results, Long winFighterId, Long lostFighterId) {
		Optional<Fight> fightOp = fightRepository.findById(fightId);
		Optional<Fighter> winFighterOp = fighterRepository.findById(winFighterId);
		Optional<Fighter> lostFighterOp = fighterRepository.findById(lostFighterId);

		if (fightOp.isPresent()) {
			Fight fight = fightOp.get();
			if (winFighterOp.isPresent() && lostFighterOp.isPresent()) {

				// Resultados de la pelea
				Fighter winFighter = winFighterOp.get();
				Fighter lostFighter = lostFighterOp.get();
				fight.setMehtod(results.getMehtod());
				fight.setResult(winFighter.getName() + " gano por " + results.getMehtod() + " en el round "
						+ results.getRound() + " - " + results.getTime() + " al peleador " + lostFighter.getName());
				fight.setRound(results.getRound());
				fight.setTime(results.getTime());

				// Añadir la victoria al peleador que gano y actualizar su record
				winFighter.setWinFights(winFighter.getWinFights() + 1);
				winFighter.updateRecord();

				// Añadir la derrota al peleador que perdió y actualizar su record
				lostFighter.setLostFights(lostFighter.getLostFights() + 1);
				winFighter.updateRecord();

				// Guardar todo
				fighterRepository.save(winFighter);
				fighterRepository.save(lostFighter);

				return fightRepository.save(fight);
			}
		}
		return null;

	}

	public Set<Fighter> getFighterFromFight(Long id) {
		Optional<Fight> fightOp = fightRepository.findById(id);

		if (fightOp.isPresent()) {
			return fightOp.get().getFighters();
		}

		return null;
	}

}
