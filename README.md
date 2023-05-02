# Continent game project
## Introduction
This is a game where the aim is to name as many countries in a randomly given continent as possible, if you repeat a guess it won't increase your score or penalty, and if you get 5 wrong guesses the game will end. As a group we decided on a quiz/game, and we were inspired by Geo-guessr, Jetpunk's country guesser and the idea of a world quiz.

## Prerequisites
### Requirements for running back-end game code:
* Download intellij/VSCode for editing/displaying back-end code (intellij preferrable)
* For Command Line Tools, it's recommended to download:
>* Xcode Command line tools (easier terminal control)
>* Postgres + SQL(for the Game Database and its language)
>* Oh My Zsh (nicer terminal experience)
>* Git (for version control)
>* HomeBrew 15.2 (ease of package management)
* Other recommended off-the-web downloads include:
>* Java 17 (back-end code language)
>* Postman(for the API to mimic the front-end responses and test different API requests)
>* Postico (for the viewing of Game database information)
* Using Spring initializr, the recommended dependencies that were incorporated in the back-end code design were:
>* Spring Web
>* Spring Boot DevTools
>* PostgreSQL Driver
>* Spring Data JPA




## Data Structure of project:
The `models` package consists of 7 classes, 4 of  which are used to define how the classes are mapped to the database:
1) A `Continent` POJO class for the continents used to play the game
2) A `Country` POJO class with properties including `name`, `GDP per capita`, `population`, `capital`, and which `continent` it belongs to
3) A `Game` class for the game information 
4) 3 `DTOs`: `CountryDTO`, `Reply` to handle the replies when playing the game, `Guess` to handle each country a player guesses for a randomly selected continent



The `repositories` package consists of 4 repositories including `CountryRepository`, `CountinentRepository`, `GameRepository`, `PlayerRepository`.

The `services` package has 5 classes, namely `ContinentService`, `CountryService`, `PlayerService`, `GameService` to handle game logic, and `ContinentRandomService` which handle the random selection of a continent.

The `controllers` package consists of 3 classes `PlayerController`, `GameController`, `CountryController` which enables you to perform different requests corresponding to the `CRUD` functionalities
The `DataLoader` in the `components` package is used to pre-populate the `countries`, `continents` and `players` tables in the database.ou may wish to connect to Postico to view the tables in your database.


