package com.example.WorldData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);


    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    public List<Country> getCountry(String country) {
        return countryRepository.findByCountry(country); // Use findById and Long instead of getById
    }


    public List<String> getAllCountries() {
        return countryRepository.getUniqueCountries();
    }

    public List<Country> getPopulations(int pageSize, int page) {
        int offset = (page - 1) * pageSize; // Calculate offset
        return countryRepository.getPopulation(pageSize,offset);
    }
}
