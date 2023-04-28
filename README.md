# Continent game project
## Introduction

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
>* Postman(for the API to mimic the front-end responses)
>* Postico (for the viewing of Game database information)
* Using Spring initializr, the recommended dependencies that were incorporated in the back-end code design were:
>* Spring Web
>* Spring Boot DevTools
>* PostgreSQL Driver
>* Spring Data JPA


## Technology used to create the API:
In this project the following tech were used:
* Spring Boot initializer: `Java`, `version: 3.0.6`, `Mavern`, `Jar Packaging`
* Dependencies: `Spring Boot DevTools`, `PostgreSQL Driver`,`Spring Data JPA`, `Spring Web`
* `Java 17`, `IntelliJ IDEA JDK 17`
*  `PostgreSQL (version 15)`, `Postico` and `Postman` to visualise tables in our database and test different API requests


## Data Structure of project:

![Screenshot 2023-04-28 at 08 15 27](https://user-images.githubusercontent.com/56633439/235082783-6bd10530-1522-42fb-9184-200b94d3d109.png)

![final_UML](https://user-images.githubusercontent.com/56633439/235082826-dc91071f-2a12-4d4e-9c38-0fd7fd6ca05e.png)
![final_ERD](https://user-images.githubusercontent.com/56633439/235082828-7d35b44c-125d-4175-82d8-07006240a500.png)




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

## Credits
### Name: Github Username
>* Umar Twynam: *ufwtwynam*
>* Katie Bamford: *klb545*
>* Stella Annor: *StellaA30*
>* Elizabeth Alabi: *elialabi*
>* Khalid Hussein: *MKADH*

