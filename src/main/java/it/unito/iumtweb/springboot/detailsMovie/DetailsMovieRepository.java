package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing DetailsMovie entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface DetailsMovieRepository extends JpaRepository<DetailsMovie, Long> {

    /**
     * Finds a DetailsMovie entity by its unique identifier.
     *
     * @param id The ID of the DetailsMovie to find.
     * @return The DetailsMovie entity with the specified ID, or null if not found.
     */
    @Query("SELECT d FROM DetailsMovie d WHERE d.id = :id")
    DetailsMovie findDetailsMovieById(Long id);
}
