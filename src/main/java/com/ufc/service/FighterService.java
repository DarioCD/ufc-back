package com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.entity.Fighter;
import com.ufc.repository.FighterRepository;

@Service
public class FighterService {

	@Autowired
	FighterRepository fighterRepository;

	public Fighter addFighter(Fighter fighter) {
		fighter.setRecord(fighter.getWinFights() + " - " + fighter.getLostFights());
		return fighterRepository.save(fighter);
	}

	public Fighter getFighterById(Long id) {
		try {
			return fighterRepository.findById(id).get();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Fighter> getAllFighters() {
		return fighterRepository.findAll();
	}

	public int deleteFighter(Long id) {
		try {
			fighterRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public Fighter modifyFighter(Fighter fighter, Long id) {
		return (id != null) ? fighterRepository.findById(id).map(existingFighter -> {
			existingFighter.setName(fighter.getName());
			existingFighter.setWinFights(fighter.getWinFights());
			return fighterRepository.save(existingFighter);
		}).orElse(null) : null;
	}

}
