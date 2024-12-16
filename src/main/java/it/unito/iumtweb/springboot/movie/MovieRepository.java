package it.unito.iumtweb.springboot.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Add custom query methods if required
    Optional<Movie> findByName(String name);

    @Query("SELECT m FROM Movie m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Movie> findMoviesByNameKeyword(@Param("keyword") String keyword);


    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, a.name AS actor_name, a.role AS actor_role FROM movie m LEFT JOIN actor a ON m.id = a.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findMovieWithActorsByName(@Param("movieName") String movieName);


    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, p.id AS poster_id, p.link AS poster_link FROM movie m LEFT JOIN poster p ON m.id = p.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findPosterofMoviesByName(@Param("movieName") String movieName);

    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, s.id AS studio_id, s.studio AS studio_studio FROM movie m LEFT JOIN studio s ON m.id = s.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findStudioofMoviesByName(@Param("movieName") String movieName);

    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, c.id AS country_id, c.country AS country_country FROM movie m LEFT JOIN country c ON m.id = c.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findCountryofMoviesByName(@Param("movieName") String movieName);

    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, c.id AS crew_id, c.role AS crew_role, c.name AS crew_name FROM movie m LEFT JOIN crew c ON m.id = c.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findCrewofMoviesByName(@Param("movieName") String movieName);

    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, g.id AS genre_id, g.genre AS genre_genre FROM movie m LEFT JOIN genre g ON m.id = g.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findGenreofMoviesByName(@Param("movieName") String movieName);

    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, l.id AS language_id, l.type AS language_type, l.language AS language_language FROM movie m LEFT JOIN language l ON m.id = l.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findLanguageofMoviesByName(@Param("movieName") String movieName);

    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, t.id AS theme_id, t.theme AS theme_theme FROM movie m LEFT JOIN theme t ON m.id = t.id WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :movieName, '%'))")
    List<Object[]> findThemeofMoviesByName(@Param("movieName") String movieName);


    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, " +
            "STRING_AGG(DISTINCT g.genre, ', ') AS genres " +
            "FROM movie m " +
            "JOIN genre g ON m.id = g.id " +
            "WHERE m.id IN ( " +
            "   SELECT m2.id " +
            "   FROM movie m2 " +
            "   JOIN genre g2 ON m2.id = g2.id " +
            "   WHERE LOWER(g2.genre) = LOWER(:genreName) " +
            ") " +
            "GROUP BY m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating " +
            "LIMIT 50")
    List<Map<String, Object>> findMoviesWithGenresByGenre(@Param("genreName") String genreName);


    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, " +
            "STRING_AGG(DISTINCT g.genre, ', ') AS genres " +
            "FROM movie m " +
            "JOIN genre g ON m.id = g.id " +
            "WHERE m.date = CAST(:date AS INTEGER) " +
            "GROUP BY m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating " +
            "ORDER BY m.id ASC " +
            "LIMIT 50")
    List<Map<String, Object>> findMoviesByDate(@Param("date") String date);


    @Query(nativeQuery = true, value = "SELECT m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating, " +
            "STRING_AGG(DISTINCT g.genre, ', ') AS genres " +
            "FROM movie m " +
            "JOIN genre g ON m.id = g.id " +
            "WHERE m.id IN ( " +
            "   SELECT m2.id " +
            "   FROM movie m2 " +
            "   JOIN genre g2 ON m2.id = g2.id " +
            "   WHERE LOWER(g2.genre) = LOWER(:genre) " +
            "   AND m2.date = CAST(:date AS INTEGER) " +
            ") " +
            "GROUP BY m.id, m.name, m.date, m.tagline, m.description, m.minute, m.rating " +
            "ORDER BY m.id ASC " +
            "LIMIT 50")
    List<Map<String, Object>> findMoviesByGenreAndDate(@Param("genre") String genre, @Param("date") String date);





}
