package com.example.continent_game.components;

import com.example.continent_game.models.Continent;
import com.example.continent_game.models.Country;
import com.example.continent_game.models.Player;
import com.example.continent_game.repositories.ContinentRepository;
import com.example.continent_game.repositories.CountryRepository;
import com.example.continent_game.repositories.PlayerRepository;
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

    @Autowired
    PlayerRepository playerRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) {


        //CREATE NEW PLAYERS
        Player player1 = new Player("Katie");
        playerRepository.save(player1);

        Player player2 = new Player("Khalid");
        playerRepository.save(player2);

        Player player3 = new Player("Stella");
        playerRepository.save(player3);

        Player player4 = new Player("Umar");
        playerRepository.save(player4);

        Player player5 = new Player("Elizabeth");
        playerRepository.save(player5);



//  Order:
//  A) CONTINENTS: Creating them and saving them to the Continent Repo        |   line 45
//  B1) COUNTRIES: Creating the raw data needed for creating Country objects  |   line 63
//        1. African countries                                                |   line 66
//        2. Asian countries                                                  |   line 124
//        3. European countries                                               |   line 178
//        4. North American countries                                         |   line 232
//        5. Oceanian countries                                               |   line 266
//        6. South American countries                                         |   line 292
//  B2) COUNTRIES: Creating them and saving them to the Country Repo          |   line 319
//



//  A) CONTINENTS: Creating them and saving them to the Continent Repo
//        create continent objects
        Continent africa = new Continent("Africa");
        Continent asia = new Continent("Asia");
        Continent europe = new Continent("Europe");
        Continent northAmerica = new Continent("North America");
        Continent oceania = new Continent("Oceania");
        Continent southAmerica = new Continent("South America");
//        save them to the repo
        continentRepository.save(africa);
        continentRepository.save(asia);
        continentRepository.save(europe);
        continentRepository.save(northAmerica);
        continentRepository.save(oceania);
        continentRepository.save(southAmerica);



//  B1) COUNTRIES: Creating the raw data needed for creating Country objects
//                 (note: corresponding index positions - don't change order)

//      1. AFRICAN COUNTRIES
//          1.1 African country names
        List<String> rawAfricanCountryNames = Arrays.asList(
                "Algeria", "Angola", "Benin", "Botswana", "Burkina Faso",
                "Burundi", "Cameroon", "Cape Verde", "Central African Republic", "Comoros",
                "Democratic Republic of the Congo", "Republic of the Congo", "Djibouti", "Egypt", "Equatorial Guinea",
                "Eritrea", "Eswatini", "Ethiopia", "Gabon", "Gambia",
                "Ghana", "Guinea", "Guinea-Bissau", "Chad", "Ivory Coast",
                "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar",
                "Malawi", "Mali", "Mauritania", "Mauritius", "Morocco",
                "Mozambique", "Namibia", "Niger", "Nigeria", "Rwanda",
                "São Tomé and Príncipe", "Senegal", "Seychelles", "Sierra Leone", "Somalia",
                "South Africa", "South Sudan", "Sudan", "Tanzania", "Togo",
                "Tunisia", "Uganda", "Western Sahara", "Zambia", "Zimbabwe" // 55 countries in this list (5 in each row)
        );
//          1.2 African GDPs
        List<Long> rawAfricanGDPs = Arrays.asList(
                15292L, 6657L, 2276L, 17024L, 1866L,
                735L, 3722L, 6912L, 727L, 2751L,
                889L, 5454L, 2705L, 11608L, 24439L,
                1510L, 8659L, 1903L, 18113L, 1699L,
                4501L, 2247L, 1703L, 1945L, 3944L,
                3292L, 2932L, 1285L, 19673L, 1558L,
                1204L, 2218L, 3958L, 22356L, 8225L,
                1250L, 10470L, 1018L, 5887L, 2043L,
                3358L, 3457L, 29327L, 1530L, 0L,
                13526L, 1694L, 4914L, 2947L, 1663L,
                11936L, 1868L, 0L, 4032L, 2433L // 55 in this list
        );
//          1.3 African capitals
        List<String> rawAfricanCapitalCities = Arrays.asList(
                "Algiers", "Luanda", "Porto Novo", "Gaborone", "Ouagadougou",
                "Gitega", "Yaoundé", "Praia", "Bangui", "Moroni",
                "Kinshasa", "Brazzaville", "Djibouti", "Cairo", "Malabo",
                "Asmara", "Mbabane", "Addis Ababa", "Libreville", "Banjul",
                "Accra", "Conakry", "Bissau", "N'Djamena", "Yamoussoukro",
                "Nairobi", "Maseru", "Monrovia", "Tripoli", "Antananarivo",
                "Lilongwe", "Bamako", "Nouakchott", "Port Louis", "Rabat",
                "Maputo", "Windhoek", "Niamey", "Abuja", "Kigali",
                "São Tomé", "Dakar", "Victoria", "Freetown", "Mogadishu",
                "Pretoria", "Juba", "Khartoum", "Dodoma", "Lomé",
                "Tunis", "Kampala", "Laayoune", "Lusaka", "Harare" // 55 capital cities in this list (5 in each row)
        );
//          1.4 African populations
        List<Integer> rawAfricanPopulations = Arrays.asList(
                42545964, 29250009, 11362269, 2024904, 20244080,
                10681186, 23794164, 491875, 4667000, 724300,
                84004989, 4324000, 818159, 97907000, 761000,
                5748000, 1237000, 107534882, 1594000, 1874000,
                29614337, 11883516, 1520830, 15353184, 24571044,
                50950879, 2240000, 3476608, 6506000, 26262810,
                17931637, 19107706, 3461041, 1257900, 35361000,
                28861863, 2104900, 21466863, 193392517, 12001136,
                187356, 15726037, 90945, 6255000, 15181925,
                57725600, 12323419, 41029953, 54199163, 6191155,
                11446300, 38823100, 567402, 16887720, 14848905 // 55 GDPs per capita in this list (need to change this to GDP as we've done or vice versa)
        );

//      2. ASIAN COUNTRIES
//          2.1 Asian country names
        List<String> rawAsianCountryNames = Arrays.asList(
                "Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh",
                "Bhutan", "Brunei", "Cambodia", "East Timor", "Georgia",
                "China", "India", "Indonesia", "Iran", "Iraq",
                "Israel", "Japan", "Jordan", "Kazakhstan", "North Korea",
                "South Korea", "Kuwait", "Kyrgyzstan", "Laos", "Lebanon",
                "Malaysia", "Maldives", "Mongolia", "Myanmar", "Nepal",
                "Oman", "Pakistan", "Palestine", "Philippines", "Qatar",
                "Saudi Arabia", "Singapore", "Sri Lanka", "Syria", "Tajikistan",
                "Thailand", "Turkmenistan", "United Arab Emirates", "Uzbekistan", "Vietnam",
                "Yemen" // 46 in list (5 in each row)
        );
//          2.2 Asian GDPs
        List<Long> rawAsianGDPs = Arrays.asList(
                1976L, 9668L, 17449L, 47708L, 3877L,
                9391L, 79003L, 4017L, 7228L, 10674L,
                16842L, 7166L, 12309L, 20884L, 16935L,
                38867L, 42066L, 9172L, 26490L, 0L,
                38824L, 72095L, 3735L, 7038L, 14512L,
                29511L, 16688L, 12945L, 6173L, 2702L,
                41331L, 5539L, 0L, 8360L, 128646L,
                53893L, 94104L, 12862L, 0L, 3201L,
                17910L, 18030L, 74035L, 6879L, 6790L,
                2606L // 46 in list (5 in each row)
        );
//          2.3 Asian capitals
        List<String> rawAsianCapitalCities = Arrays.asList(
                "Kabul", "Yerevan", "Baku", "Manama", "Dhaka",
                "Thimphu", "Bandar Seri Begawan", "Phnom Penh", "Dili", "Tbilisi",
                "Beijing", "New Delhi", "Jakarta", "Tehran", "Baghdad",
                "Tel Aviv", "Tokyo", "Amman", "Nur-Sultan", "Pchjongjang",
                "Seoul", "Kuwait City", "Bishkek", "Vientiane", "Beirut",
                "Kuala Lumpur", "Malé", "Ulaanbaatar", "Naypyidaw", "Kathmandu",
                "Muscat", "Islamabad", "Ramallah", "Manila", "Doha",
                "Riyadh", "Singapore", "Colombo", "Damascus", "Dushanbe",
                "Bangkok", "Ashgabat", "Abu Dhabi", "Tashkent", "Hanoi",
                "Sana'á" // 46 in list (5 in each row)
        );
//          2.4 Asian populations
        List<Integer> rawAsianPopulations = Arrays.asList(
                31575018, 3031200, 9235100, 1234571, 165570000,
                733180, 393162, 16069921, 1066409, 4497600,
                1393302000, 1353919000, 265015300, 81972000, 39339753,
                8002300, 126440000, 6284000, 18367000, 25610672,
                51635256, 3582054, 5551900, 6580800, 4324000,
                32527000, 328536, 2736800, 53862731, 29218867,
                2773479, 202594000, 4293313, 106792000, 1917116,
                33413660, 5312400, 21670000, 18284407, 7800000,
                69183173, 5235000, 8264070, 32653900, 94660000,
                28915284 // 46 in list (5 in each row)
        );

//      3. EUROPEAN COUNTRIES
//          3.1 European country names
        List<String> rawEuropeanCountryNames = Arrays.asList(
                "Albania", "Andorra", "Austria", "Belarus", "Belgium",
                "Bosnia and Herzegovina", "Bulgaria", "Croatia", "Cyprus", "Czechia",
                "Denmark", "Estonia", "Finland", "France", "Germany",
                "Greece", "Hungary", "Iceland", "Ireland", "Italy",
                "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Malta",
                "Moldova", "Monaco", "Montenegro", "Netherlands", "North Macedonia",
                "Norway", "Poland", "Portugal", "Romania", "Russia",
                "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain",
                "Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom",
                "Vatican City" // 46 countries in this list (5 in each row)
        );
//          3.2 European GDPs
        List<Long> rawEuropeanGDPs = Arrays.asList(
                12943L, 0L, 53879L, 18895L, 49366L,
                13107L, 20948L, 26295L, 36012L, 30019L,
                54356L, 33447L, 46343L, 44032L, 52555L,
                28582L, 28798L, 55322L, 76744L, 40923L,
                28362L, 0L, 33252L, 107640L, 40796L,
                5710L, 0L, 19354L, 54422L, 15290L,
                62182L, 29923L, 32554L, 26660L, 25763L,
                63548L, 15431L, 32371L, 36387L, 39037L,
                51404L, 66307L, 28001L, 8698L, 44920L,
                0L // 46 GDPs per capita in this list (need to change this to GDP as we've done or vice versa)
        );
//          3.3 European capitals
        List<String> rawEuropeanCapitalCities = Arrays.asList(
                "Tirana", "Andorra La Vella", "Vienna", "Minsk", "Brussels",
                "Sarajevo", "Sofia", "Zagreb", "Nicosia", "Prague",
                "Copenhagen", "Tallinn", "Helsinki", "Paris", "Berlin",
                "Athens", "Budapest", "Reykjavik", "Dublin", "Rome",
                "Riga", "Vaduz", "Vilnius", "Luxembourg", "Valletta",
                "Chișinău", "Monaco", "Podgorica", "Amsterdam", "Skopje",
                "Oslo", "Warsaw", "Lisbon", "Bucharest", "Moscow",
                "San Marino", "Belgrade", "Bratislava", "Ljubljana", "Madrid",
                "Stockholm", "Bern", "Ankara", "Kiev", "London",
                "Vatican City" // 46 capital cities in this list (5 in each row)
        );
//          3.4 European populations
        List<Integer> rawEuropeanPopulations = Arrays.asList(
                2821977, 76246, 8488511, 9461800, 11428164,
                3839737, 7050034, 4290612, 862000, 10649800,
                5602628, 1286540, 5433730, 67348000, 82793800,
                10768193, 9957731, 321857, 4585400, 59499534,
                2027000, 36842, 2972949, 524900, 416055,
                3559500, 35352, 620029, 17273000, 2059794,
                5051275, 38433600, 10291027, 19523621, 146877088,
                32480, 7189705, 5412008, 2059509, 46659302,
                9566945, 8014000, 80810525, 42234014, 66040229,
                836 // 46 country populations in this list (5 in each row)
        );

//      4. NORTH AMERICAN COUNTRIES
//          4.1 North American country names
        List<String> rawNorthAmericanCountryNames = Arrays.asList(
                "Antigua and Barbuda", "The Bahamas", "Barbados", "Belize", "Canada",
                "Costa Rica", "Cuba", "Dominica", "Dominican Republic", "El Salvador",
                "Grenada", "Guatemala", "Haiti", "Honduras", "Jamaica",
                "Mexico", "Nicaragua", "Panama", "Saint Kitts and Nevis", "Saint Lucia",
                "Saint Vincent and the Grenadines", "Trinidad and Tobago", "United States of America" // 23 in this list
        );
//          4.2 North American GDPs
        List<Long> rawNorthAmericanGDPs = Arrays.asList(
                23522L, 30494L, 18559L, 8525L, 46509L,
                17109L, 0L, 10037L, 16063L, 8023L,
                15155L, 8167L, 1818L, 4996L, 9065L,
                18655L, 5854L, 24520L, 28636L, 13986L,
                11769L, 31644L, 59927L // 23 in this list
        );
//          4.3 North American capitals
        List<String> rawNorthAmericanCapitalCities = Arrays.asList(
                "Saint John's", "Nassau", "Bridgetown", "Belmopan", "Ottowa",
                "San José", "Havana", "Roseau", "Santo Domingo", "San Salvador",
                "Saint George's", "Guatemala City", "Port-au-Prince", "Tegucigalpa", "Kingston",
                "Mexico City", "Managua", "Panama City", "Basseterre", "Castries",
                "Kingstown", "Port of Spain", "Washington, D.C." // 23 in this list
        );
//          4.4 North American populations
        List<Integer> rawNorthAmericanPopulations = Arrays.asList(
                86295, 351461, 274200, 312971, 37067000,
                4667096, 11221060, 71293, 9445281, 6183000,
                103328, 17302084, 11112945, 8385072, 2709300,
                119938473, 6071045, 3405813, 51970, 166526,
                100892, 1328019, 329035000 // 23 in this list
        );

//      5. OCEANIAN COUNTRIES
//          5.1 Oceanian country names
        List<String> rawOceanianCountryNames = Arrays.asList(
                "Australia", "Fiji", "Kiribati", "Marshall Islands", "Micronesia",
                "Nauru", "New Zealand", "Palau", "Papua New Guinea", "Samoa",
                "Solomon Islands", "Tonga", "Tuvalu", "Vanuatu" // 14 country names
        );
//          5.2 Oceanian GDPs
        List<Long> rawOceanianGDPs = Arrays.asList(
                49378L, 9574L, 2185L, 4246L, 3700L,
                15039L, 40747L, 14854L, 4207L, 6640L,
                2426L, 5969L, 3933L, 3214L // 14 GDPs per capita in this list (need to change this to GDP as we've done or vice versa)
        );
//          5.3 Oceanian capitals
        List<String> rawOceanianCapitalCities = Arrays.asList(
                "Canberra", "Suva", "Tarawa", "Majuro", "Palikir",
                "Yaren", "Wellington", "Ngerulmud", "Port Moresby", "Apia",
                "Honiara", "Nuku'alofa", "Funafuti", "Port Vila" // 14 capital cities
        );
//          5.4 Oceanian populations
        List<Integer> rawOceanianPopulations = Arrays.asList(
                25130600, 858038, 104573, 55548, 101823,
                9945, 4464300, 20770, 7059629, 187820,
                642000, 103036, 11264, 258213 // 14 country populations
        );

//      6. SOUTH AMERICAN COUNTRIES
//          6.1 South American country names
        List<String> rawSouthAmericanCountryNames = Arrays.asList(
                "Argentina", "Bolivia", "Brazil", "Chile", "Colombia",
                "Ecuador", "Guyana", "Paraguay", "Peru", "Suriname",
                "Uruguay", "Venezuela" // 12 in this list
        );
//          6.2 South American GDPs
        List<Long> rawSouthAmericanGDPs = Arrays.asList(
                20828L, 7575L, 15553L, 24747L, 14503L,
                11612L, 8179L, 13109L, 13462L, 15191L,
                22610L, 17694L // 12 in this list
        );
//          6.3 South American capitals
        List<String> rawSouthAmericanCapitalCities = Arrays.asList(
                "Buenos Aires", "La Paz Sucre", "Brasilia", "Santiago", "Bogotá",
                "Quito", "Georgetown", "Asunción", "Lima", "Paramaribo",
                "Montevideo", "Caracas" // 12 in this list
        );
//          6.4 South American populations
        List<Integer> rawSouthAmericanPopulations = Arrays.asList(
                44494502, 11307314, 209134000, 17574003, 50047300,
                17120000, 784894, 6561785, 32162184, 534189,
                3286314, 31828110 // 12 in this list
        );


//  B2) COUNTRIES: Creating them and saving them to the Country Repo
//        1. African Countries
        for (int i = 0; i < rawAfricanCountryNames.size(); i++) {
            Country country = new Country(
                    rawAfricanCountryNames.get(i),
                    rawAfricanGDPs.get(i),
                    rawAfricanCapitalCities.get(i),
                    rawAfricanPopulations.get(i),
                    africa
            );
            countryRepository.save(country);
        }

//        2. Asian countries
        for (int i = 0; i < rawAsianCountryNames.size(); i++) {
            Country country = new Country(
                    rawAsianCountryNames.get(i),
                    rawAsianGDPs.get(i),
                    rawAsianCapitalCities.get(i),
                    rawAsianPopulations.get(i),
                    asia
            );
            countryRepository.save(country);
        }

//        3. European countries
        for (int i = 0; i < rawEuropeanCountryNames.size(); i++) {
            Country country = new Country(
                    rawEuropeanCountryNames.get(i),
                    rawEuropeanGDPs.get(i),
                    rawEuropeanCapitalCities.get(i),
                    rawEuropeanPopulations.get(i),
                    europe
            );
            countryRepository.save(country);
        }

//        4. North American countries
        for (int i = 0; i < rawNorthAmericanCountryNames.size(); i++) {
            Country country = new Country(
                    rawNorthAmericanCountryNames.get(i),
                    rawNorthAmericanGDPs.get(i),
                    rawNorthAmericanCapitalCities.get(i),
                    rawNorthAmericanPopulations.get(i),
                    northAmerica
            );
            countryRepository.save(country);
        }

//        5. Oceanian countries
        for (int i = 0; i < rawOceanianCountryNames.size(); i++) {
            Country country = new Country(
                    rawOceanianCountryNames.get(i),
                    rawOceanianGDPs.get(i),
                    rawOceanianCapitalCities.get(i),
                    rawOceanianPopulations.get(i),
                    oceania
            );
            countryRepository.save(country);
        }

//        6. South American countries
        for (int i = 0; i < rawSouthAmericanCountryNames.size(); i++) {
            Country country = new Country(
                    rawSouthAmericanCountryNames.get(i),
                    rawSouthAmericanGDPs.get(i),
                    rawSouthAmericanCapitalCities.get(i),
                    rawSouthAmericanPopulations.get(i),
                    southAmerica
            );
            countryRepository.save(country);
        }


    }


}
