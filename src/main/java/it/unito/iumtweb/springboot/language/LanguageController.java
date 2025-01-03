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

    @GetMapping("/distinctLanguages")
    public ResponseEntity<List<String>> getDistinctLanguages() {
        List<String> distinctLanguages = languageService.findDistinctLanguages();
        if (!distinctLanguages.isEmpty()) {
            return new ResponseEntity<>(distinctLanguages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

