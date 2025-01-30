package com.example.projectmanager.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//#region PRIVATE PROPERTIES
	private Long id;
	private String name;
	private String description;
//#endregion

//#region CONSTRUCTORS
	public Project(){}

	public Project(String name, String description)
	{
		setName(name);
		setDescription(description);
	}
//#endregion

//#region GETTERS
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
//#endregion

//#region SETTERS	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//#endregion

//#region PUBLIC METHODS
	@Override
	public String toString(){
		return name
			+ "/n"
			+ description;
	}
//#endregion
}
