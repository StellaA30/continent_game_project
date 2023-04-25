package com.example.continent_game.repositories;

import com.example.continent_game.models.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Long> {

}
