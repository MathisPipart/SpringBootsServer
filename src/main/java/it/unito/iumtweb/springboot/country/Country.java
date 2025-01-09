package it.unito.iumtweb.springboot.country;

import jakarta.persistence.*;

/**
 * Represents a Country entity in the database.
 * This class is managed by JPA to map Country objects to a relational database.
 */
@Entity
@Table
public class Country {

    /**
     * The unique identifier for the Country.
     * It is automatically generated by the database using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the Country.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String country;

    /**
     * Default no-argument constructor.
     * Required by JPA for creating instances via reflection.
     */
    public Country() {
        // Default constructor required by JPA
    }

    /**
     * Constructs a Country with the specified ID and name.
     *
     * @param id      The unique identifier of the Country.
     * @param country The name of the Country.
     */
    public Country(Long id, String country) {
        this.id = id;
        this.country = country;
    }

    /**
     * Retrieves the unique identifier of the Country.
     *
     * @return The ID of the Country.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the Country.
     *
     * @param id The ID to set for the Country.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the Country.
     *
     * @return The name of the Country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the name of the Country.
     *
     * @param name The name to set for the Country.
     */
    public void setCountry(String name) {
        this.country = name;
    }
}
