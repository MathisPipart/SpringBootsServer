package it.unito.iumtweb.springboot.detailsMovie;

import jakarta.persistence.*;

@Entity
@Table
public class DetailsMovie {
    @Id
    private Long id;

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

    public DetailsMovie() {
        // Default constructor required by JPA
    }

    // Constructor
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

    // Getters and setters (required for JPA)
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getReleases() {
        return releases;
    }

    public void setReleases(String releases) {
        this.releases = releases;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }
}
