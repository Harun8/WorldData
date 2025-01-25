package com.example.WorldData;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{


    @Query(value = "SELECT * FROM country_population WHERE country_name = :name", nativeQuery = true)
    List<Country> findByCountry(@Param("name") String name);

    @Query(value = "SELECT * FROM country_population LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Country> getPopulation(@Param("limit") int limit, @Param("offset") int offset);


    @Query(value = "SELECT DISTINCT country_name FROM country_population", nativeQuery = true)
    List<String> getUniqueCountries();
}
