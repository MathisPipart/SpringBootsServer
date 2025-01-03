package it.unito.iumtweb.springboot.language;

import jakarta.persistence.*;

@Entity
@Table
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Long id;

    @Column(nullable = false) // The "type" field is mandatory
    private String type;

    @Column(nullable = false)
    private String language;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Language() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Language(Long id, String type, String language) {
        this.id = id;
        this.type = type;
        this.language = language;
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String name) {
        this.language = name;
    }
}
