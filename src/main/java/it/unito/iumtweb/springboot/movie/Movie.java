package it.unito.iumtweb.springboot.movie;

import jakarta.persistence.*;

/**
 * Represents a Movie entity in the database.
 * This class is managed by JPA to map Movie objects to a relational database.
 */
@Entity
@Table
public class Movie {

    /**
     * The unique identifier for the Movie.
     * It is automatically generated by the database using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the Movie.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The release year of the Movie.
     * This field is optional and can be null.
     */
    @Column(nullable = true)
    private Integer date;

    /**
     * The tagline of the Movie.
     * This field is optional and can be null.
     */
    @Column(nullable = true)
    private String tagline;

    /**
     * A brief description of the Movie.
     * This field is optional and can be null.
     */
    @Column(nullable = true)
    private String description;

    /**
     * The duration of the Movie in minutes.
     * This field is optional and can be null.
     */
    @Column(nullable = true)
    private Integer minute;

    /**
     * The rating of the Movie.
     * This field is optional and can be null.
     * The rating is a double with precision 3 and scale 2.
     */
    @Column(nullable = true)
    private Double rating;

    /**
     * Default no-argument constructor.
     * Required by JPA for creating instances via reflection.
     */
    public Movie() {
        // Default constructor required by JPA
    }

    /**
     * Constructs a Movie with the specified attributes.
     *
     * @param id          The unique identifier of the Movie.
     * @param name        The name of the Movie.
     * @param date        The release year of the Movie.
     * @param tagline     The tagline of the Movie.
     * @param description A brief description of the Movie.
     * @param minute      The duration of the Movie in minutes.
     * @param rating      The rating of the Movie.
     */
    public Movie(Long id, String name, Integer date, String tagline, String description, Integer minute, Double rating) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
    }

    /**
     * Retrieves the unique identifier of the Movie.
     *
     * @return The ID of the Movie.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the Movie.
     *
     * @param id The ID to set for the Movie.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the Movie.
     *
     * @return The name of the Movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Movie.
     *
     * @param name The name to set for the Movie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the release year of the Movie.
     *
     * @return The release year of the Movie.
     */
    public Integer getDate() {
        return date;
    }

    /**
     * Sets the release year of the Movie.
     *
     * @param date The release year to set for the Movie.
     */
    public void setDate(Integer date) {
        this.date = date;
    }


    /**
     * Retrieves the tagline of the Movie.
     *
     * @return The tagline of the Movie.
     */
    public String getTagline() {
        return tagline;
    }

    /**
     * Sets the tagline of the Movie.
     *
     * @param tagline The tagline to set for the Movie.
     */
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    /**
     * Retrieves the description of the Movie.
     *
     * @return The description of the Movie.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Movie.
     *
     * @param description The description to set for the Movie.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the duration of the Movie in minutes.
     *
     * @return The duration of the Movie in minutes.
     */
    public Integer getMinute() {
        return minute;
    }

    /**
     * Sets the duration of the Movie in minutes.
     *
     * @param minute The duration to set for the Movie in minutes.
     */
    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    /**
     * Retrieves the rating of the Movie.
     *
     * @return The rating of the Movie.
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Sets the rating of the Movie.
     *
     * @param rating The rating to set for the Movie.
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

}
