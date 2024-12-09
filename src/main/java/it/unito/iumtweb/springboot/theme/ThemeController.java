package it.unito.iumtweb.springboot.theme;

import it.unito.iumtweb.springboot.theme.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/themes")
public class ThemeController {
    private final it.unito.iumtweb.springboot.theme.ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/insert")
    public ResponseEntity<it.unito.iumtweb.springboot.theme.Theme> insertTheme(@RequestBody it.unito.iumtweb.springboot.theme.Theme countrie) {
        it.unito.iumtweb.springboot.theme.Theme savedTheme = themeService.saveTheme(countrie);
        return new ResponseEntity<>(savedTheme, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTheme(@PathVariable Long id) {
        Optional<it.unito.iumtweb.springboot.theme.Theme> countrie = themeService.findThemeById(id);
        if (countrie.isPresent()) {
            themeService.deleteThemeById(id);
            return new ResponseEntity<>("Theme deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Theme not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.theme.Theme>> findThemeByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.theme.Theme> themes = themeService.findThemeByName(name);
        if (!themes.isEmpty()) {
            return new ResponseEntity<>(themes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<List<it.unito.iumtweb.springboot.theme.Theme>> findThemesByKeyword(@RequestParam String name) {
        List<Theme> themes = themeService.findThemesByKeyword(name);
        if (!themes.isEmpty()) {
            return new ResponseEntity<>(themes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

