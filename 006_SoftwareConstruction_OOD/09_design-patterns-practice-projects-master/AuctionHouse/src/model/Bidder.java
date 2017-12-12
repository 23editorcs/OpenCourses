package model;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Bidder implements Observer {

    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    // Constructor
    public Bidder(String name, double personalBid) {
        this.name = name;
        this.personalBid = personalBid;
        this.maxBid = maxBid;

    }

    // getters
    public String getName() { return name; }
    public double getMaxBid() { return maxBid; }
    public double getPersonalBid() { return personalBid; }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Bidder " + name + " got the current big.");
        if ((double) arg <= maxBid) {
            makeBid((double) arg);
        }
        else {
            System.out.println("Can't bid anymore.");
        }
    }

    private void makeBid(double newBid) {
        Random rd = new Random();
        personalBid = newBid + (double) rd.nextInt(10) + 1.0;
    }
}
