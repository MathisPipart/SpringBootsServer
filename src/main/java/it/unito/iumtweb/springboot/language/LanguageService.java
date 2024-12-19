package it.unito.iumtweb.springboot.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    
    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }

    public void deleteLanguageById(Long id) {
        languageRepository.deleteById(id);
    }

    public Optional<Language> findLanguageById(Long id) {
        return languageRepository.findById(id);
    }

    public List<Language> findLanguageByName(String name) {
        return languageRepository.findByName(name.trim());
    }

    public List<Language> findLanguagesByKeyword(String keyword) {
        return languageRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

    public List<String> findDistinctLanguages() {
        return languageRepository.findDistinctLanguages();
    }

    public List<String> findDistinctTypes() {
        return languageRepository.findDistinctTypes();
    }

}

