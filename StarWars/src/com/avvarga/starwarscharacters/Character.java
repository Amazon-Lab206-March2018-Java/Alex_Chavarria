package com.avvarga.starwarscharacters;

public class Character {
	
	private String name;
	private int weight;
	private String famous_saying;

	public Character(String n, int w, String fs) {
		name = n;
		weight = w;
		famous_saying = fs;
	}
	
	public Character () {
		name = "No name";
		weight = 0;
		famous_saying = "No quote";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getFamous_saying() {
		return famous_saying;
	}

	public void setFamous_saying(String famous_saying) {
		this.famous_saying = famous_saying;
	}
	
	public String introduce(Character c) {
		return "Hello, "+c.getName()+", I am "+this.name;
	}

}
