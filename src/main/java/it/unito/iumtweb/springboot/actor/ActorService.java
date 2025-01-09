package it.unito.iumtweb.springboot.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Actor entities.
 * Provides methods to interact with the ActorRepository and perform business logic.
 */
@Service
public class ActorService {
    private final ActorRepository actorRepository;

    /**
     * Constructs an ActorService with the specified ActorRepository.
     *
     * @param actorRepository The repository used to interact with Actor entities.
     */
    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    /**
     * Finds a list of actors by their exact name.
     *
     * @param name The exact name of the actor(s) to find.
     * @return A list of actors with the specified name. If no actors are found, returns an empty list.
     */
    public List<Actor> findActorByName(String name) {
        return actorRepository.findByName(name.trim());
    }

    /**
     * Finds a list of actors whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for within actor names.
     * @return A list of actors whose names match the keyword. If no actors are found, returns an empty list.
     */
    public List<Actor> findActorsByKeyword(String keyword) {
        return actorRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

