package it.unito.iumtweb.springboot.poster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosterService {
    private final PosterRepository posterRepository;

    @Autowired
    public PosterService(PosterRepository posterRepository) {
        this.posterRepository = posterRepository;
    }
    
    public Poster savePoster(Poster poster) {
        return posterRepository.save(poster);
    }

    public void deletePosterById(Long id) {
        posterRepository.deleteById(id);
    }

    public Optional<Poster> findPosterById(Long id) {
        return posterRepository.findById(id);
    }

    public List<Poster> findPosterByName(String name) {
        return posterRepository.findByName(name.trim());
    }

    public List<Poster> findPostersByKeyword(String keyword) {
        return posterRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

