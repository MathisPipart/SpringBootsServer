package it.unito.iumtweb.springboot.theme;

import it.unito.iumtweb.springboot.theme.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Theme entities.
 * Provides endpoints for retrieving and filtering themes by name or keyword.
 */
@RestController
@RequestMapping("/themes")
public class ThemeController {
    private final it.unito.iumtweb.springboot.theme.ThemeService themeService;

    /**
     * Constructs a ThemeController with the specified ThemeService.
     *
     * @param themeService The service used to manage Theme entities.
     */
    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    /**
     * Retrieves a list of themes by their exact name.
     *
     * @param name The exact name of the theme to find.
     * @return A ResponseEntity containing a list of themes with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no themes are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<it.unito.iumtweb.springboot.theme.Theme>> findThemeByName(@RequestParam String name) {
        List<it.unito.iumtweb.springboot.theme.Theme> themes = themeService.findThemeByName(name);
        if (!themes.isEmpty()) {
            return new ResponseEntity<>(themes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of themes whose names contain the specified keyword.
     *
     * @param name The keyword to search for in theme names.
     * @return A ResponseEntity containing a list of themes with HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no themes are found.
     */
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

