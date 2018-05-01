package com.alexchavarria;

public interface PokemonInterface {
	
	static Pokemon createPokemon(String name, int health, String type) {
		Pokemon newPokemon = new Pokemon(name,health,type);
		return newPokemon;			
	}
	
	static void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(pokemon.getHealth()-10);
	}
	
	static String pokemonInfo(Pokemon pokemon) {
		return "Name: " +pokemon.getName()+ " Health: " +pokemon.getHealth()+" Type: " +pokemon.getType();
	}
	
}
