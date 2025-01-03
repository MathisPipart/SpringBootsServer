package it.unito.iumtweb.springboot.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findCountryByName(String name) {
        return countryRepository.findByName(name.trim());
    }

    public List<Country> findCountrysByKeyword(String keyword) {
        return countryRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

