package com.example.demo.service;
//Aca es donde se va a indicar de que manera nuestro servicio va a funcionar

//Cuales son los metodos que nuestro servicio va a tener (van a estar definidos en la clase)

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Post;

public interface PostService {
	public List<Post> findAllPost();

	public Optional<Post> findPostById(Long id);

	public Post savePost(Post newPost);

	public String deletePost(Long id);

	public String updatePost(Post post);
	
	public Post findByTitle(String title);
	
	//public String deleteAll();

}
