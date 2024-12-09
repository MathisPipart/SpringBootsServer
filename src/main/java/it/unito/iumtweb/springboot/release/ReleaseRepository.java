package it.unito.iumtweb.springboot.release;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Release a WHERE LOWER(a.country) = LOWER(:name)")
    List<Release> findByName(String name);

    @Query("SELECT a FROM Release a WHERE LOWER(a.country) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Release> findByNameContainingIgnoreCase(String keyword);

}
