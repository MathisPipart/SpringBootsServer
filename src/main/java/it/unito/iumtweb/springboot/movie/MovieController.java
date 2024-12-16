package it.unito.iumtweb.springboot.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.movie.Movie> insertMovie(@RequestBody it.unito.iumtweb.springboot.movie.Movie movie) {
        it.unito.iumtweb.springboot.movie.Movie savedMovie = movieService.saveMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.movie.Movie> movie = movieService.findMovieById(id);
        if (movie.isPresent()) {
            movieService.deleteMovieById(id);
            return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<it.unito.iumtweb.springboot.movie.Movie> findMovieByName(@RequestParam String name) {
        System.out.println("IN findMovieByName");
        Optional<Movie> movie = movieService.findMovieByName(name);
        return movie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<List<Movie>> findMoviesByKeyword(@RequestParam String name) {
        List<Movie> movies = movieService.findMoviesByKeyword(name);
        if (!movies.isEmpty()) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNameMovieAndActors")
    public ResponseEntity<?> findByNameMovieAndActors(@RequestParam String name) {
        List<Object[]> results = movieService.findMovieWithActors(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Film non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findPostersofMovies")
    public ResponseEntity<?> findPostersofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findPostersofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Poster non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findStudiosofMovies")
    public ResponseEntity<?> findStudiosofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findStudiosofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studio non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findCountriesofMovies")
    public ResponseEntity<?> findCountriesofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findCountriesofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studio non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findCrewofMovies")
    public ResponseEntity<?> findCrewofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findCrewofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Studio non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findGenreofMovies")
    public ResponseEntity<?> findGenreofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findGenreofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genre non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findLanguageofMovies")
    public ResponseEntity<?> findLanguageofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findLanguageofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Langue non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findThemeofMovies")
    public ResponseEntity<?> findThemeofMovies(@RequestParam String name) {
        List<Object[]> results = movieService.findThemeofMovies(name);

        if (results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Theme non trouvé.");
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/findByGenre")
    public ResponseEntity<?> findMoviesByGenre(@RequestParam String genre) {
        List<Map<String, Object>> movies = movieService.findMoviesWithGenresByGenre(genre);

        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé pour ce genre.");
        }
        return ResponseEntity.ok(movies);
    }

}
