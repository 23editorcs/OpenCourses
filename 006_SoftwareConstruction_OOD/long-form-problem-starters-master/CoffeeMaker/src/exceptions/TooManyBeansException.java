package exceptions;

public class TooManyBeansException extends BeansAmountException {
    public TooManyBeansException(double beans) {
        super(beans, " cups is too many beans");
    }

}
