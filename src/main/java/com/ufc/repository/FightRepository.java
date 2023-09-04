package com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.entity.Fight;

public interface FightRepository extends JpaRepository<Fight, Long> {

}
