package model;

import java.time.LocalDateTime;

public class TrackedGame extends Game {
    private int gameId;
    private LocalDateTime localDateTime;

    public TrackedGame(RegisteredPlayer player1, RegisteredPlayer player2, int gameId, LocalDateTime localDateTime) {
        super(player1, player2);
        setGameId(gameId);
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime.now();
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }


}
