package it.unito.iumtweb.springboot.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Country entities.
 * Provides endpoints to interact with the CountryService for retrieving Country data.
 */
@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    /**
     * Constructs a CountryController with the specified CountryService.
     *
     * @param countryService The service used to manage Country entities.
     */
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Retrieves a list of countries by their exact name.
     *
     * @param name The exact name of the country to find.
     * @return A ResponseEntity containing a list of countries with the specified name and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no countries are found.
     */
    @GetMapping("/findByName")
    public ResponseEntity<List<Country>> findCountryByName(@RequestParam String name) {
        List<Country> countries = countryService.findCountryByName(name);
        if (!countries.isEmpty()) {
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of countries whose names contain the specified keyword.
     *
     * @param name The keyword to search for in country names.
     * @return A ResponseEntity containing a list of countries whose names match the keyword and HTTP status OK (200),
     *         or HTTP status NOT FOUND (404) if no countries are found.
     */
    @GetMapping("/findByKeyword")
    public ResponseEntity<List<Country>> findCountrysByKeyword(@RequestParam String name) {
        List<Country> countries = countryService.findCountrysByKeyword(name);
        if (!countries.isEmpty()) {
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

