package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Auctioneer extends Observable {

    private String name;
    private double currentBid;

    private List<Bidder> bidders;

    // constructor
    public Auctioneer(String name) {
        this.name = name;
        this.currentBid = 0;
        bidders = new ArrayList<>();
    }
    // getters
    public String getName() { return name; }
    public double getCurrentBid() { return this.currentBid; }

    // methods
    public void addObserver(Bidder b) {
        if (!bidders.contains(b)) {
            bidders.add(b);
        }
    }

    // REQUIRES: bid > currentBid
    // MODIFY: this
    // EFFECTS: change currentBid to Bid
    public void acceptBid(double bid) {
        if (bid > currentBid) {
            this.currentBid = bid;
            notifyObservers(this.currentBid);
        }
        else {
            System.out.println("This bid is not big enough!");
        }
    }

    // REQUIRE: current big has changed
    // MODIFY: none
    // EFFECTS: send new currentBid to all observers
    private void notifyObservers(double newBid) {
        for (Bidder o : bidders) {
            o.update(this, newBid);
        }
    }


}
