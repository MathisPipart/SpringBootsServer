package it.unito.iumtweb.springboot.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Genre entities.
 * Provides methods to interact with the GenreRepository and perform business logic.
 */
@Service
public class GenreService {
    private final GenreRepository genreRepository;

    /**
     * Constructs a GenreService with the specified GenreRepository.
     *
     * @param genreRepository The repository used to manage Genre entities.
     */
    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    /**
     * Finds a list of genres by their exact name.
     *
     * @param name The exact name of the genre to find.
     * @return A list of genres with the specified name. If no genres are found, returns an empty list.
     */
    public List<Genre> findGenreByName(String name) {
        return genreRepository.findByName(name.trim());
    }

    /**
     * Finds a list of genres whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in genre names.
     * @return A list of genres whose names match the keyword. If no genres are found, returns an empty list.
     */
    public List<Genre> findGenresByKeyword(String keyword) {
        return genreRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

    /**
     * Retrieves a list of distinct genre names.
     *
     * @return A list of unique genre names.
     */
    public List<String> findDistinctGenres() {
        return genreRepository.findDistinctGenres();
    }

}

