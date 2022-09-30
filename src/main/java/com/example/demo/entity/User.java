package com.example.demo.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity  
	@Table(name = "users")
	public class User {
		@Id  //Aca le digo que este es el identificador
		@GeneratedValue(strategy = GenerationType.IDENTITY) //cuando se crea una nueva entidad te asigna un id 
		@Column(name = "id")   //asocia cada atributo con el valor de la columna de la tabla
		Long id;
		@Column(name = "name")
		String name;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public User() {
			super();
		}
		
		
		
		
	}

