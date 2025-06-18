package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	/*
	 * List of active players associated with this team
	 */
	private List<Player> players = new ArrayList<Player>();

	/*
	 * Constructor with an identifier and name to create new Team object
	 * 
	 * @param id The unique identifier for the team
	 * 
	 * @param name The name of the team
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/**
	 * Adds a new player to the team, or returns an exisiting one if player with
	 * same name exists. Ensures there are no dulplicates by name.
	 * 
	 * @name The name of the player to be added
	 * @return the player instance (new or existing)
	 */

	public Player addPlayer(String name) {

		// Create an iterator for the players list
		Iterator<Player> iterator = players.iterator();

		// Loop through exisiting players to check for name match
		while (iterator.hasNext()) {
			// Retrieve the next Player object from the list
			Player existingPlayer = iterator.next();
			// If player with same name exists, return it
			if (existingPlayer.getName().equalsIgnoreCase(name)) {
				return existingPlayer;
			}
		}
		// If not found, create new player and add to list
		Player newPlayer = new Player(GameService.getInstance().getNextPlayerId(), name);
		// Add newly created player to the list
		players.add(newPlayer);
		// Return the new player
		return newPlayer;

	}

	/**
	 * Returns a string representation of the team, including id and name
	 * 
	 * @return String with teams's id and name
	 */
	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
