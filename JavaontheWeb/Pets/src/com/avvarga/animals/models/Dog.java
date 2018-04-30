package com.avvarga.animals.models;

public class Dog extends Animal implements Pet {

	public Dog(String name, String breed, int weight) {
		super(name,breed,weight);
	}

	@Override
	public String showAffection() {
		if (weight < 30) {
			return name + "hopped into your lap!";
		}
		else {
			return name + " curled up next to you!";
		}
	}
}
