package com.example.continent_game.repositories;

import com.example.continent_game.models.Country;
import com.example.continent_game.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
