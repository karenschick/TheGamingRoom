package com.gamingroom;

/**
 * The base class representing an unique id and name
 * 
 * This class is extended by Game, Player, and Team
 * It holds immutable fields for id and name
 */
public class Entity {

    /**
     * Holds the id
     */
    private long id = 1;

    /**
     * Holds the name
     */
    private String name = " ";

    /**
     * Make the constructor private so that Enitity class cannot be instantiated
     * 
     */
    private Entity() {
    }

    /**
     * Public constructor to create Entity with id and name
     * 
     * @param id   The unique identifier for the entity
     * @param name the name of the entity
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retrieves the id of this entity.
     *
     * @return the unique identifier
     */
    public long getId() {
        return id;
    }

    /**
     * Retrieves the name of this entity.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the entity, including id and name
     * 
     * @return String with entity's id and name
     */
    @Override
    public String toString() {
        return "Entity [id=" + getId() + ", name=" + getName() + "]";
    }
}
