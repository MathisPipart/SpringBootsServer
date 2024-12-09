package it.unito.iumtweb.springboot.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
