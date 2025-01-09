package it.unito.iumtweb.springboot.studio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Studio entities.
 * Provides methods to interact with the StudioRepository and perform business logic.
 */
@Service
public class StudioService {
    private final StudioRepository studioRepository;

    /**
     * Constructs a StudioService with the specified StudioRepository.
     *
     * @param studioRepository The repository used to manage Studio entities.
     */
    @Autowired
    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    /**
     * Finds a list of studios by their exact name.
     *
     * @param name The exact name of the studio to find.
     * @return A list of studios with the specified name. If no studios are found, returns an empty list.
     */
    public List<Studio> findStudioByName(String name) {
        return studioRepository.findByName(name.trim());
    }

    /**
     * Finds a list of studios whose names contain the specified keyword.
     *
     * @param keyword The keyword to search for in studio names.
     * @return A list of studios whose names match the keyword. If no studios are found, returns an empty list.
     */
    public List<Studio> findStudiosByKeyword(String keyword) {
        return studioRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

