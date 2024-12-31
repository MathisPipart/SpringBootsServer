package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailsMovieService {

    private final DetailsMovieRepository detailsMovieRepository;

    @Autowired
    public DetailsMovieService(DetailsMovieRepository detailsMovieRepository) {
        this.detailsMovieRepository = detailsMovieRepository;
    }

    public DetailsMovie saveDetailsMovie(DetailsMovie detailsMovie) {
        return detailsMovieRepository.save(detailsMovie);
    }

    public void deleteDetailsMovieById(Long id) {
        detailsMovieRepository.deleteById(id);
    }

    public Optional<DetailsMovie> findDetailsMovieById(Long id) {
        return detailsMovieRepository.findById(id);
    }

    public List<DetailsMovie> findAllDetailsMovies() {
        return detailsMovieRepository.findAll();
    }

    public DetailsMovie getDetailsMovieById(Long id) {
        return detailsMovieRepository.findDetailsMovieById(id);
    }
}

