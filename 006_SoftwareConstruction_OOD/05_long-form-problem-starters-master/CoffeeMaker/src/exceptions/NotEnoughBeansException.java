package exceptions;

public class NotEnoughBeansException extends BeansAmountException {
    public NotEnoughBeansException(double beans) {
        super(beans, " cups is not enough beans!");
    }
}
