package it.unito.iumtweb.springboot.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository actorRepository;

    @Autowired
    public CountryService(CountryRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    
    public Country saveCountry(Country country) {
        return actorRepository.save(country);
    }

    public void deleteCountryById(Long id) {
        actorRepository.deleteById(id);
    }

    public Optional<Country> findCountryById(Long id) {
        return actorRepository.findById(id);
    }

    public List<Country> findCountryByName(String name) {
        return actorRepository.findByName(name.trim());
    }

    public List<Country> findCountrysByKeyword(String keyword) {
        return actorRepository.findByNameContainingIgnoreCase(keyword.trim());
    }

}

