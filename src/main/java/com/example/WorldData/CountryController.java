package com.example.WorldData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/country")
public class CountryController {


    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/country")
    public List<Country> getCountryPopulation(@RequestParam String country){

        return countryService.getCountry(country);

    }

    @GetMapping("/population")
    public List<Country> getPopulations(@RequestParam(defaultValue = "10") int perPage,  @RequestParam(defaultValue = "1") int page){

        return countryService.getPopulations(perPage, page);

    }



//    @GetMapping
//    public List<String> getCountries(){
//
//        return countryService.getAllCountries();
//
//    }
}
