package it.unito.iumtweb.springboot.release;

import it.unito.iumtweb.springboot.release.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Release entities.
 * Provides endpoints for retrieving and filtering releases by name or keyword.
 */
@RestController
@RequestMapping("/releases")
public class ReleaseController {
    private final it.unito.iumtweb.springboot.release.ReleaseService releaseService;

    /**
     * Constructs a ReleaseController with the specified ReleaseService.
     *
     * @param releaseService The service used to manage Release entities.
     */
    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    /**
     * Retrieves a list of releases by their exact name.
     *
     * @param name The exact name of the release to find.
     * @return A ResponseEntity containing a list of releases with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no releases are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.release.Release>> findReleaseByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.release.Release> releases = releaseService.findReleaseByName(name);
        if (!releases.isEmpty()) {
            return new ResponseEntity<>(releases, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of releases whose names contain the specified keyword.
     *
     * @param name The keyword to search for in release names.
     * @return A ResponseEntity containing a list of releases with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no releases are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.release.Release>> findReleasesByKeyword(@RequestParam String name) {
        List<Release> releases = releaseService.findReleasesByKeyword(name);
        if (!releases.isEmpty()) {
            return new ResponseEntity<>(releases, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

