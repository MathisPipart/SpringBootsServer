package it.unito.iumtweb.springboot.release;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Release entities.
 * Provides methods to interact with the ReleaseRepository and perform business logic.
 */
@Service
public class ReleaseService {
    private final ReleaseRepository releaseRepository;

    /**
     * Constructs a ReleaseService with the specified ReleaseRepository.
     *
     * @param releaseRepository The repository used to manage Release entities.
     */
    @Autowired
    public ReleaseService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    /**
     * Finds a list of releases by their exact name.
     *
     * @param name The exact name of the release to find.
     * @return A list of releases with the specified name. If no releases are found, returns an empty list.
     */
    public List<Release> findReleaseByName(String name) {
        return releaseRepository.findByName(name.trim());
    }

    /**
     * Finds a list of releases whose names contain the specified keyword.
     *
     * @param keyword The keyword to search for in release names.
     * @return A list of releases whose names match the keyword. If no releases are found, returns an empty list.
     */
    public List<Release> findReleasesByKeyword(String keyword) {
        return releaseRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

