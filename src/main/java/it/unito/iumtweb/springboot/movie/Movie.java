package it.unito.iumtweb.springboot.movie;

import jakarta.persistence.*;

@Entity
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération automatique de l'ID
    private Long id;

    @Column(nullable = false) // Le champ "name" est obligatoire
    private String name;

    @Column(nullable = true) // "date" peut être nul, car c'est un entier
    private Integer date;

    @Column(nullable = true) // "tagline" peut être nul
    private String tagline;

    @Column(nullable = true) // "description" peut être nul
    private String description;

    @Column(nullable = true) // "minute" peut être nul
    private Integer minute;

    @Column(nullable = true) // "rating" peut être nul avec précision 3, scale 2
    private Double rating;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Movie() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
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

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
