package it.unito.iumtweb.springboot.detailsMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsMovieService {

    private final DetailsMovieRepository detailsMovieRepository;

    @Autowired
    public DetailsMovieService(DetailsMovieRepository detailsMovieRepository) {
        this.detailsMovieRepository = detailsMovieRepository;
    }

    public List<DetailsMovie> findAllDetailsMovies() {
        return detailsMovieRepository.findAll();
    }

    public DetailsMovie getDetailsMovieById(Long id) {
        return detailsMovieRepository.findDetailsMovieById(id);
    }
}

