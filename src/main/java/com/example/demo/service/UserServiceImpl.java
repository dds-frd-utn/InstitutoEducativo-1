package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository; // esto permite inyectar dependencias y poder acceder al objeto del spring
									// framework

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User saveUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}

	@Override
	public String deleteUser(Long id) {
		if (userRepository.findById(id) != null) {
			userRepository.deleteById(id);
			return "OK";
		}
		// TODO Auto-generated method stub
		return "ERROR: el id no existe";
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		if (userRepository.findById(user.getId()) != null) {
			userRepository.save(user);
			return "OK";
		}
		return "ERROR: el id no existe";
	}
}
