package it.unito.iumtweb.springboot.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crews")
public class CrewController {
    private final it.unito.iumtweb.springboot.crew.CrewService actorService;

    @Autowired
    public CrewController(CrewService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.crew.Crew> insertCrew(@RequestBody it.unito.iumtweb.springboot.crew.Crew countrie) {
        it.unito.iumtweb.springboot.crew.Crew savedCrew = actorService.saveCrew(countrie);
        return new ResponseEntity<>(savedCrew, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCrew(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.crew.Crew> countrie = actorService.findCrewById(id);
        if (countrie.isPresent()) {
            actorService.deleteCrewById(id);
            return new ResponseEntity<>("Crew deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Crew not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.crew.Crew>> findCrewByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.crew.Crew> crews = actorService.findCrewByName(name);
        if (!crews.isEmpty()) {
            return new ResponseEntity<>(crews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.crew.Crew>> findCrewsByKeyword(@RequestParam String name) {
        List<Crew> crews = actorService.findCrewsByKeyword(name);
        if (!crews.isEmpty()) {
            return new ResponseEntity<>(crews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

