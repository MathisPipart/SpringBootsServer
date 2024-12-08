package it.unito.iumtweb.springboot.actor;

import jakarta.persistence.*;

@Entity
@Table
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération automatique de l'ID
    private Long id;

    @Column(nullable = false) // Le champ "name" est obligatoire
    private String name;

    @Column // chaque acteur a un rôle
    private String role;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Actor() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Actor(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
