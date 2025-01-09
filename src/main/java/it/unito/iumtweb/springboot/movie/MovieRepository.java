package it.unito.iumtweb.springboot.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Repository interface for managing Movie entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /**
     * Finds a movie by its exact name.
     *
     * @param name The name of the movie to find.
     * @return An Optional containing the Movie entity if found, or empty otherwise.
     */
    Optional<Movie> findByName(String name);

    /**
     * Finds movies whose names contain the specified keyword.
     *
     * @param keyword The keyword to search for in movie names.
     * @param limit   The maximum number of results to return.
     * @param offset  The starting position of the results.
     * @return A list of maps containing movie details.
     */
    @Query("SELECT m.id AS id, m.name AS name, m.date AS date, m.tagline AS tagline, " +
            "m.description AS description, m.minute AS minute, m.rating AS rating, p.link AS link " +
            "FROM Movie m " +
            "LEFT JOIN Poster p ON m.id = p.id " +
            "WHERE m.rating IS NOT NULL " +
            "AND LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "ORDER BY m.rating DESC, m.id ASC " +
            "LIMIT :limit OFFSET :offset")
    List<Map<String, Object>> findMoviesByNameKeyword(@Param("keyword") String keyword, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * Finds movies and their associated actors by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and actor details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, a.name, a.role" +
            "FROM movie m" +
            "LEFT JOIN actor a ON m.id = a.id" +
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findMovieWithActorsByName(@Param("movieName") String movieName);

    /**
     * Finds movies and their associated posters by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and poster details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, p.id, p.link" +
            "FROM movie m"+
            "LEFT JOIN poster p ON m.id = p.id" +
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findPosterofMoviesByName(@Param("movieName") String movieName);

    /**
     * Finds movies and their associated studios by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and studio details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, s.id, s.studio"+
            "FROM movie m"+
            "LEFT JOIN studio s ON m.id = s.id"+
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findStudioofMoviesByName(@Param("movieName") String movieName);

    /**
     * Finds movies and their associated countries by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and country details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, c.id, c.country"+
            "FROM movie m"+
            "LEFT JOIN country c ON m.id = c.id"+
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findCountryofMoviesByName(@Param("movieName") String movieName);

    /**
     * Finds movies and their associated crew by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and crew details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, c.id, c.role, c.name"+
            "FROM movie m"+
            "LEFT JOIN crew c ON m.id = c.id"+
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findCrewofMoviesByName(@Param("movieName") String movieName);

    /**
     * Finds movies and their associated genres by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and genre details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, g.id, g.genre"+
            "FROM movie m"+
            "LEFT JOIN genre g ON m.id = g.id"+
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findGenreofMoviesByName(@Param("movieName") String movieName);

    /**
     * Finds movies and their associated languages by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and language details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, l.id, l.type, l.language"+
            "FROM movie m"+
            "LEFT JOIN language l ON m.id = l.id"+
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findLanguageofMoviesByName(@Param("movieName") String movieName);

    /**
     * Finds movies and their associated themes by movie name.
     *
     * @param movieName The name of the movie to search for.
     * @return A list of objects containing movie and theme details.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.description, m.minute, m.rating, m.tagline, t.id, t.theme"+
            "FROM movie m"+
            "LEFT JOIN theme t ON m.id = t.id"+
            "WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findThemeofMoviesByName(@Param("movieName") String movieName);

    /**
     * Finds movies by genre and rating, ordered by rating and ID.
     *
     * @param genreName The genre to filter movies by.
     * @param limit     The maximum number of results to return.
     * @param offset    The starting position of the results.
     * @return A list of maps containing movie and genre details.
     */
    @Query(nativeQuery = true, value =
            "SELECT m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, p.link, " +
                    "STRING_AGG(DISTINCT g.genre, ', ') AS genres " +
                    "FROM movie m " +
                    "JOIN genre g ON m.id = g.id " +
                    "JOIN poster p ON m.id = p.id " +
                    "WHERE m.rating IS NOT NULL " +
                    "AND m.id IN ( " +
                    "   SELECT m2.id " +
                    "   FROM movie m2 " +
                    "   JOIN genre g2 ON m2.id = g2.id " +
                    "   WHERE LOWER(g2.genre) = LOWER(:genreName) " +
                    ") " +
                    "GROUP BY m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, p.link " +
                    "ORDER BY m.rating DESC, m.id ASC " +
                    "LIMIT :limit OFFSET :offset")
    List<Map<String, Object>> findMoviesWithGenresByGenre(@Param("genreName") String genreName, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * Finds movies by a specific release date.
     *
     * @param date   The release date of the movies to search for (in string format, e.g., "2022").
     * @param limit  The maximum number of results to return.
     * @param offset The starting position for the results.
     * @return A list of maps containing movie details, including ID, name, release date, tagline, description,
     *         duration, rating, poster link, and aggregated genres.
     */
    @Query(nativeQuery = true, value =
            "SELECT m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, p.link, " +
                    "STRING_AGG(DISTINCT g.genre, ', ') AS genres " +
                    "FROM movie m " +
                    "JOIN genre g ON m.id = g.id " +
                    "JOIN poster p ON m.id = p.id " +
                    "WHERE m.rating IS NOT NULL " +
                    "AND m.date = CAST(:date AS INTEGER) " +
                    "GROUP BY m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, p.link " +
                    "ORDER BY m.rating DESC, m.id ASC " +
                    "LIMIT :limit OFFSET :offset")
    List<Map<String, Object>> findMoviesByDate(@Param("date") String date, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * Finds movies by a specific genre and release date.
     *
     * @param genre The genre of the movies to search for.
     * @param date  The release date of the movies to search for (in string format, e.g., "2022").
     * @return A list of maps containing movie details, including ID, name, release date, tagline, description,
     *         duration, rating, poster link, and aggregated genres.
     */
    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, p.link, " +
            "STRING_AGG(DISTINCT g.genre, ', ') AS genres " +
            "FROM movie m " +
            "JOIN genre g ON m.id = g.id " +
            "JOIN poster p ON m.id = p.id " +
            "WHERE m.id IN ( " +
            "   SELECT m2.id " +
            "   FROM movie m2 " +
            "   JOIN genre g2 ON m2.id = g2.id " +
            "   WHERE LOWER(g2.genre) = LOWER(:genre) " +
            "   AND m2.date = CAST(:date AS INTEGER) " +
            ") " +
            "GROUP BY m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, p.link " +
            "ORDER BY m.id ASC " +
            "LIMIT 50")
    List<Map<String, Object>> findMoviesByGenreAndDate(@Param("genre") String genre, @Param("date") String date);

    /**
     * Finds movies by a specific language and type.
     *
     * @param selectedLanguage The language of the movies to search for (e.g., "English").
     * @param selectedType     The type of the movies to search for (e.g., "Spoken").
     * @param limit            The maximum number of results to return.
     * @param offset           The starting position for the results.
     * @return A list of objects containing movie details, including ID, name, release date, description,
     *         duration, rating, tagline, language details, and poster link.
     */
    @Query(nativeQuery = true, value =
            "SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, " +
                    "m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, " +
                    "m.tagline AS movie_tagline, l.id AS language_id, l.type AS language_type, l.language AS language_language, " +
                    "p.link AS poster_link " +
                    "FROM movie m " +
                    "LEFT JOIN language l ON m.id = l.id " +
                    "LEFT JOIN poster p ON m.id = p.id " +
                    "WHERE LOWER(l.language) = LOWER(:selectedLanguage) AND LOWER(l.type) = LOWER(:selectedType) " +
                    "ORDER BY m.id ASC " +
                    "LIMIT :limit OFFSET :offset")
    List<Object[]> findMoviesByLanguageAndType(
            @Param("selectedLanguage") String selectedLanguage,
            @Param("selectedType") String selectedType,
            @Param("limit") int limit,
            @Param("offset") int offset);

    /**
     * Finds the top-rated movies with pagination.
     *
     * @param limit  The maximum number of results to return.
     * @param offset The starting position for the results.
     * @return A list of maps containing movie details, including ID, name, release date, tagline, description,
     *         duration, rating, poster link, and aggregated genres.
     */
    @Query(nativeQuery = true, value =
            "SELECT m.id AS id, m.name AS name, m.date AS date, m.tagline AS tagline, " +
                    "m.description AS description, m.minute AS minute, m.rating AS rating, p.link AS link, " +
                    "STRING_AGG(DISTINCT g.genre, ', ') AS genres " +
                    "FROM Movie m " +
                    "JOIN Genre g ON m.id = g.id " +
                    "JOIN Poster p ON m.id = p.id " +
                    "WHERE m.rating IS NOT NULL " +
                    "GROUP BY m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, p.link " +
                    "ORDER BY m.rating DESC, m.id ASC " +  // Ajoutez un espace ici
                    "LIMIT :limit OFFSET :offset")
    List<Map<String, Object>> findTopRatedMovies(int limit, int offset);

    /**
     * Finds distinct release dates of movies up to the year 2024.
     *
     * @return A list of unique movie release dates, ordered descending.
     */
    @Query("SELECT DISTINCT m.date FROM Movie m WHERE m.date <= 2024 ORDER BY m.date DESC")
    List<String> findDistinctDates();
}
