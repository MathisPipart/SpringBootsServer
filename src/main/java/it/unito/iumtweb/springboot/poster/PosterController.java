package it.unito.iumtweb.springboot.poster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Poster entities.
 * Provides endpoints for retrieving and filtering posters by name or keyword.
 */
@RestController
@RequestMapping("/posters")
public class PosterController {
    private final it.unito.iumtweb.springboot.poster.PosterService posterService;

    /**
     * Constructs a PosterController with the specified PosterService.
     *
     * @param posterService The service used to manage Poster entities.
     */
    @Autowired
    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    /**
     * Retrieves a list of posters by their exact name.
     *
     * @param name The exact name of the poster to find.
     * @return A ResponseEntity containing a list of posters with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no posters are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.poster.Poster>> findPosterByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.poster.Poster> posters = posterService.findPosterByName(name);
        if (!posters.isEmpty()) {
            return new ResponseEntity<>(posters, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of posters whose names contain the specified keyword.
     *
     * @param name The keyword to search for in poster names.
     * @return A ResponseEntity containing a list of posters with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no posters are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.poster.Poster>> findPostersByKeyword(@RequestParam String name) {
        List<Poster> posters = posterService.findPostersByKeyword(name);
        if (!posters.isEmpty()) {
            return new ResponseEntity<>(posters, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

