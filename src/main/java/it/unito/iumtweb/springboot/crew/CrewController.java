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
    private final it.unito.iumtweb.springboot.crew.CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.crew.Crew>> findCrewByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.crew.Crew> crews = crewService.findCrewByName(name);
        if (!crews.isEmpty()) {
            return new ResponseEntity<>(crews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

