package it.unito.iumtweb.springboot.theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }
    
    public Theme saveTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    public void deleteThemeById(Long id) {
        themeRepository.deleteById(id);
    }

    public Optional<Theme> findThemeById(Long id) {
        return themeRepository.findById(id);
    }

    public List<Theme> findThemeByName(String name) {
        return themeRepository.findByName(name.trim());
    }

    public List<Theme> findThemesByKeyword(String keyword) {
        return themeRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}
