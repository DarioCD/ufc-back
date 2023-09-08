package com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.entity.Fighter;
import java.util.List;


public interface FighterRepository extends JpaRepository<Fighter, Long> {
	
	List<Fighter> findByName(String name);
	List<Fighter> findByNickname(String nickname);

}
