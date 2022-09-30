package com.example.demo.entity;

//Voy a tener que hacer uno de estos para cada entidad
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

@Entity // aca le digo que esto va a ser una entidad
@Table(name = "posts") // Aca indico de que tabla vienen estos atributos
public class Post {
	@Id // Aca le digo que este es el identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY) // cuando se crea una nueva entidad te asigna un id
	@Column(name = "id") // asocia cada atributo con el valor de la columna de la tabla
	Long id;
	@Column(name = "title")
	String title;
	@Column(name = "status")
	String status;
	@Column(name = "content")
	String content;
	@ManyToOne(fetch = FetchType.LAZY) // sirve para conectar post con user_id
	// @ManyToOne(optional = false)
	// @JoinColumn(name = "adress", referencedColumnName = "userId")
	@JoinColumn(name = "user_id")
	User author;

//Para crear todos los getters y los setters: click der -> source -> Generate getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// public Long getUser_id() {
	// return user_id;
	// }

	// public void setUser_id(Long user_id) {
	// this.user_id = user_id;
	// }

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
