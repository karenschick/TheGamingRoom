package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Player extends Entity {
	/**
	 * A list of the active teams associated with this player
	 */
	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name to create new Player object
	 * 
	 * @param id   The unique identifier for the player
	 * @param name The name of the player
	 */
	public Player(long id, String name) {
		super(id, name);
	}

	/**
	 * Adds a new team to plyaer's list of teams, or returns existing team attached
	 * to player. Ensures there are no dulplicates by name.
	 * 
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */

	public Team addTeam(String name) {

		// Create an iterator for the teams list
		Iterator<Team> iterator = teams.iterator();
		// Loop through exisiting teams to check for name match
		while (iterator.hasNext()) {
			// Retrieve the next Team object from the list
			Team existingTeam = iterator.next();
			// If team with same name exists, return it
			if (existingTeam.getName().equalsIgnoreCase(name)) {
				return existingTeam;
			}
		}
		// If no matching team found, create new one
		Team newTeam = new Team(GameService.getInstance().getNextTeamId(), name);
		// Add newly created team to the list
		teams.add(newTeam);
		// Return the new team
		return newTeam;

	}

	/**
	 * Returns a string representation of the player, including id and name
	 * 
	 * @return String with player's id and name
	 */
	@Override
	public String toString() {
		return "Player [id=" + getId() + ", name=" + getName() + "]";
	}
}
