package it.unito.iumtweb.springboot.actor;

import jakarta.persistence.*;

/**
 * Represents an Actor entity in the database.
 * This class is managed by JPA to map Actor objects to a relational database.
 */
@Entity
@Table
public class Actor {

    /**
     * The unique identifier for the Actor.
     * It is automatically generated by the database using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the Actor.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The role of the Actor.
     * This field is optional and can store the actor's specific role or title.
     */
    @Column
    private String role;

    /**
     * Default no-argument constructor.
     * Required by JPA for creating instances via reflection.
     */
    public Actor() {
        // Default constructor required by JPA
    }

    /**
     * Constructs an Actor with the specified ID, name, and role.
     *
     * @param id   The unique identifier of the Actor.
     * @param name The name of the Actor.
     * @param role The role of the Actor.
     */
    public Actor(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    /**
     * Retrieves the unique identifier of the Actor.
     *
     * @return The ID of the Actor.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the Actor.
     *
     * @param id The ID to set for the Actor.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the Actor.
     *
     * @return The name of the Actor.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Actor.
     *
     * @param name The name to set for the Actor.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Retrieves the role of the Actor.
     *
     * @return The role of the Actor.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the Actor.
     *
     * @param role The role to set for the Actor.
     */
    public void setRole(String role) {
        this.role = role;
    }

}
