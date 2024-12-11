package it.unito.iumtweb.springboot.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> findMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<Movie> findMoviesByKeyword(String keyword) {
        return movieRepository.findMoviesByNameKeyword(keyword);
    }

    public List<Object[]> findMovieWithActors(String movieName) {
        return movieRepository.findMovieWithActorsByName(movieName);
    }

    public List<Object[]> findPostersofMovies(String name) {
        return movieRepository.findPosterofMoviesByName(name);
    }
}
