package exceptions;

public class BeansAmountException extends Exception {
    private double beans;

    public BeansAmountException(double beans) {
        this.beans = beans;
    }

    protected BeansAmountException(double beans, String msg) {
        System.out.println(beans + msg);
    }

    public double getBeans() { return beans; }
}