![Screenshot 2023-04-28 at 08 15 27](https://user-images.githubusercontent.com/56633439/235082783-6bd10530-1522-42fb-9184-200b94d3d109.png)

![final_UML](https://user-images.githubusercontent.com/56633439/235082826-dc91071f-2a12-4d4e-9c38-0fd7fd6ca05e.png)
![final_ERD](https://user-images.githubusercontent.com/56633439/235082828-7d35b44c-125d-4175-82d8-07006240a500.png)


## Installation
* To run the code, you will need:


     Java 17
     Postico (for Mac) or pgAdmin (for Windows) for the PostgreSQL database
     IntelliJ IDEA
     Postman 


* Follow these steps to install and run the code:
    - Clone the repository to your local machine: `git clone https://github.com/StellaA30/continent_game_project.git`.
    - Create a new database in your terminal called `continent_db`.
    - Go to Spring Boot https://start.spring.io/ and create a "spring initialzr" with the mentioned dependencies.
    - Open the file in IntelliJ IDEA. 
    - Update the application.properties file with your database credentials.
    - Run the ContinentGameApplication class to start the server.


## Usage

To play the game, follow these steps:


1. In Postman, send a POST request to http://localhost:8080/players to create a new player. Include the following JSON in the request body:


```
{
  "name": "Your Name"
}
````

The response will include a playerId field that you will use in subsequent requests.


2. Send a POST request to http://localhost:8080/games?playerId=1 to create a new game for the player. Include the playerId in the request body:


The response will include the continent name and a message prompting the player to guess a country in the continent:

```
How many countries can you name in Africa
```

3. To guess a country, send a PUT request to http://localhost:8080/games/1. Include the playerId and your guess in the request body:

````
{
 "countryName": "Nigeria"
}
````

The response will indicate whether your guess was correct or incorrect, and will include the number of correct guesses out of the total number of countries in the continent:

````
Correct! You've guessed 1 out of 46 for Africa.
````
Or

4. Incorrect answer. Have another go. You've guessed 1 out of 54 for Africa.
````

Incorrect answer. Have another go. You've guessed 1 out of 54 for Africa.
````



The response will include your final score:
````
Good job! You got 4 out of 54 correct. 
````
Or

````
Better luck next time! You got 2 out of 54 correct.
````

That's all folks! Have fun playing our game.




## Endpoints

This table lists the API endpoints that the user can interact with, along with their functionality and what information they return.

<table>
  <thead>
    <tr>
      <th>Request</th>
      <th>URL path: localhost:8080 </th>
      <th>Body</th>
      <th>Functionality</th>
      <th>Information Returned</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>POST</td>
      <td>/games?playerId={id}</td>
      <td></td>
      <td>Starts a new game for the specified player. (PlayerId is assigned a value in the Param.)</td>
      <td><code>Reply</code> object containing a <code>currentScore</code>, <code>maxScore</code>, <code>penalty</code>, and a <code>message</code>.</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/games</td>
      <td></td>
      <td>Gets all games.</td>
      <td>List of all <code>Game</code> objects.</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/games/{id}</td>
      <td></td>
      <td>Gets the game with the Id specified.</td>
      <td>The <code>Game</code> object with the specified Id.</td>
    </tr>
    <tr>
      <td>PATCH</td>
      <td>/games/{id}</td>
      <td></td>
      <td>Terminates the game with the Id specified.</td>
      <td><code>Reply</code> object containing a <code>currentScore</code>, <code>maxScore</code>, <code>penalty</code>, and a <code>message</code>.</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td>/games/{id}</td>
      <td> <strong>Object:</strong> Guess <br><br> <strong>JSON:</strong>

```json
{
    "countryName": "[insert guess]"
}
```

</td>
      <td>Submits a guess to the game with the specified Id.</td>
      <td><code>Reply</code> object containing a <code>currentScore</code>, <code>maxScore</code>, <code>penalty</code>, and a<code>message</code>.</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/games/{id}</td>
      <td></td>
      <td>Deletes the game with the specified Id.</td>
      <td>-</td>
    </tr>
    <tr>
      <td>POST</td>
      <td>/players</td>
      <td> <strong>Object:</strong> Player <br><br> <strong>JSON:</strong>

```json
{
    "name": "[insert player name]"
}
```

</td>
      <td>Creates a new player</td>
      <td>The <code>Player</code> object that was created.</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/players</td>
      <td></td>
      <td>Gets all players.</td>
      <td>List of all <code>Player</code> objects.</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/players/{id}</td>
      <td></td>
      <td>Gets the player of the Id specified.</td>
      <td>The <code>Player</code> object with the specified Id.</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/players/{id}</td>
      <td></td>
      <td>Deletes a player.</td>
      <td>-</td>
    </tr>
    <tr>
      <td>POST</td>
      <td>/countries</td>
      <td><strong>Object:</strong> CountryDTO <br><br> <strong>JSON:</strong>

```json
{
    "name": "[insert country name]",
    "gdp": 0,
    "capital": "[insert capital]",
    "population": 0,
    "countryId": 0
}
```

</td>
      <td>Creates a new country.</td>
      <td>The <code>Country</code> object with the specified Id.</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/countries</td>
      <td></td>
      <td>Gets all countries.</td>
      <td>List of all <code>Country</code> objects.</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/countries/{id}</td>
      <td></td>
      <td>Gets the country with the Id specified.</td>
      <td>The <code>Country</code> object with the specified Id.</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td>/countries/{id}</td>
      <td><strong>Object:</strong> CountryDTO <br><br> <strong>JSON:</strong>

```json
{
    "name": "[insert country name]",
    "gdp": 0,
    "capital": "[insert capital]",
    "population": 0,
    "countryId": 0
}
```

</td>
      <td>Updates the country with the specified Id.</td>
      <td>The <code>Country</code> object that was updated.</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/countries/{id}</td>
      <td></td>
      <td>Deletes the country with the specified Id.</td>
      <td>-</td>
    </tr>
  </tbody>
</table>

## Possible contributions/improvements
* GameMode 2 - Player to guess the capital city of a random country belonging to a continent
* GameMode 3 - Player to guess which country has the highest GDP per capita (multiple choice)
* Adding a countdown timer to raise the stakes
* Different countries scored differently
* Alternative answers accepted as correct e.g. USA/United States of America/America

## Credits
### Name: Github Username
>* Umar Twynam: *ufwtwynam*
>* Katie Bamford: *klb545*
>* Stella Annor: *StellaA30*
>* Elizabeth Alabi: *elialabi*
>* Khalid Hussein: *MKADH*

