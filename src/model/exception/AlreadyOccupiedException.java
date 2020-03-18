package model.exception;

public class AlreadyOccupiedException extends XOException{
    public AlreadyOccupiedException() {
    }

    public AlreadyOccupiedException(String message) {
        super(message);
    }
}
