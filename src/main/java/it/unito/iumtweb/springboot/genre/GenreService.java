package it.unito.iumtweb.springboot.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }

    public Optional<Genre> findGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public List<Genre> findGenreByName(String name) {
        return genreRepository.findByName(name.trim());
    }

    public List<Genre> findGenresByKeyword(String keyword) {
        return genreRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

