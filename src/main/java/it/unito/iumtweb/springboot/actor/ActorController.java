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

