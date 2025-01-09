package it.unito.iumtweb.springboot.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Country entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface CountryRepository extends JpaRepository<it.unito.iumtweb.springboot.country.Country, Long> {

    /**
     * Retrieves a list of countries whose name matches the specified name, ignoring case.
     *
     * @param name The exact name of the country to find.
     * @return A list of countries with the specified name.
     */
    @Query("SELECT a FROM Country a WHERE LOWER(a.country) = LOWER(:name)")
    List<it.unito.iumtweb.springboot.country.Country> findByName(String name);

    /**
     * Retrieves a list of countries whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in country names.
     * @return A list of countries whose names match the keyword.
     */
    @Query("SELECT a FROM Country a WHERE LOWER(a.country) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<it.unito.iumtweb.springboot.country.Country> findByNameContainingIgnoreCase(String keyword);

}
