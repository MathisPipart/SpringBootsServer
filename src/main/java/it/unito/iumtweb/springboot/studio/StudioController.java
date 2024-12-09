package it.unito.iumtweb.springboot.studio;

import it.unito.iumtweb.springboot.studio.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studios")
public class StudioController {
    private final it.unito.iumtweb.springboot.studio.StudioService studioService;

    @Autowired
    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.studio.Studio> insertStudio(@RequestBody it.unito.iumtweb.springboot.studio.Studio countrie) {
        it.unito.iumtweb.springboot.studio.Studio savedStudio = studioService.saveStudio(countrie);
        return new ResponseEntity<>(savedStudio, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudio(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.studio.Studio> countrie = studioService.findStudioById(id);
        if (countrie.isPresent()) {
            studioService.deleteStudioById(id);
            return new ResponseEntity<>("Studio deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Studio not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.studio.Studio>> findStudioByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.studio.Studio> studios = studioService.findStudioByName(name);
        if (!studios.isEmpty()) {
            return new ResponseEntity<>(studios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

