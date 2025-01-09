package it.unito.iumtweb.springboot.detailsMovie;

import jakarta.persistence.*;

/**
 * Represents a DetailsMovie entity in the database.
 * This class is managed by JPA to map DetailsMovie objects to a relational database.
 */
@Entity
@Table
public class DetailsMovie {

    /**
     * The unique identifier for the DetailsMovie.
     */
    @Id
    private Long id;

    /**
     * The name of the movie.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String name;

    private Integer date;
    private String tagline;
    private String description;
    private Integer minute;
    private Double rating;
    private String link;
    private String genres;
    private String actors;
    private String countries;
    private String languages;
    private String releases;
    private String studios;
    private String themes;
    private String crew;

    /**
     * Default no-argument constructor.
     * Required by JPA for creating instances via reflection.
     */
    public DetailsMovie() {
        // Default constructor required by JPA
    }

    /**
     * Constructs a DetailsMovie with all attributes.
     *
     * @param id           The unique identifier of the movie.
     * @param name         The name of the movie.
     * @param date         The release year of the movie.
     * @param tagline      The tagline of the movie.
     * @param description  A brief description of the movie.
     * @param minute       The duration of the movie in minutes.
     * @param rating       The rating of the movie.
     * @param link         A link related to the movie (e.g., trailer).
     * @param genres       The genres of the movie.
     * @param actors       The actors in the movie.
     * @param countries    The countries where the movie was produced.
     * @param languages    The languages of the movie.
     * @param releases     The release dates of the movie.
     * @param studios      The studios involved in the production.
     * @param themes       The themes of the movie.
     * @param crew         The crew involved in the movie production.
     */
    public DetailsMovie(Long id, String name, Integer date, String tagline, String description,
                        Integer minute, Double rating, String link, String genres, String actors,
                        String countries, String languages, String releases, String studios,
                        String themes, String crew) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
        this.link = link;
        this.genres = genres;
        this.actors = actors;
        this.countries = countries;
        this.languages = languages;
        this.releases = releases;
        this.studios = studios;
        this.themes = themes;
        this.crew = crew;
    }

    /**
     * Gets the unique identifier of the movie.
     *
     * @return The ID of the movie.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the movie.
     *
     * @param id The ID to set for the movie.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the movie.
     *
     * @return The name of the movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the movie.
     *
     * @param name The name to set for the movie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the release year of the movie.
     *
     * @return The release year of the movie.
     */
    public Integer getDate() {
        return date;
    }

    /**
     * Sets the release year of the movie.
     *
     * @param date The release year to set for the movie.
     */
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     * Gets the tagline of the movie.
     *
     * @return The tagline of the movie.
     */
    public String getTagline() {
        return tagline;
    }

    /**
     * Sets the tagline of the movie.
     *
     * @param tagline The tagline to set for the movie.
     */
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    /**
     * Gets the description of the movie.
     *
     * @return The description of the movie.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the movie.
     *
     * @param description The description to set for the movie.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the duration of the movie in minutes.
     *
     * @return The duration of the movie in minutes.
     */
    public Integer getMinute() {
        return minute;
    }

    /**
     * Sets the duration of the movie in minutes.
     *
     * @param minute The duration to set for the movie in minutes.
     */
    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    /**
     * Gets the rating of the movie.
     *
     * @return The rating of the movie.
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Sets the rating of the movie.
     *
     * @param rating The rating to set for the movie.
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * Gets the link associated with the movie (e.g., trailer URL).
     *
     * @return The link associated with the movie.
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link associated with the movie.
     *
     * @param link The link to set for the movie.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Gets the genres of the movie.
     *
     * @return The genres of the movie.
     */
    public String getGenres() {
        return genres;
    }

    /**
     * Sets the genres of the movie.
     *
     * @param genres The genres to set for the movie.
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * Gets the actors in the movie.
     *
     * @return The actors in the movie.
     */
    public String getActors() {
        return actors;
    }

    /**
     * Sets the actors in the movie.
     *
     * @param actors The actors to set for the movie.
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * Gets the countries where the movie was produced.
     *
     * @return The countries where the movie was produced.
     */
    public String getCountries() {
        return countries;
    }

    /**
     * Sets the countries where the movie was produced.
     *
     * @param countries The countries to set for the movie.
     */
    public void setCountries(String countries) {
        this.countries = countries;
    }

    /**
     * Gets the languages of the movie.
     *
     * @return The languages of the movie.
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * Sets the languages of the movie.
     *
     * @param languages The languages to set for the movie.
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    /**
     * Gets the release dates of the movie.
     *
     * @return The release dates of the movie.
     */
    public String getReleases() {
        return releases;
    }

    /**
     * Sets the release dates of the movie.
     *
     * @param releases The release dates to set for the movie.
     */
    public void setReleases(String releases) {
        this.releases = releases;
    }

    /**
     * Gets the studios involved in the production of the movie.
     *
     * @return The studios involved in the production.
     */
    public String getStudios() {
        return studios;
    }

    /**
     * Sets the studios involved in the production of the movie.
     *
     * @param studios The studios to set for the movie.
     */
    public void setStudios(String studios) {
        this.studios = studios;
    }

    /**
     * Gets the themes of the movie.
     *
     * @return The themes of the movie.
     */
    public String getThemes() {
        return themes;
    }

    /**
     * Sets the themes of the movie.
     *
     * @param themes The themes to set for the movie.
     */
    public void setThemes(String themes) {
        this.themes = themes;
    }

    /**
     * Gets the crew involved in the movie production.
     *
     * @return The crew involved in the movie production.
     */
    public String getCrew() {
        return crew;
    }
    
    /**
     * Sets the crew involved in the movie production.
     *
     * @param crew The crew to set for the movie production.
     */
    public void setCrew(String crew) {
        this.crew = crew;
    }
}
