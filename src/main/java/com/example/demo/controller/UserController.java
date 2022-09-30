package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController

public class UserController {
	@Autowired	//Esta es la INYECCION DE DEPENDENCIA del servicio
	UserService userService;
	
	//Cuales son las condiciones para el request
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	//Este metodo me va a permitir que devuelva todos los posts
	public List<User> getUsers() {
		return userService.findAllUsers();
	}
	
	//Esto me permite buscar con el /numid despues del post
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<User> getUser(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	//El value lo pueda cambiar con lo que quiera
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
	public User addUserUser(User user) {
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/users", method = RequestMethod.DELETE, produces = "application/json")
	public String deletePost(Long id) {
		return userService.deleteUser(id);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json")
	public String updatePost(User user) {
		return userService.updateUser(user);
	}
}
