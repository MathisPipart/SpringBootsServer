package it.unito.iumtweb.springboot.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST controller for managing Movie entities.
 * Provides endpoints for retrieving, filtering, and fetching movie-related data.
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    /**
     * Constructs a MovieController with the specified MovieService.
     *
     * @param movieService The service used to manage Movie entities.
     */
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Retrieves a movie by its exact name.
     *
     * @param name The exact name of the movie to search for.
     * @return A ResponseEntity containing the Movie entity and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no movie is found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<it.unito.iumtweb.springboot.movie.Movie> findMovieByName(@RequestParam String name) {
        Optional<Movie> movie = movieService.findMovieByName(name);
        return movie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves movies whose names contain the specified keyword with pagination.
     *
     * @param name The keyword to search for in movie names.
     * @param page The page number for pagination (default is 0).
     * @param size The number of results per page (default is 20).
     * @return A ResponseEntity containing a list of movies and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no movies are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<?> findMoviesByKeyword(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        List<Map<String, Object>> movies = movieService.findMoviesByKeyword(name, page, size);
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé.");
        }
    }

    /**
     * Retrieves movies and their associated actors by movie name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing a list of movies with actor details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no results are found.
     */
    @GetMapping("/findByNameMovieAndActors")
    public ResponseEntity<?> findByNameMovieAndActors(@RequestParam String name) {
        List<Object[]> results = movieService.findMovieWithActors(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves posters associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing poster details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no posters are found.
     */
    @GetMapping("/findPostersofMovies")
    public ResponseEntity<?> findPostersofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findPostersofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Poster non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves studios associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing studio details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no studios are found.
     */
    @GetMapping("/findStudiosofMovies")
    public ResponseEntity<?> findStudiosofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findStudiosofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studio non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves countries associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing country details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no countries are found.
     */
    @GetMapping("/findCountriesofMovies")
    public ResponseEntity<?> findCountriesofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findCountriesofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studio non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves crew members associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing crew details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no crew members are found.
     */
    @GetMapping("/findCrewofMovies")
    public ResponseEntity<?> findCrewofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findCrewofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studio non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves genres associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing genre details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no genres are found.
     */
    @GetMapping("/findGenreofMovies")
    public ResponseEntity<?> findGenreofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findGenreofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genre non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves languages associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing language details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no languages are found.
     */
    @GetMapping("/findLanguageofMovies")
    public ResponseEntity<?> findLanguageofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findLanguageofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Langue non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves themes associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A ResponseEntity containing theme details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no themes are found.
     */
    @GetMapping("/findThemeofMovies")
    public ResponseEntity<?> findThemeofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findThemeofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Theme non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves movies filtered by genre with pagination support.
     *
     * @param genre The genre to filter movies by.
     * @param page  The page number for pagination (default is 0).
     * @param size  The number of results per page (default is 20).
     * @return A ResponseEntity containing movie details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no movies are found for the specified genre.
     */
    @GetMapping("/findByGenre")
    public ResponseEntity<?> findMoviesByGenre(
            @RequestParam String genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        List<Map<String, Object>> movies = movieService.getMoviesByGenre(genre, page, size);

        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé pour ce genre.");
        }
        return ResponseEntity.ok(movies);
    }

    /**
     * Retrieves movies filtered by release date with pagination support.
     *
     * @param date The release date to filter movies by.
     * @param page The page number for pagination (default is 0).
     * @param size The number of results per page (default is 20).
     * @return A ResponseEntity containing movie details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no movies are found for the specified date.
     */
    @GetMapping("/findByDate")
    public ResponseEntity<?> findMoviesByDate(
            @RequestParam String date,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        List<Map<String, Object>> movies = movieService.findMoviesByDate(date, page, size);

        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé pour cette date.");
        }

        return ResponseEntity.ok(movies);
    }

    /**
     * Retrieves movies filtered by both genre and release date.
     *
     * @param genre The genre to filter movies by.
     * @param date  The release date to filter movies by.
     * @return A ResponseEntity containing movie details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no movies are found for the specified genre and date.
     */
    @GetMapping("/findByGenreAndDate")
    public ResponseEntity<?> findMoviesByGenreAndDate(@RequestParam String genre, @RequestParam String date) {
        List<Map<String, Object>> movies = movieService.findMoviesByGenreAndDate(genre, date);

        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé pour ces critères.");
        }

        return ResponseEntity.ok(movies);
    }

    /**
     * Retrieves movies filtered by language and type with pagination support.
     *
     * @param selectedLanguage The language to filter movies by.
     * @param selectedType     The type to filter movies by (e.g., spoken or subtitled).
     * @param page             The page number for pagination.
     * @param size             The number of results per page.
     * @return A ResponseEntity containing movie details and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no movies are found.
     */
    @GetMapping("/findMoviesByLanguageAndType")
    public ResponseEntity<?> findMoviesByLanguageAndType(
            @RequestParam String selectedLanguage,
            @RequestParam String selectedType,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        List<Object[]> results = movieService.findMoviesByLanguageAndType(selectedLanguage, selectedType, page, size);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé pour les critères donnés.");
        }

        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves the top-rated movies with pagination support.
     *
     * @param page The page number for pagination (default is 0).
     * @param size The number of results per page (default is 20).
     * @return A ResponseEntity containing a list of top-rated movies and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no movies are found.
     */
    @GetMapping("/topRated")
    public ResponseEntity<?> getTopRatedMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        List<Map<String, Object>> results = movieService.getTopRatedMovies(page, size);
        if (results == null || results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves a list of distinct movie release dates.
     *
     * @return A ResponseEntity containing a list of distinct movie release dates and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no dates are found.
     */
    @GetMapping("/distinctDates")
    public ResponseEntity<List<String>> getDistinctDates() {
        List<String> distinctDates = movieService.findDistinctDates();
        if (!distinctDates.isEmpty()) {
            return new ResponseEntity<>(distinctDates, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
