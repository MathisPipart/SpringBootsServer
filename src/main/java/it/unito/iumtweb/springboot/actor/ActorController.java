package it.unito.iumtweb.springboot.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Actor entities.
 * Provides endpoints to interact with the ActorService for retrieving Actor data.
 */
@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    /**
     * Constructs an ActorController with the specified ActorService.
     *
     * @param actorService The service used to manage Actor entities.
     */
    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    /**
     * Retrieves a list of actors by their exact name.
     *
     * @param name The exact name of the actor(s) to find.
     * @return A ResponseEntity containing a list of actors with the specified name and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no actors are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<Actor>> findActorByName(@RequestParam String name) {
        List<Actor> actors = actorService.findActorByName(name);
        if (!actors.isEmpty()) {
            return new ResponseEntity<>(actors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of actors whose names contain the specified keyword.
     *
     * @param name The keyword to search for in the actor names.
     * @return A ResponseEntity containing a list of actors whose names match the keyword and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no actors are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<Actor>> findActorsByKeyword(@RequestParam String name) {
        List<Actor> actors = actorService.findActorsByKeyword(name);
        if (!actors.isEmpty()) {
            return new ResponseEntity<>(actors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

