package model;

public class Animal {
    protected String name;
    protected String country;
    protected int age;
    protected Zookeeper careTaker;
    protected double weight;

    public Animal(int age, String nm, Zookeeper zk, double wgt, String ct) {
        this.age = age;
        name = nm;
        careTaker = zk;
        weight = wgt;
        country = ct;
        zk.addToList(this);
    }

    // getters
    public String getName() { return name; }

    public String getCountry() { return country; }

    public int getAge() { return age; }

    public Zookeeper getCareTaker() { return careTaker; }

    public double getWeight() { return weight; }
}
