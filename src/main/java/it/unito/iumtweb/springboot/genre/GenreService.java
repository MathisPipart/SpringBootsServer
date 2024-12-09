package it.unito.iumtweb.springboot.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository actorRepository;

    @Autowired
    public GenreService(GenreRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    
    public Genre saveGenre(Genre genre) {
        return actorRepository.save(genre);
    }

    public void deleteGenreById(Long id) {
        actorRepository.deleteById(id);
    }

    public Optional<Genre> findGenreById(Long id) {
        return actorRepository.findById(id);
    }

    public List<Genre> findGenreByName(String name) {
        return actorRepository.findByName(name.trim());
    }

    public List<Genre> findGenresByKeyword(String keyword) {
        return actorRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

