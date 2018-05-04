package com.avvarga.starwarscharacters;

public class Main {

	public static void main(String[] args) {
		Character luke = new Character("Luke Skywalker", 140, "I'll never join you!");
		Character obi = new Character("Obi Wan Kenobi", 160, "These are not the droids you're looking for");
		System.out.println(luke.introduce(obi));
	}

}
