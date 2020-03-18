package model;

public abstract class Game {
    public Player player1;
    public Player player2;
    public Field field;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        field = new Field();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Field getField() {
        return field;
    }

}
