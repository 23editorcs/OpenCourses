package model;

public class Bird implements Flyer {
    @Override
    public void takeOff() {
        System.out.println("Flap flap flap");
    }

    @Override
    public void fly() {
        System.out.println("Glide glide glide");
    }

    @Override
    public void land() {
        System.out.println("Flap hop run run");
    }
}
