package it.unito.iumtweb.springboot.release;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseService {
    private final ReleaseRepository releaseRepository;

    @Autowired
    public ReleaseService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public List<Release> findReleaseByName(String name) {
        return releaseRepository.findByName(name.trim());
    }

    public List<Release> findReleasesByKeyword(String keyword) {
        return releaseRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

