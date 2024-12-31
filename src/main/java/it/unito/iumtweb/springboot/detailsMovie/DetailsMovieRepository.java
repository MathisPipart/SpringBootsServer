package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsMovieRepository extends JpaRepository<DetailsMovie, Long> {
    @Query("SELECT d FROM DetailsMovie d WHERE d.id = :id")
    DetailsMovie findDetailsMovieById(Long id);
}
