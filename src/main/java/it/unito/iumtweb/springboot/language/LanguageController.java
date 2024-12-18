package it.unito.iumtweb.springboot.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    private final it.unito.iumtweb.springboot.language.LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.language.Language> insertLanguage(@RequestBody it.unito.iumtweb.springboot.language.Language countrie) {
        it.unito.iumtweb.springboot.language.Language savedLanguage = languageService.saveLanguage(countrie);
        return new ResponseEntity<>(savedLanguage, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.language.Language> countrie = languageService.findLanguageById(id);
        if (countrie.isPresent()) {
            languageService.deleteLanguageById(id);
            return new ResponseEntity<>("Language deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Language not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.language.Language>> findLanguageByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.language.Language> languages = languageService.findLanguageByName(name);
        if (!languages.isEmpty()) {
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.language.Language>> findLanguagesByKeyword(@RequestParam String name) {
        List<Language> languages = languageService.findLanguagesByKeyword(name);
        if (!languages.isEmpty()) {
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/distinct")
    public ResponseEntity<List<String>> getDistinctLanguages() {
        List<String> distinctLanguages = languageService.findDistinctLanguages();
        if (!distinctLanguages.isEmpty()) {
            return new ResponseEntity<>(distinctLanguages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

