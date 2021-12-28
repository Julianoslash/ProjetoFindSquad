package com.findsquad.api.FindSquad_API.repository;

import com.findsquad.api.FindSquad_API.model.GameModel;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameModel, Long> {
}
