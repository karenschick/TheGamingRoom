package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;
	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;

	/**
	 * Implement singleton pattern to ensure that
	 * GameService class has only one instance and
	 * provides a global point of access to it.
	 */

	// Create an object of GameService
	private static GameService instance = new GameService();

	// Make the constructor private so that GameService class cannot be instantiated
	private GameService() {
	}

	// Provide access to the only object available, ensuring the instance is only
	// created once and subsequent calls return same instance
	public static GameService getInstance() {
		return instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		/**
		 * The Iterator design pattern makes it possible to access elements of game
		 * sequentially without exposing its internal representation. This iterator
		 * enables traversal of the games list to identify whether or not a game object
		 * exists with a matching name, if so it is returned, otherwise, a new game
		 * instance is created and added to the list of games and returned.
		 */

		// Create an iterator for the games list
		Iterator<Game> iterator = games.iterator();
		// While loop continues until there are no more items in list using hasNext to
		// check if there are more elements
		while (iterator.hasNext()) {
			// Retrieve the next Game object from the list
			Game existingGame = iterator.next();
			// If name of current game matches name passed from params using equalIgnoreCase
			if (existingGame.getName().equalsIgnoreCase(name)) {
				return existingGame; // game with same name found, return it
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * 
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		/**
		 * The Iterator design pattern makes it possible to access elements of game
		 * sequentially without exposing its internal representation. This iterator
		 * enables traversal of the games list to identify whether or not a game object
		 * exists with a matching id, if so assign it to the local variable.
		 */
		// Create an iterator for the games list
		Iterator<Game> iterator = games.iterator();
		// While loop continues until there are no more items in list using hasNext to
		// check if there are more elements
		while (iterator.hasNext()) {
			// Retrieve the next Game object from the list
			Game existingGame = iterator.next();
			// If name of current game matches name passed from params using equalIgnoreCase
			if (existingGame.getId() == id) {
				game = existingGame; // assign that instance to the local variable
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		/**
		 * The Iterator design pattern makes it possible to access elements of game
		 * sequentially without exposing its internal representation. This iterator
		 * enables traversal of the games list to identify whether or not a game object
		 * exists with a matching id, if so assign it to the local variable.
		 */

		// Create an iterator for the games list
		Iterator<Game> iterator = games.iterator();
		// While loop continues until there are no more items in list using hasNext to
		// check if there are more elements
		while (iterator.hasNext()) {
			// Retrieve the next Game object from the list
			Game existingGame = iterator.next();
			// If name of current game matches name passed from params using equalIgnoreCase
			if (existingGame.getName().equalsIgnoreCase(name)) {
				game = existingGame; // assign that instance to the local variable
			}
		}
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	public long getNextPlayerId() {
		return nextPlayerId;
	}

	public long getNextTeamId() {
		return nextTeamId;
	}
}
