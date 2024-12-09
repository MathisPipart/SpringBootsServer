package it.unito.iumtweb.springboot.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Country> insertCountry(@RequestBody Country countrie) {
        Country savedCountry = countryService.saveCountry(countrie);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id) {
        Optional<Country> countrie = countryService.findCountryById(id);
        if (countrie.isPresent()) {
            countryService.deleteCountryById(id);
            return new ResponseEntity<>("Country deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Country not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Country>> findCountryByName(@RequestParam String name) {
        List<Country> countries = countryService.findCountryByName(name);
        if (!countries.isEmpty()) {
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

