package it.unito.iumtweb.springboot.crew;

import jakarta.persistence.*;

@Entity
@Table
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Long id;

    @Column(nullable = false) // Each crew member has a role
    private String role;

    @Column // The "name" field is mandatory
    private String name;

    /**
     * No-argument constructor this is necessary otherwise many methods will not work
     */
    public Crew() {
        // Default constructor required by JPA
    }

    /**
     *  constructor this is necessary otherwise many methods will not work
     */
    public Crew(Long id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    // YOU MUST DEFINE THE GETTERS AND SETTERS OR YOUR OBJECTS WILL NOT HAVE ANY VALUE IN THE FIELDS WHEN
    // RECEIVED FROM AXIOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }
}
