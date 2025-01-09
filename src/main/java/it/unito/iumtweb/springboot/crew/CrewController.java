package it.unito.iumtweb.springboot.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Crew entities.
 * Provides endpoints to interact with the CrewService for retrieving Crew data.
 */
@RestController
@RequestMapping("/crews")
public class CrewController {
    private final it.unito.iumtweb.springboot.crew.CrewService crewService;

    /**
     * Constructs a CrewController with the specified CrewService.
     *
     * @param crewService The service used to manage Crew entities.
     */
    @Autowired
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    /**
     * Retrieves a list of crew members by their exact name.
     *
     * @param name The exact name of the crew member(s) to find.
     * @return A ResponseEntity containing a list of crew members with the specified name and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no crew members are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.crew.Crew>> findCrewByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.crew.Crew> crews = crewService.findCrewByName(name);
        if (!crews.isEmpty()) {
            return new ResponseEntity<>(crews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of crew members whose names contain the specified keyword.
     *
     * @param name The keyword to search for in crew member names.
     * @return A ResponseEntity containing a list of crew members whose names match the keyword and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no crew members are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.crew.Crew>> findCrewsByKeyword(@RequestParam String name) {
        List<Crew> crews = crewService.findCrewsByKeyword(name);
        if (!crews.isEmpty()) {
            return new ResponseEntity<>(crews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

