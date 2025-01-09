package it.unito.iumtweb.springboot.poster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Poster entities.
 * Provides methods to interact with the PosterRepository and perform business logic.
 */
@Service
public class PosterService {
    private final PosterRepository posterRepository;

    /**
     * Constructs a PosterService with the specified PosterRepository.
     *
     * @param posterRepository The repository used to manage Poster entities.
     */
    @Autowired
    public PosterService(PosterRepository posterRepository) {
        this.posterRepository = posterRepository;
    }

    /**
     * Finds a list of posters by their exact name.
     *
     * @param name The exact name of the poster to find.
     * @return A list of posters with the specified name. If no posters are found, returns an empty list.
     */
    public List<Poster> findPosterByName(String name) {
        return posterRepository.findByName(name.trim());
    }

    /**
     * Finds a list of posters whose names contain the specified keyword.
     *
     * @param keyword The keyword to search for in poster names.
     * @return A list of posters whose names match the keyword. If no posters are found, returns an empty list.
     */
    public List<Poster> findPostersByKeyword(String keyword) {
        return posterRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

