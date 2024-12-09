package it.unito.iumtweb.springboot.genre;

import jakarta.persistence.*;

@Entity
@Table
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération automatique de l'ID
    private Long id;

    @Column(nullable = false) // Le champ "name" est obligatoire
    private String genre;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Genre() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Genre(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String name) {
        this.genre = name;
    }
}
