package it.unito.iumtweb.springboot.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Country entities.
 * Provides methods to interact with the CountryRepository and perform business logic.
 */
@Service
public class CountryService {
    private final CountryRepository countryRepository;

    /**
     * Constructs a CountryService with the specified CountryRepository.
     *
     * @param countryRepository The repository used to manage Country entities.
     */
    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * Finds a list of countries by their exact name.
     *
     * @param name The exact name of the country to find.
     * @return A list of countries with the specified name. If no countries are found, returns an empty list.
     */
    public List<Country> findCountryByName(String name) {
        return countryRepository.findByName(name.trim());
    }

    /**
     * Finds a list of countries whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in country names.
     * @return A list of countries whose names match the keyword. If no countries are found, returns an empty list.
     */
    public List<Country> findCountrysByKeyword(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

