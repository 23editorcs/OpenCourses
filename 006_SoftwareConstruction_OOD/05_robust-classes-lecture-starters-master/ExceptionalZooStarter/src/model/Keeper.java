package model;

import exception.AllergicException;
import exception.DidntEat;
import exception.MessyException;
import exception.NotHungry;

import java.util.List;

public class Keeper {

    List<Animal> animalsToFeed;

    public Keeper(List<Animal> animals) {
        animalsToFeed = animals;
    }

    public void feed() throws DidntEat {
        for (Animal animal : animalsToFeed) {
            int eatenTimes = animal.eat();
            System.out.println("Animal has been fed "+ eatenTimes);
        }

        throw new MessyException();
    }
}