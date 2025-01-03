package it.unito.iumtweb.springboot.theme;

import jakarta.persistence.*;

@Entity
@Table
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Long id;

    @Column(nullable = false) // The "theme" field is mandatory
    private String theme;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Theme() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Theme(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String name) {
        this.theme = name;
    }
}
