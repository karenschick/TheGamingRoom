package com.gamingroom;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

	/**
	 * Constructor with an identifier and name to create new Game object
	 * 
	 * @param id   The unique identitifier for the game
	 * @param name The name of the game
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * Returns a string representation of the Game, including id and name
	 * 
	 * @return String with game's id and name
	 */
	@Override
	public String toString() {

		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}

}
