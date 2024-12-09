package it.unito.iumtweb.springboot.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewService {
    private final CrewRepository actorRepository;

    @Autowired
    public CrewService(CrewRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    
    public Crew saveCrew(Crew crew) {
        return actorRepository.save(crew);
    }

    public void deleteCrewById(Long id) {
        actorRepository.deleteById(id);
    }

    public Optional<Crew> findCrewById(Long id) {
        return actorRepository.findById(id);
    }

    public List<Crew> findCrewByName(String name) {
        return actorRepository.findByName(name.trim());
    }

    public List<Crew> findCrewsByKeyword(String keyword) {
        return actorRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

