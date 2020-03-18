import control.XOController;
import service.FieldService;
import service.GameService;

public class Main {
    public static void main(String[] args) {
        XOController xoController = new XOController(new GameService(), new FieldService());
        xoController.startRegisteredGame("Kiryl", "Dima");
//        xoController.startNonRegisteredGame("Kiryl","Dima");
    }
}
