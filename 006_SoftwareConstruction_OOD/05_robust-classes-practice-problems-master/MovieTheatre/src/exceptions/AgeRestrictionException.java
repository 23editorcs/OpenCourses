package exceptions;

public class AgeRestrictionException extends Exception {
    public AgeRestrictionException() {
        super();
    }
    public AgeRestrictionException(String msg) {
        super(msg);
    }
}
