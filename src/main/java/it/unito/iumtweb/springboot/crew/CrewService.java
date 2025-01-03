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

    public List<Crew> findCrewByName(String name) {
        return crewRepository.findByName(name.trim());
    }

    public List<Crew> findCrewsByKeyword(String keyword) {
        return crewRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

