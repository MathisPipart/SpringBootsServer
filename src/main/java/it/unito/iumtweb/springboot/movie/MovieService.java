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

    public Optional<Movie> findMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<Map<String, Object>> findMoviesByKeyword(String keyword, int page, int size) {
        int offset = page * size; // Calcul de l'offset
        return movieRepository.findMoviesByNameKeyword(keyword, size, offset);
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

    public List<Map<String, Object>> getMoviesByGenre(String genre, int page, int size) {
        int offset = page * size;
        return movieRepository.findMoviesWithGenresByGenre(genre, size, offset);
    }


    public List<Map<String, Object>> findMoviesByDate(String date, int page, int size) {
        int offset = page * size;
        return movieRepository.findMoviesByDate(date, size, offset);
    }


    public List<Map<String, Object>> findMoviesByGenreAndDate(String genre, String date) {
        return movieRepository.findMoviesByGenreAndDate(genre, date);
    }

    public List<Object[]> findMoviesByLanguageAndType(String language, String type, int page, int size) {
        int offset = page * size;
        return movieRepository.findMoviesByLanguageAndType(language, type, size, offset);
    }


    public List<Map<String, Object>> getTopRatedMovies(int page, int size) {
        int offset = page * size;
        return movieRepository.findTopRatedMovies(size, offset);
    }

    public List<String> findDistinctDates() {
        return movieRepository.findDistinctDates();
    }

}
