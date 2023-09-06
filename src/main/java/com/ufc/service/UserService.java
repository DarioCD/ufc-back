package com.ufc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.entity.User;
import com.ufc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		if (id == null) {
			return null;
		}

		Optional<User> _user = userRepository.findById(id);

		if (_user.isPresent()) {
			return _user.get();
		} else {
			return null;
		}
	}

	public Integer deleteUser(Long id) {
		if (id == null) {
			return 0;
		}
		Optional<User> _user = userRepository.findById(id);
		if (_user.isPresent()) {
			userRepository.deleteById(id);
			return 1;
		} else {
			return 0;
		}
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
