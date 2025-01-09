package it.unito.iumtweb.springboot.studio;

import it.unito.iumtweb.springboot.studio.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Studio entities.
 * Provides endpoints for retrieving and filtering studios by name or keyword.
 */
@RestController
@RequestMapping("/studios")
public class StudioController {
    private final it.unito.iumtweb.springboot.studio.StudioService studioService;

    /**
     * Constructs a StudioController with the specified StudioService.
     *
     * @param studioService The service used to manage Studio entities.
     */
    @Autowired
    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    /**
     * Retrieves a list of studios by their exact name.
     *
     * @param name The exact name of the studio to find.
     * @return A ResponseEntity containing a list of studios with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no studios are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.studio.Studio>> findStudioByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.studio.Studio> studios = studioService.findStudioByName(name);
        if (!studios.isEmpty()) {
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of studios whose names contain the specified keyword.
     *
     * @param name The keyword to search for in studio names.
     * @return A ResponseEntity containing a list of studios with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no studios are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.studio.Studio>> findStudiosByKeyword(@RequestParam String name) {
        List<Studio> studios = studioService.findStudiosByKeyword(name);
        if (!studios.isEmpty()) {
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

