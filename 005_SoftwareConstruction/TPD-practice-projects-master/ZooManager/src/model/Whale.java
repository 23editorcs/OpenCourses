package model;

public class Whale extends Animal {

    private boolean waterType;

    public Whale(String nm, int age, Zookeeper zk, double wgt, boolean typ) {
        super(age, nm, zk, wgt, "None");
        waterType = typ;
    }

    // getters
    public boolean isWaterType() { return waterType; }


}