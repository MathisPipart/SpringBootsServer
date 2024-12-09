package it.unito.iumtweb.springboot.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final it.unito.iumtweb.springboot.genre.GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.genre.Genre> insertGenre(@RequestBody it.unito.iumtweb.springboot.genre.Genre countrie) {
        it.unito.iumtweb.springboot.genre.Genre savedGenre = genreService.saveGenre(countrie);
        return new ResponseEntity<>(savedGenre, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.genre.Genre> countrie = genreService.findGenreById(id);
        if (countrie.isPresent()) {
            genreService.deleteGenreById(id);
            return new ResponseEntity<>("Genre deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Genre not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.genre.Genre>> findGenreByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.genre.Genre> genres = genreService.findGenreByName(name);
        if (!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.genre.Genre>> findGenresByKeyword(@RequestParam String name) {
        List<Genre> genres = genreService.findGenresByKeyword(name);
        if (!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

