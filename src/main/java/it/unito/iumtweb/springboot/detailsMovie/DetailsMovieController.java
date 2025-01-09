package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing DetailsMovie entities.
 * Provides endpoints to retrieve details about movies.
 */
@RestController
@RequestMapping("/detailsMovies")
public class DetailsMovieController {

    private final DetailsMovieService detailsMovieService;

    /**
     * Constructs a DetailsMovieController with the specified DetailsMovieService.
     *
     * @param detailsMovieService The service used to manage DetailsMovie entities.
     */
    @Autowired
    public DetailsMovieController(DetailsMovieService detailsMovieService) {
        this.detailsMovieService = detailsMovieService;
    }

    /**
     * Retrieves a list of all movie details.
     *
     * @return A ResponseEntity containing the list of all DetailsMovie entities with HTTP status OK (200).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<DetailsMovie>> findAllDetailsMovies() {
        List<DetailsMovie> detailsMovies = detailsMovieService.findAllDetailsMovies();
        return new ResponseEntity<>(detailsMovies, HttpStatus.OK);
    }

    /**
     * Retrieves movie details by their unique identifier.
     *
     * @param id The ID of the DetailsMovie to retrieve.
     * @return A ResponseEntity containing the DetailsMovie entity with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no entity is found.
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<DetailsMovie> getDetailsMovieById(@PathVariable Long id) {
        DetailsMovie detailsMovie = detailsMovieService.getDetailsMovieById(id);
        if (detailsMovie != null) {
            return new ResponseEntity<>(detailsMovie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

