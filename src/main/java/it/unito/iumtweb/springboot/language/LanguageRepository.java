package it.unito.iumtweb.springboot.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Language a WHERE LOWER(a.language) = LOWER(:name)")
    List<Language> findByName(String name);

    @Query("SELECT a FROM Language a WHERE LOWER(a.language) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Language> findByNameContainingIgnoreCase(String keyword);

    @Query("SELECT DISTINCT l.language FROM Language l")
    List<String> findDistinctLanguages();

    @Query("SELECT DISTINCT l.type FROM Language l")
    List<String> findDistinctTypes();
}
