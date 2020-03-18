package control;

import model.*;
import model.exception.AlreadyOccupiedException;
import model.exception.MoveOutOfBoundsException;
import model.exception.XOException;
import repository.DatabaseGameRepository;
import repository.DatabaseUserRepository;
import service.FieldService;
import service.GameService;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class XOController {
    private GameService gameService;
    private FieldService fieldService;

    public XOController(GameService gameService, FieldService fieldService) {
        setGameService(gameService);
        setFieldService(fieldService);

    }

    public GameService getGameService() {
        return gameService;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public FieldService getFieldService() {
        return fieldService;
    }

    public void setFieldService(FieldService fieldService) {
        this.fieldService = fieldService;
    }


    public void startNonRegisteredGame(String xPlayerName, String yPlayerName) {
        Game game = new QuickGame(new NotRegisteredPlayer(Figure.X, xPlayerName),
                new NotRegisteredPlayer(Figure.O, yPlayerName));
        gameSickle(game);
    }

    public void startRegisteredGame(String xPlayerName, String yPlayerName) {
        Field field = new Field();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter X user name : ");
        xPlayerName = scanner.nextLine();
        User user = new User((int) (Math.random() * 100), xPlayerName);
        System.out.print("Enter O user name : ");
        yPlayerName = scanner.nextLine();
        User user1 = new User((int) (Math.random() * 100), yPlayerName);
        DatabaseUserRepository databaseUserRepository = new DatabaseUserRepository();
        DatabaseGameRepository databaseGameRepository = new DatabaseGameRepository();
        databaseUserRepository.saveUser(user);
        databaseUserRepository.saveUser(user1);
        TrackedGame game = new TrackedGame(new RegisteredPlayer(Figure.X, user),
                new RegisteredPlayer(Figure.O, user1), (int) (Math.random() * 100), LocalDateTime.now());
        gameSickle(game);
        databaseGameRepository.saveGame(game, gameService);
    }

    public void gameSickle(Game game) {
        while (!getGameService().isOver(game, fieldService)) {
            try {
                Scanner scanner = new Scanner(System.in);
                getFieldService().draw(game.getField());
                if (fieldService.getNextFigure(game.getField()) == Figure.O) {
                    System.out.println("Turn O");
                } else {
                    System.out.println("Turn X");
                }
                System.out.print("Enter x : ");
                int x = scanner.nextInt();
                System.out.print("Enter y : ");
                int y = scanner.nextInt();
                getFieldService().makeMove(game.getField(), x, y);
            } catch (AlreadyOccupiedException e) {
                System.out.println("This field is occupied");
            } catch (MoveOutOfBoundsException e) {
                System.out.println("There is no such field");
            } catch (InputMismatchException e) {
                System.out.println("You did't enter a number");
            } catch (XOException e) {
                e.printStackTrace();
            }
        }
        fieldService.draw(game.getField());
        if (gameService.getWinner(game).isPresent()) {
            System.out.println("The winner is " + gameService.getWinner(game).get().getName());
        } else {
            System.out.println("Draw");
        }

    }
}
