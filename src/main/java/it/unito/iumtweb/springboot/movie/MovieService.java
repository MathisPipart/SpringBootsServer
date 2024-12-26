package it.unito.iumtweb.springboot.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public List<Map<String, Object>> findMoviesByKeyword(String keyword) {
        return movieRepository.findMoviesByNameKeyword(keyword);
    }

    public List<Object[]> findMovieWithActors(String movieName) {
        return movieRepository.findMovieWithActorsByName(movieName);
    }

    public List<Object[]> findPostersofMovies(String name) {
        return movieRepository.findPosterofMoviesByName(name);
    }

    public List<Object[]> findStudiosofMovies(String name) {
        return movieRepository.findStudioofMoviesByName(name);
    }

    public List<Object[]> findCountriesofMovies(String name) {
        return movieRepository.findCountryofMoviesByName(name);
    }

    public List<Object[]> findCrewofMovies(String name) {
        return movieRepository.findCrewofMoviesByName(name);
    }

    public List<Object[]> findGenreofMovies(String name) {
        return movieRepository.findGenreofMoviesByName(name);
    }

    public List<Object[]> findLanguageofMovies(String name) {
        return movieRepository.findLanguageofMoviesByName(name);
    }

    public List<Object[]> findThemeofMovies(String name) {
        return movieRepository.findThemeofMoviesByName(name);
    }

    public List<Map<String, Object>> findMoviesWithGenresByGenre(String genreName) {
        return movieRepository.findMoviesWithGenresByGenre(genreName);
    }

    public List<Map<String, Object>> findMoviesByDate(String date) {
        return movieRepository.findMoviesByDate(date);
    }

    public List<Map<String, Object>> findMoviesByGenreAndDate(String genre, String date) {
        return movieRepository.findMoviesByGenreAndDate(genre, date);
    }

    public List<Object[]> findMoviesByLanguageAndType(String language, String type) {
        return movieRepository.findMoviesByLanguageAndType(language, type);
    }


}
