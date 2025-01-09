package it.unito.iumtweb.springboot.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findGenreByName(String name) {
        return genreRepository.findByName(name.trim());
    }

    public List<Genre> findGenresByKeyword(String keyword) {
        return genreRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

    public List<String> findDistinctGenres() {
        return genreRepository.findDistinctGenres();
    }

}

