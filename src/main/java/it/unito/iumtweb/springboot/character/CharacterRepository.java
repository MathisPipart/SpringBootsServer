package it.unito.iumtweb.springboot.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    // Add custom query methods if required
    Optional<Character> findByName(String name);
}
