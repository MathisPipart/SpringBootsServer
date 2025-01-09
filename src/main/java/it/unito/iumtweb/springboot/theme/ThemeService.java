package it.unito.iumtweb.springboot.theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Theme entities.
 * Provides methods to interact with the ThemeRepository and perform business logic.
 */
@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    /**
     * Constructs a ThemeService with the specified ThemeRepository.
     *
     * @param themeRepository The repository used to manage Theme entities.
     */
    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    /**
     * Finds a list of themes by their exact name.
     *
     * @param name The exact name of the theme to find.
     * @return A list of themes with the specified name. If no themes are found, returns an empty list.
     */
    public List<Theme> findThemeByName(String name) {
        return themeRepository.findByName(name.trim());
    }

    /**
     * Finds a list of themes whose names contain the specified keyword.
     *
     * @param keyword The keyword to search for in theme names.
     * @return A list of themes whose names match the keyword. If no themes are found, returns an empty list.
     */
    public List<Theme> findThemesByKeyword(String keyword) {
        return themeRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

