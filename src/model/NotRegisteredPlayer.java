package model;

public class NotRegisteredPlayer extends Player {
    private String name;

    public NotRegisteredPlayer(Figure figure, String name) {
        super(figure);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
