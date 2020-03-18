package repository;

import model.Game;
import model.TrackedGame;
import service.GameService;

import java.sql.*;

public class DatabaseGameRepository implements GameRepository {
    @Override
    public TrackedGame saveGame(TrackedGame trackedGame, GameService gameService) {
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/XO_schema", "root", "rootroot");
            Statement statement = connection.createStatement();
            String winnerName = "Draw";
            if (gameService.getWinner(trackedGame).isPresent()) {
                winnerName = gameService.getWinner(trackedGame).get().getName();
            }
            statement.executeUpdate("REPLACE INTO games SET x_user = '" + trackedGame.getPlayer1().getName()
                    + "',o_user = '" + trackedGame.getPlayer2().getName() + "', id = " + trackedGame.getGameId()
                    + ", time = '" + trackedGame.getLocalDateTime() + "', winner = '" +
                    winnerName + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trackedGame;
    }
}

