package it.unito.iumtweb.springboot.poster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posters")
public class PosterController {
    private final it.unito.iumtweb.springboot.poster.PosterService posterService;

    @Autowired
    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.poster.Poster>> findPosterByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.poster.Poster> posters = posterService.findPosterByName(name);
        if (!posters.isEmpty()) {
            return new ResponseEntity<>(posters, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.poster.Poster>> findPostersByKeyword(@RequestParam String name) {
        List<Poster> posters = posterService.findPostersByKeyword(name);
        if (!posters.isEmpty()) {
            return new ResponseEntity<>(posters, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

