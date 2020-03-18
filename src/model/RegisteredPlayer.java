package model;

public class RegisteredPlayer extends Player {
    private User user;

    public RegisteredPlayer(Figure figure, User user) {
        super(figure);
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getName();
    }
}
