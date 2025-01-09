package it.unito.iumtweb.springboot.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing Genre entities.
 * Provides endpoints to retrieve, filter, and fetch distinct genre-related data.
 */
@RestController
@RequestMapping("/genres")
public class GenreController {
    private final it.unito.iumtweb.springboot.genre.GenreService genreService;


    /**
     * Constructs a GenreController with the specified GenreService.
     *
     * @param genreService The service used to manage Genre entities.
     */
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    /**
     * Retrieves a list of genres by their exact name.
     *
     * @param name The exact name of the genre to find.
     * @return A ResponseEntity containing a list of genres with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no genres are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.genre.Genre>> findGenreByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.genre.Genre> genres = genreService.findGenreByName(name);
        if (!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of genres whose names contain the specified keyword.
     *
     * @param name The keyword to search for in genre names.
     * @return A ResponseEntity containing a list of genres with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no genres are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.genre.Genre>> findGenresByKeyword(@RequestParam String name) {
        List<Genre> genres = genreService.findGenresByKeyword(name);
        if (!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of distinct genre names.
     *
     * @return A ResponseEntity containing the list of distinct genre names with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no data is available.
     */
    @GetMapping("/distinctGenres")
    public ResponseEntity<List<String>> getDistinctGenre() {
        List<String> distinctGenres = genreService.findDistinctGenres();
        if (!distinctGenres.isEmpty()) {
            return new ResponseEntity<>(distinctGenres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

