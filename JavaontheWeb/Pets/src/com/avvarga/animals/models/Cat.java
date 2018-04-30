package com.avvarga.animals.models;

public class Cat extends Animal implements Pet {

	public Cat(String name, String breed, int weight) {
		super (name,breed,weight);
	}

	@Override
	public String showAffection() {
		return "Your " + breed + ", " + name + " looked at you with some affection... Or so it seems.";
	}

}
