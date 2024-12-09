package it.unito.iumtweb.springboot.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.actor.Actor> insertActor(@RequestBody it.unito.iumtweb.springboot.actor.Actor actor) {
        it.unito.iumtweb.springboot.actor.Actor savedActor = actorService.saveActor(actor);
        return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.actor.Actor> actor = actorService.findActorById(id);
        if (actor.isPresent()) {
            actorService.deleteActorById(id);
            return new ResponseEntity<>("Actor deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Actor not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Actor>> findActorByName(@RequestParam String name) {
        List<Actor> actors = actorService.findActorByName(name);
        if (!actors.isEmpty()) {
            return new ResponseEntity<>(actors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

