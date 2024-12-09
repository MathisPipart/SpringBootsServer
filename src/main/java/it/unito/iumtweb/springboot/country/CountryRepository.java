package it.unito.iumtweb.springboot.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<it.unito.iumtweb.springboot.country.Country, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Country a WHERE LOWER(a.country) = LOWER(:name)")
    List<it.unito.iumtweb.springboot.country.Country> findByName(String name);

    @Query("SELECT a FROM Country a WHERE LOWER(a.country) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<it.unito.iumtweb.springboot.country.Country> findByNameContainingIgnoreCase(String keyword);

}
