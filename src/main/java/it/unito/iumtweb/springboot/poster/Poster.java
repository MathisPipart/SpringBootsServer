package it.unito.iumtweb.springboot.poster;

import jakarta.persistence.*;

@Entity
@Table
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Long id;

    @Column(nullable = false) // The "link" field is mandatory
    private String link;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Poster() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Poster(Long id, String link) {
        this.id = id;
        this.link = link;
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
