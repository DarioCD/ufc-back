package com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.entity.Ranking;

public interface RankingRepository extends JpaRepository<Ranking, Long> {

}
