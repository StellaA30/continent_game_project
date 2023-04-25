package com.example.continent_game.components;

import com.example.continent_game.models.Continent;
import com.example.continent_game.models.Country;
import com.example.continent_game.repositories.ContinentRepository;
import com.example.continent_game.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) {

//      CONTINENTS

//        List<String> rawContinentStrings = Arrays.asList(
//                "Africa",
//                "North America",
//                "South America",
//                "South Africa",
//                "Europe",
//                "Oceania"
//        );
//
//        for(String rawContinentString : rawContinentStrings){
//            Continent continent = new Continent(rawContinentString);
//            continentRepository.save(continent);
//        }

        Continent continentEurope = new Continent("Europe");
        continentRepository.save(continentEurope);
        Continent continentNorthAmerica = new Continent("North America");
        continentRepository.save(continentNorthAmerica);


//      EUROPE
//        European country names
        List<String> rawEuropeanCountryStrings = Arrays.asList(
                "Albania",
                "Andorra",
                "Austria",
                "Belarus",
                "Belgium",
                "Bosnia and Herzegovina",
                "Bulgaria"
        );
//        European GDPs
        List<Long> rawEuropeanCountryGDPsLongs = Arrays.asList(
                1234L,
                2345L,
                3456L,
                45674L,
                5678L,
                6789L,
                3456L
        );
//        European capitals
        List<String> rawEuropeanCountryCapitalCities = Arrays.asList(
                "Tirana",
                "Andorra La Vella",
                "Vienna",
                "Minsk",
                "Brussels",
                "Sarajevo",
                "Sofia"
        );
//        European populations
        List<Integer> rawEuropeanCountryPopulationsIntegers = Arrays.asList(
                1234,
                2345,
                3456,
                45674,
                5678,
                6789,
                4567
        );
//      generating European countries and adding them to the continent Europe
        for(int i = 0; i < rawEuropeanCountryStrings.size(); i++){
            Country country = new Country(
                    rawEuropeanCountryStrings.get(i),
                    rawEuropeanCountryGDPsLongs.get(i),
                    rawEuropeanCountryCapitalCities.get(i),
                    rawEuropeanCountryPopulationsIntegers.get(i),
                    continentEurope
            );
            countryRepository.save(country);
        }



//      NORTH AMERICA
//        North American country names
        List<String> rawNorthAmericanCountryStrings = Arrays.asList(
                "USA",
                "Canada"
        );
//        North American GDPs
        List<Long> rawNorthAmericanCountryGDPsLongs = Arrays.asList(
                1234L,
                2345L,
                3456L,
                45674L,
                5678L,
                6789L
        );
//        North American capitals
        List<String> rawNorthAmericanCountryCapitalCities = Arrays.asList(
                "Washington D.C.",
                "Toronto"
        );
//        North American populations
        List<Integer> rawNorthAmericanCountryPopulationsIntegers = Arrays.asList(
                1234,
                2345,
                3456,
                45674,
                5678,
                6789
        );
//      generating North American countries and adding them to the continent NorthAmerica
        for(int i = 0; i < rawNorthAmericanCountryStrings.size(); i++){
            Country country = new Country(
                    rawNorthAmericanCountryStrings.get(i),
                    rawNorthAmericanCountryGDPsLongs.get(i),
                    rawNorthAmericanCountryCapitalCities.get(i),
                    rawNorthAmericanCountryPopulationsIntegers.get(i),
                    continentNorthAmerica
            );
            countryRepository.save(country);
        }





//        CONTINENT: String name,
//        COUNTRY: String name, Long GDP, String capital, int population, Continent continent)


////        NORTH AMERICAN COUNTRIES
//        for(int i = 1; i < rawNorthAmericanCountryStrings.size() ; i++){
//            Country country = new Country(rawNorthAmericanCountryStrings.get(i), 1234567L, rawNorthAmericanCountryCapitalCities.get(i), 12345678, continentRepository.findById(2L).get());
//            countryRepository.save(country);
//        }



//        1)
//
//
//
//
//        for(String rawCountryString : rawAfricanCountryStrings){
//            Continent continent = new Continent("Africa");
//            continentRepository.save(continent);
//        }




////        CONTINENTS
//        Continent continentAfrica = new Continent("Africa");
//        continentRepository.save(continentAfrica);
//        Continent continentEurope = new Continent("Europe");
//        continentRepository.save(continentEurope);
//        Continent continentNorthAmerica = new Continent("NorthAmerica");
//        continentRepository.save(continentNorthAmerica);
//
//
//        ////        CONTINENT: String name,
//////        COUNTRY: String name, Long GDP, String capital, int population, Continent, continent)
//
////        COUNTRIES IN EUROPE
//        Country countryUnitedKingdom = new Country("United Kingdom", 3100000000000L, "London", 67330000, continentEurope);
//        Country countryFrance= new Country("France", 5100000000000L, "France", 100330000, continentEurope);
//        Country countryIreland= new Country("Ireland", 300000000000L, "Dublin", 100330000, continentEurope);
//        countryRepository.save(countryUnitedKingdom);
//        countryRepository.save(countryFrance);
//        countryRepository.save(countryIreland);
//
////        COUNTRIES IN AFRICA
//        Country countryEgypt = new Country("Egypt", 3100000000000L, "Cairo", 67330000, continentAfrica);
//        Country countryDjibouti= new Country("Djibouti", 5100000000000L, "Djibouti", 100330000, continentAfrica);
//        Country countrySouthAfrica= new Country("SouthAfrica", 300000000000L, "Johannesburg??", 100330000, continentAfrica);
//        countryRepository.save(countryEgypt);
//        countryRepository.save(countryDjibouti);
//        countryRepository.save(countrySouthAfrica);


    }


}

