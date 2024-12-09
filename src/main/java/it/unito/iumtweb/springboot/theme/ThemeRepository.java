package it.unito.iumtweb.springboot.theme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Theme a WHERE LOWER(a.theme) = LOWER(:name)")
    List<Theme> findByName(String name);

    @Query("SELECT a FROM Theme a WHERE LOWER(a.theme) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Theme> findByNameContainingIgnoreCase(String keyword);

}
