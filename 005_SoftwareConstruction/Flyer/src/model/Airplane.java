package model;

public class Airplane implements Flyer, Cafe {
    @Override
    public void serveDrinks() {
        System.out.println("Serving airplane drinks");
    }

    @Override
    public void serveSnacks() {
        System.out.println("Serving airplane snacks");
    }

    @Override
    public void takeOff() {
        System.out.println("The plane is taking off");
    }

    @Override
    public void fly() {
        System.out.println("It is flying");
    }

    @Override
    public void land() {
        System.out.println("We are here");
    }
}
