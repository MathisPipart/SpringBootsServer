package it.unito.iumtweb.springboot.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Language entities.
 * Provides endpoints for retrieving, filtering, and fetching distinct language-related data.
 */
@RestController
@RequestMapping("/languages")
public class LanguageController {
    private final it.unito.iumtweb.springboot.language.LanguageService languageService;

    /**
     * Constructs a LanguageController with the specified LanguageService.
     *
     * @param languageService The service used to manage Language entities.
     */
    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
     * Retrieves a list of languages by their exact name.
     *
     * @param name The exact name of the language to find.
     * @return A ResponseEntity containing a list of languages with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no languages are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.language.Language>> findLanguageByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.language.Language> languages = languageService.findLanguageByName(name);
        if (!languages.isEmpty()) {
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of languages whose names contain the specified keyword.
     *
     * @param name The keyword to search for in language names.
     * @return A ResponseEntity containing a list of languages with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no languages are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.language.Language>> findLanguagesByKeyword(@RequestParam String name) {
        List<Language> languages = languageService.findLanguagesByKeyword(name);
        if (!languages.isEmpty()) {
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of distinct language names.
     *
     * @return A ResponseEntity containing the list of distinct language names with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no data is available.
     */
    @GetMapping("/distinctLanguages")
    public ResponseEntity<List<String>> getDistinctLanguages() {
        List<String> distinctLanguages = languageService.findDistinctLanguages();
        if (!distinctLanguages.isEmpty()) {
            return new ResponseEntity<>(distinctLanguages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of distinct language types.
     *
     * @return A ResponseEntity containing the list of distinct language types with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no data is available.
     */
    @GetMapping("/distinctTypes")
    public ResponseEntity<List<String>> getDistinctTypes() {
        List<String> distinctTypes = languageService.findDistinctTypes();
        if (!distinctTypes.isEmpty()) {
            return new ResponseEntity<>(distinctTypes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

