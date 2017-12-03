package exceptions;

public class StaleCoffeeException extends Exception {
    private double min;

    public StaleCoffeeException(double min) {
        this.min = min;
        System.out.println(min + " minutes is too long for a good coffee!");
    }
}
