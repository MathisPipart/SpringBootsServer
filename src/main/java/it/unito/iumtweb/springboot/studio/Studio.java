package it.unito.iumtweb.springboot.studio;

import jakarta.persistence.*;

@Entity
@Table
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Long id;

    @Column(nullable = false) // The "studio" field is mandatory
    private String studio;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Studio() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Studio(Long id, String studio) {
        this.id = id;
        this.studio = studio;
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String name) {
        this.studio = name;
    }
}
