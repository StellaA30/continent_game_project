package com.example.continent_game.repositories;

import com.example.continent_game.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    // derive meaning by name of method instead of for loop shenannigans, .contains()
    // ignorecase
    // when you want to do some specific querying like sql query
    Country findCountryByNameIgnoreCase(String name);

}
