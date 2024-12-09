package it.unito.iumtweb.springboot.genre;

import it.unito.iumtweb.springboot.genre.Genre;
import it.unito.iumtweb.springboot.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final it.unito.iumtweb.springboot.genre.GenreService actorService;

    @Autowired
    public GenreController(GenreService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.genre.Genre> insertGenre(@RequestBody it.unito.iumtweb.springboot.genre.Genre countrie) {
        it.unito.iumtweb.springboot.genre.Genre savedGenre = actorService.saveGenre(countrie);
        return new ResponseEntity<>(savedGenre, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.genre.Genre> countrie = actorService.findGenreById(id);
        if (countrie.isPresent()) {
            actorService.deleteGenreById(id);
            return new ResponseEntity<>("Genre deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Genre not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.genre.Genre>> findGenreByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.genre.Genre> genres = actorService.findGenreByName(name);
        if (!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.genre.Genre>> findGenresByKeyword(@RequestParam String name) {
        List<Genre> genres = actorService.findGenresByKeyword(name);
        if (!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

