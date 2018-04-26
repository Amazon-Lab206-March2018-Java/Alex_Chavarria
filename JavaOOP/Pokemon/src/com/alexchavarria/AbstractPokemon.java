package com.alexchavarria;

public abstract class AbstractPokemon implements PokemonInterface {
	
	public static void createPokemon(String name, int health, String type) {
		PokemonInterface.createPokemon(name, health, type);
	}
}
