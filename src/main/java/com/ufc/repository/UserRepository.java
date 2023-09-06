package com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
