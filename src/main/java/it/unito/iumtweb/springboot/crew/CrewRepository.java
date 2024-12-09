package it.unito.iumtweb.springboot.crew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Crew a WHERE LOWER(a.name) = LOWER(:name)")
    List<Crew> findByName(String name);

    @Query("SELECT a FROM Crew a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Crew> findByNameContainingIgnoreCase(String keyword);

}
