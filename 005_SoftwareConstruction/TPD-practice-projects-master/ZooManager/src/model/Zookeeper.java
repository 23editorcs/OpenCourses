package model;


import java.util.LinkedList;
import java.util.List;

public class Zookeeper {

    private String name;
    private int age;
    private List<Animal> animalList;
    private Animal favourite;

    // TODO: follow the instructions on the webpage to implement this class
    public Zookeeper(String nm, int age) {
        this.name = nm;
        this.age = age;
        animalList = new LinkedList<>();
    }

    // getters
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public List<Animal> getAnimalList() {
        return animalList;
    }
    public Animal getFavourite() {
        return favourite;
    }

    // methods

    // REQUIRES: the favourite is empty
    // MODIFIES: this
    // EFFECTS: set this favourite to the given animal
    public void setFavourite(Animal a) {
        this.favourite = a;
    }

    // REQUIRES: this given animal is not in the list yet
    // MODIFIES: this
    // EFFECTS: add the given animal to the list
    public void addToList(Animal a) {
        animalList.add(a);
    }

    // REQUIRES: the given animal is already in the list
    // MODIFIES: this
    // EFFECTS: remove the given animal out of the list
    public void removeToList(Animal a) {
        animalList.remove(a);
    }
}