package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detailsMovies")
public class DetailsMovieController {

    private final DetailsMovieService detailsMovieService;

    @Autowired
    public DetailsMovieController(DetailsMovieService detailsMovieService) {
        this.detailsMovieService = detailsMovieService;
    }

    @PostMapping("/insert")
    public ResponseEntity<DetailsMovie> insertDetailsMovie(@RequestBody DetailsMovie detailsMovie) {
        DetailsMovie savedDetailsMovie = detailsMovieService.saveDetailsMovie(detailsMovie);
        return new ResponseEntity<>(savedDetailsMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetailsMovie(@PathVariable Long id) {
        Optional<DetailsMovie> detailsMovie = detailsMovieService.findDetailsMovieById(id);
        if (detailsMovie.isPresent()) {
            detailsMovieService.deleteDetailsMovieById(id);
            return new ResponseEntity<>("DetailsMovie deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DetailsMovie not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DetailsMovie>> findAllDetailsMovies() {
        List<DetailsMovie> detailsMovies = detailsMovieService.findAllDetailsMovies();
        return new ResponseEntity<>(detailsMovies, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<DetailsMovie> getDetailsMovieById(@PathVariable Long id) {
        DetailsMovie detailsMovie = detailsMovieService.getDetailsMovieById(id);
        if (detailsMovie != null) {
            return new ResponseEntity<>(detailsMovie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

