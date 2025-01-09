package it.unito.iumtweb.springboot.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Language entities.
 * Provides methods to interact with the LanguageRepository and perform business logic.
 */
@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    /**
     * Constructs a LanguageService with the specified LanguageRepository.
     *
     * @param languageRepository The repository used to manage Language entities.
     */
    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    /**
     * Finds a list of languages by their exact name.
     *
     * @param name The exact name of the language to find.
     * @return A list of languages with the specified name. If no languages are found, returns an empty list.
     */
    public List<Language> findLanguageByName(String name) {
        return languageRepository.findByName(name.trim());
    }

    /**
     * Finds a list of languages whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in language names.
     * @return A list of languages whose names match the keyword. If no languages are found, returns an empty list.
     */
    public List<Language> findLanguagesByKeyword(String keyword) {
        return languageRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

    /**
     * Retrieves a list of distinct language names.
     *
     * @return A list of unique language names.
     */
    public List<String> findDistinctLanguages() {
        return languageRepository.findDistinctLanguages();
    }

    /**
     * Retrieves a list of distinct language types.
     *
     * @return A list of unique language types.
     */
    public List<String> findDistinctTypes() {
        return languageRepository.findDistinctTypes();
    }

}

