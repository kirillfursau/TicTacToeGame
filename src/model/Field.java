package model;

public class Field {
    private Figure[][] figures= new Figure[3][3];

    public Figure getFigure(int x, int y) {
        return figures[x][y];
    }

    public void setFigure(int x, int y, Figure figureEnter) {
        figures[x][y] = figureEnter;
    }

    public Figure[][] getFigures() {
        return figures;
    }
}
