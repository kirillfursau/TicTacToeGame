package repository;

import model.Game;
import model.TrackedGame;
import service.GameService;

public interface GameRepository {
    TrackedGame saveGame(TrackedGame trackedGame, GameService gameService);
}
