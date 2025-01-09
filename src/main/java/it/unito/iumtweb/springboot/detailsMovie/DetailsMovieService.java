package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing DetailsMovie entities.
 * Provides methods to interact with the DetailsMovieRepository and perform business logic.
 */
@Service
public class DetailsMovieService {

    private final DetailsMovieRepository detailsMovieRepository;

    /**
     * Constructs a DetailsMovieService with the specified DetailsMovieRepository.
     *
     * @param detailsMovieRepository The repository used to manage DetailsMovie entities.
     */
    @Autowired
    public DetailsMovieService(DetailsMovieRepository detailsMovieRepository) {
        this.detailsMovieRepository = detailsMovieRepository;
    }

    /**
     * Retrieves a list of all DetailsMovie entities.
     *
     * @return A list of all DetailsMovie entities.
     */
    public List<DetailsMovie> findAllDetailsMovies() {
        return detailsMovieRepository.findAll();
    }

    /**
     * Retrieves a DetailsMovie entity by its unique identifier.
     *
     * @param id The ID of the DetailsMovie to retrieve.
     * @return The DetailsMovie entity with the specified ID, or null if not found.
     */
    public DetailsMovie getDetailsMovieById(Long id) {
        return detailsMovieRepository.findDetailsMovieById(id);
    }
}

