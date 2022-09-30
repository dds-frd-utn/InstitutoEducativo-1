package com.example.demo.service;

//Este archivo lo que va a permitir es la implementacion de la interfaz PostService
//Hacerlo de esta manera me permite poder agregar funcionalidades facilmente

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

//Con el IMPLEMENTS le indico que con esa clase voy a implementar la interfaz
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository; // esto permite inyectar dependencias y poder acceder al objeto del spring
									// framework

	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Optional<Post> findPostById(Long id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id);
	}

	@Override
	public Post savePost(Post newPost) {
		// TODO Auto-generated method stub
		return postRepository.save(newPost);
	}

	@Override
	public String deletePost(Long id) {
		if (postRepository.findById(id) != null) {
			postRepository.deleteById(id);
			return "OK";
		}
		// TODO Auto-generated method stub
		return "ERROR: el id no existe";
	}

	@Override
	public String updatePost(Post post) {
		// TODO Auto-generated method stub
		if (postRepository.findById(post.getId()) != null) {
			postRepository.save(post);
			return "OK";
		}

		return "ERROR: el id no existe";
	}

	public List<Post> findPostByAutor(Long id) {
		return postRepository.findByAuthorId(id);
	}

	@Override
	public Post findByTitle(String title) {
		return postRepository.findByTitle(title);
	}
	
	//@Override
	//public String deleteAll() {
		//->if (postRepository.findById(id) != null) {
		//	postRepository.deleteAll();
		//	return "OK";
		//->}
		// TODO Auto-generated method stub
		//->return "ERROR: No hay posts";
	//}

}
