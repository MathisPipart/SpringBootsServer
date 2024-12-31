package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detailsMovies")
public class DetailsMovieController {

    private final DetailsMovieService detailsMovieService;

    @Autowired
    public DetailsMovieController(DetailsMovieService detailsMovieService) {
        this.detailsMovieService = detailsMovieService;
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

