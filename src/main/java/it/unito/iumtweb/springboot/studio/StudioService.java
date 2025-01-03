package it.unito.iumtweb.springboot.studio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {
    private final StudioRepository studioRepository;

    @Autowired
    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public List<Studio> findStudioByName(String name) {
        return studioRepository.findByName(name.trim());
    }

    public List<Studio> findStudiosByKeyword(String keyword) {
        return studioRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

