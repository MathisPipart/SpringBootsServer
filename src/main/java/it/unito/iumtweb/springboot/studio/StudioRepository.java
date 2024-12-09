package it.unito.iumtweb.springboot.studio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Studio a WHERE LOWER(a.studio) = LOWER(:name)")
    List<Studio> findByName(String name);

    @Query("SELECT a FROM Studio a WHERE LOWER(a.studio) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Studio> findByNameContainingIgnoreCase(String keyword);

}
