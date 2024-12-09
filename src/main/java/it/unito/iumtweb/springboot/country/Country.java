package it.unito.iumtweb.springboot.country;

import jakarta.persistence.*;

@Entity
@Table
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération automatique de l'ID
    private Long id;

    @Column(nullable = false) // Le champ "name" est obligatoire
    private String country;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Country() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Country(Long id, String country) {
        this.id = id;
        this.country = country;
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String name) {
        this.country = name;
    }
}
