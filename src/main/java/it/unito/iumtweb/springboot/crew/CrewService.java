package it.unito.iumtweb.springboot.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Crew entities.
 * Provides methods to interact with the CrewRepository and perform business logic.
 */
@Service
public class CrewService {
    private final CrewRepository crewRepository;

    /**
     * Constructs a CrewService with the specified CrewRepository.
     *
     * @param crewRepository The repository used to manage Crew entities.
     */
    @Autowired
    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    /**
     * Finds a list of crew members by their exact name.
     *
     * @param name The exact name of the crew member to find.
     * @return A list of crew members with the specified name. If no crew members are found, returns an empty list.
     */
    public List<Crew> findCrewByName(String name) {
        return crewRepository.findByName(name.trim());
    }

    /**
     * Finds a list of crew members whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in crew member names.
     * @return A list of crew members whose names match the keyword. If no crew members are found, returns an empty list.
     */
    public List<Crew> findCrewsByKeyword(String keyword) {
        return crewRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

