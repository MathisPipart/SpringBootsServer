package it.unito.iumtweb.springboot.theme;

import jakarta.persistence.*;

/**
 * Represents a Theme entity in the database.
 * This class is managed by JPA to map Theme objects to a relational database.
 */
@Entity
@Table
public class Theme {

    /**
     * The unique identifier for the Theme.
     * It is automatically generated by the database using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the theme.
     * This field is mandatory and cannot be null.
     */
    @Column(nullable = false)
    private String theme;

    /**
     * Default no-argument constructor.
     * Required by JPA for creating instances via reflection.
     */
    public Theme() {
        // Default constructor required by JPA
    }

    /**
     * Constructs a Theme with the specified attributes.
     *
     * @param id    The unique identifier of the Theme.
     * @param theme The name of the theme.
     */
    public Theme(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    /**
     * Retrieves the unique identifier of the Theme.
     *
     * @return The ID of the Theme.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the Theme.
     *
     * @param id The ID to set for the Theme.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the theme.
     *
     * @return The name of the theme.
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets the name of the theme.
     *
     * @param name The name to set for the Theme.
     */
    public void setTheme(String name) {
        this.theme = name;
    }
}
