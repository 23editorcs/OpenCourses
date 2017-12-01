package model;

public class Snake extends Animal {

    private double length;
    private boolean venom;

    public Snake(String nm, int age, Zookeeper zk, double wgt, double len, boolean vn) {
        super(age, nm, zk, wgt, "None");
        length = len;
        venom = vn;
    }

    // getters
    public double getLength() { return length; }
    public boolean isVenom() { return venom; }


}