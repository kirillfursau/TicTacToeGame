package model.exception;

public class NotFoundException extends XOException {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
