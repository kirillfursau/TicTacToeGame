package model.exception;

public class MoveOutOfBoundsException extends XOException {
    public MoveOutOfBoundsException() {
    }

    public MoveOutOfBoundsException(String message) {
        super(message);
    }
}
