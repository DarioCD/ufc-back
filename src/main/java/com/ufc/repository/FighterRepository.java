package com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.entity.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Long> {

}
