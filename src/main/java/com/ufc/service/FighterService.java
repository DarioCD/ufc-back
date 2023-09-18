package com.ufc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.entity.Fight;
import com.ufc.entity.Fighter;
import com.ufc.repository.FightRepository;
import com.ufc.repository.FighterRepository;

@Service
public class FighterService {

	@Autowired
	FighterRepository fighterRepository;

	@Autowired
	FightRepository fightRepository;

	public Fighter addFighter(Fighter fighter) {
		fighter.updateRecord();
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
	
	public List<Fighter> getAllChampFighters() {
	    List<Fighter> fighters = fighterRepository.findAll();
	    List<Fighter> champfighters = new ArrayList<>();
	    
	    System.out.println(fighters.size());
	    
	    for (int i = 0; i < fighters.size(); i++) {
	        if (fighters.get(i).getRankingNumber() == 0) {
	            System.out.println("si");
	            champfighters.add(fighters.get(i));
	        }
	    }
	    return champfighters;
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

	public Set<Fight> getAllFights(Long id) {
		if (id == null) {
			return null;
		}
		Optional<Fighter> optional = fighterRepository.findById(id);

		return optional.get().getFights();
	}

	public List<Fighter> getFighterByNameAndNickname(String name, String nickname) {
		List<Fighter> fightersByName = fighterRepository.findByName(name);
		List<Fighter> fightersByNickname = fighterRepository.findByNickname(nickname);

		fightersByName.retainAll(fightersByNickname);

		return fightersByName;
	}

}
