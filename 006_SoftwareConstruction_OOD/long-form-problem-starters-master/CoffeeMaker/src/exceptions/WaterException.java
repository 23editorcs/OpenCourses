package exceptions;

public class WaterException extends Exception {
    private double water;

    public WaterException(double water) {
        this.water = water;
        System.out.println(water + " cups is not enough water to brew!!!");
    }
}
