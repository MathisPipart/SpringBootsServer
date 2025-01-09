package it.unito.iumtweb.springboot.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service class for managing Movie entities.
 * Provides methods to interact with the MovieRepository and perform business logic.
 */
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    /**
     * Constructs a MovieService with the specified MovieRepository.
     *
     * @param movieRepository The repository used to manage Movie entities.
     */
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Finds a movie by its exact name.
     *
     * @param name The name of the movie to find.
     * @return An Optional containing the Movie entity if found, or empty otherwise.
     */
    public Optional<Movie> findMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    /**
     * Finds movies by a keyword in their names.
     *
     * @param keyword The keyword to search for in movie names.
     * @param page    The page number for pagination.
     * @param size    The number of results per page.
     * @return A list of maps containing movie details.
     */
    public List<Map<String, Object>> findMoviesByKeyword(String keyword, int page, int size) {
        int offset = page * size; // Calcul de l'offset
        return movieRepository.findMoviesByNameKeyword(keyword, size, offset);
    }

    /**
     * Finds movies and their associated actors by name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and actor details.
     */
    public List<Object[]> findMovieWithActors(String movieName) {
        return movieRepository.findMovieWithActorsByName(movieName);
    }

    /**
     * Retrieves the posters associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A list of objects containing movie and poster details.
     */
    public List<Object[]> findPostersofMovies(String name) {
        return movieRepository.findPosterofMoviesByName(name);
    }

    /**
     * Retrieves the studios associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A list of objects containing movie and studio details.
     */
    public List<Object[]> findStudiosofMovies(String name) {
        return movieRepository.findStudioofMoviesByName(name);
    }

    /**
     * Retrieves the countries associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A list of objects containing movie and country details.
     */
    public List<Object[]> findCountriesofMovies(String name) {
        return movieRepository.findCountryofMoviesByName(name);
    }

    /**
     * Retrieves the crew members associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A list of objects containing movie and crew details.
     */
    public List<Object[]> findCrewofMovies(String name) {
        return movieRepository.findCrewofMoviesByName(name);
    }

    /**
     * Retrieves the genres associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A list of objects containing movie and genre details.
     */
    public List<Object[]> findGenreofMovies(String name) {
        return movieRepository.findGenreofMoviesByName(name);
    }

    /**
     * Retrieves the languages associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A list of objects containing movie and language details.
     */
    public List<Object[]> findLanguageofMovies(String name) {
        return movieRepository.findLanguageofMoviesByName(name);
    }

    /**
     * Retrieves the themes associated with movies matching the specified name.
     *
     * @param name The name of the movie to search for.
     * @return A list of objects containing movie and theme details.
     */
    public List<Object[]> findThemeofMovies(String name) {
        return movieRepository.findThemeofMoviesByName(name);
    }

    /**
     * Retrieves movies by genre with pagination support.
     *
     * @param genre The genre of the movies to search for.
     * @param page  The page number for pagination.
     * @param size  The number of results per page.
     * @return A list of maps containing movie and genre details.
     */
    public List<Map<String, Object>> getMoviesByGenre(String genre, int page, int size) {
        int offset = page * size;
        return movieRepository.findMoviesWithGenresByGenre(genre, size, offset);
    }

    /**
     * Retrieves movies by release date with pagination support.
     *
     * @param date  The release date of the movies to search for.
     * @param page  The page number for pagination.
     * @param size  The number of results per page.
     * @return A list of maps containing movie details, including genres.
     */
    public List<Map<String, Object>> findMoviesByDate(String date, int page, int size) {
        int offset = page * size;
        return movieRepository.findMoviesByDate(date, size, offset);
    }

    /**
     * Retrieves movies by genre and release date.
     *
     * @param genre The genre of the movies to search for.
     * @param date  The release date of the movies to search for.
     * @return A list of maps containing movie details, including genres.
     */
    public List<Map<String, Object>> findMoviesByGenreAndDate(String genre, String date) {
        return movieRepository.findMoviesByGenreAndDate(genre, date);
    }

    /**
     * Retrieves movies by language and type with pagination support.
     *
     * @param language The language of the movies to search for.
     * @param type     The type of the movies to search for (e.g., "spoken").
     * @param page     The page number for pagination.
     * @param size     The number of results per page.
     * @return A list of objects containing movie and language details.
     */
    public List<Object[]> findMoviesByLanguageAndType(String language, String type, int page, int size) {
        int offset = page * size;
        return movieRepository.findMoviesByLanguageAndType(language, type, size, offset);
    }

    /**
     * Retrieves the top-rated movies with pagination support.
     *
     * @param page The page number for pagination.
     * @param size The number of results per page.
     * @return A list of maps containing movie details, including genres.
     */
    public List<Map<String, Object>> getTopRatedMovies(int page, int size) {
        int offset = page * size;
        return movieRepository.findTopRatedMovies(size, offset);
    }

    /**
     * Retrieves a list of distinct movie release dates.
     *
     * @return A list of unique movie release dates.
     */
    public List<String> findDistinctDates() {
        return movieRepository.findDistinctDates();
    }

}
