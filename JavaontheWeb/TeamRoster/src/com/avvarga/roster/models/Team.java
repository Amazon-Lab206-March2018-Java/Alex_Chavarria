package com.avvarga.roster.models;

import java.util.ArrayList;

public class Team {
	private String team_name;
	private ArrayList<Player> players = new ArrayList <Player> ();

	public Team(String name) {
		this.team_name = name;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}



}
