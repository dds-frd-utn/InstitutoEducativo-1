package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PostService;
import com.example.demo.entity.Post;

@RestController  //indica que es un bean del tipo controlador

public class PostController {
	@Autowired	//Esta es la INYECCION DE DEPENDENCIA del servicio
	PostService postService;
	
	
	//Cuales son las condiciones para el request
	@RequestMapping(value = "/posts", method = RequestMethod.GET, produces = "application/json")
	//Este metodo me va a permitir que devuelva todos los posts
	public List<Post> getPosts() {
		return postService.findAllPost();
	}
	
	
	
	//Esto me permite buscar con el /numid despues del post
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Post> getPost(@PathVariable Long id) {
		return postService.findPostById(id);
	}
	
	@RequestMapping(value = "/posts/title/{title}", method = RequestMethod.GET, produces = "application/json")
	public Post getPost(@PathVariable String title) {
		return postService.findByTitle(title);
	}
	
	//El value lo pueda cambiar con lo que quiera
	@RequestMapping(value = "/posts/add", method = RequestMethod.POST, produces = "application/json")
	public Post addPostPost(Post post) {
		return postService.savePost(post);
	}

	@RequestMapping(value = "/posts/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deletePost(@PathVariable Long id) {
		return postService.deletePost(id);
	}
	
	@RequestMapping(value = "/posts/update", method = RequestMethod.PUT, produces = "application/json")
	public String updatePost(Post post) {
		return postService.updatePost(post);
	}
	
	//@RequestMapping(value = "/posts/deleteAll", method = RequestMethod.DELETE, produces = "application/json")
	//public String deleteAll() {
	//	return postService.deleteAll();
	//}
	
}
