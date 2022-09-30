package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Post;

public interface MaterialRepository extends JpaRepository<Post, Long> {

	//El OPTIONAL permite poder manejar los objetos que sean nulos
	void save(Optional<Post> postToUpdate);
	
	
	//el FINDBY (de JPA) es una palabra clave que me permite buscar como si fuera una query (ver info en spring.io)
	//me va a buscar por el id del author (el JPA se ocupa de armar el metodo dentro de la interfaz)
	List<Post> findByAuthorId(Long id);	
	
	//me va a devolver un post cuyo titulo sea exactamente igual al que yo le envio
	Post findByTitle(String title);
	
	//tambien se pueden combinar JPA con queries con el fin de hacerlas mas simples
	
	//-------------------------------------------------------------------------------
	//@Query("delete from Post p where p.status=:draft")
	//Void deleteAll();
	//-------------------------------------------------------------------------------
	
	
	//con este metodo puedo con dos fechas encontrar el post q se publico entre esas fechas(post debe tener un atributo que sea date y en BD)
	//esto lo facilita el FINDBY de JPA que crea una query
	//List<Post> findByPublishedBetween(Date from, Date until);
	
	//SI QUIERO AGREGAR UNA QUERY MANUALMENTE LO TENGO QUE HACER DE ESTA MANERA (con formato hql)
	//						nombre de la clase			el ? me dice que es un parametro y el nro es el orden en el q lo recibe
	//@Query("select p from Post p where p.author.id = ?1 and p.title like ?2")  
	//Post findTopTen(Long id, String title);  //este metodo queda asociado con la query de arriba
}

