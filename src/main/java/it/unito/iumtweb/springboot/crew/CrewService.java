package it.unito.iumtweb.springboot.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewService {
    private final CrewRepository crewRepository;

    @Autowired
    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }
    
    public Crew saveCrew(Crew crew) {
        return crewRepository.save(crew);
    }

    public void deleteCrewById(Long id) {
        crewRepository.deleteById(id);
    }

    public Optional<Crew> findCrewById(Long id) {
        return crewRepository.findById(id);
    }

    public List<Crew> findCrewByName(String name) {
        return crewRepository.findByName(name.trim());
    }

    public List<Crew> findCrewsByKeyword(String keyword) {
        return crewRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

