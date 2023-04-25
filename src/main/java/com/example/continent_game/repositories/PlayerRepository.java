package com.example.continent_game.repositories;

import com.example.continent_game.models.Player;
import com.example.continent_game.services.PlayerService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
