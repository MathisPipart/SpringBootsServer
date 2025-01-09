package it.unito.iumtweb.springboot.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Language entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    /**
     * Finds a list of languages by their exact name, ignoring case.
     *
     * @param name The exact name of the language to find.
     * @return A list of languages with the specified name.
     */    @Query("SELECT a FROM Language a WHERE LOWER(a.language) = LOWER(:name)")
    List<Language> findByName(String name);

    /**
     * Finds a list of languages whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in language names.
     * @return A list of languages whose names match the keyword.
     */
    @Query("SELECT a FROM Language a WHERE LOWER(a.language) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Language> findByNameContainingIgnoreCase(String keyword);

    /**
     * Finds a list of distinct language names.
     *
     * @return A list of unique language names.
     */
    @Query("SELECT DISTINCT l.language FROM Language l")
    List<String> findDistinctLanguages();

    /**
     * Finds a list of distinct language types.
     *
     * @return A list of unique language types.
     */
    @Query("SELECT DISTINCT l.type FROM Language l")
    List<String> findDistinctTypes();
}
