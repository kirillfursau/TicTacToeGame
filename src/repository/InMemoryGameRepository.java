package repository;

import model.TrackedGame;
import service.GameService;

import java.util.List;

public class InMemoryGameRepository implements GameRepository {
    private static List<TrackedGame> games;
    static int countGames;

    public List<TrackedGame> addTrackedGameToList(TrackedGame trackedGame) {
        games.add(trackedGame);
        return games;
    }

    @Override
    public TrackedGame saveGame(TrackedGame trackedGame, GameService gameService) {
        trackedGame.setGameId(countGames);
        countGames++;
        return trackedGame;
    }

    public List<TrackedGame> getTrackedGames() {
        return games;
    }
}
