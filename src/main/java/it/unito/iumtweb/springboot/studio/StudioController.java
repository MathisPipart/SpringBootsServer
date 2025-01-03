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

