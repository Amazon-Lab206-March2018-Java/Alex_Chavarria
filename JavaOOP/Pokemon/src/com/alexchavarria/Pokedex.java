package com.alexchavarria;

public class Pokedex extends AbstractPokemon{
	
	public String pokemonInfo(Pokemon pokemon) {
		return "Name: " +pokemon.getName()+ " Health: " +pokemon.getHealth()+" Type: " +pokemon.getType();
	}
	
}
