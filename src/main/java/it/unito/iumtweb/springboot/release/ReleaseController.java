package it.unito.iumtweb.springboot.release;

import it.unito.iumtweb.springboot.release.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/releases")
public class ReleaseController {
    private final it.unito.iumtweb.springboot.release.ReleaseService releaseService;

    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.release.Release> insertRelease(@RequestBody it.unito.iumtweb.springboot.release.Release countrie) {
        it.unito.iumtweb.springboot.release.Release savedRelease = releaseService.saveRelease(countrie);
        return new ResponseEntity<>(savedRelease, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRelease(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.release.Release> countrie = releaseService.findReleaseById(id);
        if (countrie.isPresent()) {
            releaseService.deleteReleaseById(id);
            return new ResponseEntity<>("Release deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Release not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.release.Release>> findReleaseByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.release.Release> releases = releaseService.findReleaseByName(name);
        if (!releases.isEmpty()) {
            return new ResponseEntity<>(releases, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

