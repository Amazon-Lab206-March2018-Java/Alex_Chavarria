package com.avvarga.animals.models;

public abstract class Animal {
	protected String name;
	protected String breed;
	protected int weight;
	
	public Animal(String name, String breed, int weight) {
		super();
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
}
