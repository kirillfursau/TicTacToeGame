package model;

public abstract class Player {
    private Figure figure;

    public Player(Figure figure) {
        setFigure(figure);
    }

    public abstract String getName();

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "The figure is " + figure;
    }
}
