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

    @GetMapping("/findByName")
    public ResponseEntity<it.unito.iumtweb.springboot.movie.Movie> findMovieByName(@RequestParam String name) {
        Optional<Movie> movie = movieService.findMovieByName(name);
        return movie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

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



    @GetMapping("/findByGenreAndDate")
    public ResponseEntity<?> findMoviesByGenreAndDate(@RequestParam String genre, @RequestParam String date) {
        List<Map<String, Object>> movies = movieService.findMoviesByGenreAndDate(genre, date);

        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé pour ces critères.");
        }

        return ResponseEntity.ok(movies);
    }

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
