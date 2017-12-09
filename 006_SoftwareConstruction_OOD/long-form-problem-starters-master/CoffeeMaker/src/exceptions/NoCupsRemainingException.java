package exceptions;

public class NoCupsRemainingException extends Exception {
    public NoCupsRemainingException() {
        System.out.println("There is no more coffee!");
    }
}
