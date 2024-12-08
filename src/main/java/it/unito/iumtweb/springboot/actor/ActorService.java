package it.unito.iumtweb.springboot.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public void deleteActorById(Long id) {
        actorRepository.deleteById(id);
    }

    public Optional<Actor> findActorById(Long id) {
        return actorRepository.findById(id);
    }

    public List<Actor> findActorByName(String name) {
        return actorRepository.findByName(name.trim());
    }

    public List<Actor> findActorsByKeyword(String keyword) {
        return actorRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

