package it.unito.iumtweb.springboot.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Actor a WHERE LOWER(a.name) = LOWER(:name)")
    List<Actor> findByName(String name);

    @Query("SELECT a FROM Actor a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Actor> findByNameContainingIgnoreCase(String keyword);

}
