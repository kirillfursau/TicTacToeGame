package service;

import model.Figure;
import model.Game;
import model.Player;

import java.util.Optional;

public class GameService {
    public Optional<Player> getWinner(Game game) {
        if (isFindWinner(game, Figure.X) && game.getPlayer1().getFigure() == Figure.X) {
            return Optional.of(game.getPlayer1());
        } else if (isFindWinner(game, Figure.X) && game.getPlayer2().getFigure() == Figure.X) {
            return Optional.of(game.getPlayer2());
        }
        if (isFindWinner(game, Figure.O) && game.getPlayer1().getFigure() == Figure.O) {
            return Optional.of(game.getPlayer1());
        } else if (isFindWinner(game, Figure.O) && game.getPlayer2().getFigure() == Figure.O) {
            return Optional.of(game.getPlayer2());
        }
        return Optional.empty();
    }

    public boolean isFindWinner(Game game, Figure figure) {
        if (checkVerticals(game, figure) || checkHorizontals(game, figure) || checkDiagonals(game, figure)) {
            return true;
        }
        return false;
    }

    public boolean checkVerticals(Game game, Figure figure) {
        for (int p = 0; p < 3; p++) {
            if ((game.getField().getFigure(p, 0) == figure && game.getField().getFigure(p, 1) == figure &&
                    game.getField().getFigure(p, 2) == figure)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHorizontals(Game game, Figure figure) {
        for (int p = 0; p < 3; p++) {
            if ((game.getField().getFigure(0, p) == figure && game.getField().getFigure(1, p) == figure &&
                    game.getField().getFigure(2, p) == figure)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals(Game game, Figure figure) {
        if ((game.getField().getFigure(0, 0) == figure && game.getField().getFigure(1, 1)
                == figure && game.getField().getFigure(2, 2) == figure) ||
                (game.getField().getFigure(2, 0) == figure && game.getField().getFigure(1, 1)
                        == figure && game.getField().getFigure(0, 2) == figure)) {
            return true;
        }
        return false;
    }


    public boolean isOver(Game game, FieldService fieldService) {
        if (!getWinner(game).isPresent() && fieldService.isFull(game.getField()) == false) {
            return false;
        }
        return true;
    }
}
