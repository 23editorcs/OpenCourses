package model;

import exception.AllergicException;
import exception.DidntEat;
import exception.NotHungry;

public class Animal {

    private boolean isHungry = true;
    private boolean isAllergic = false;
    private boolean hungry;
    private int eaten = 0;

    public Animal(boolean hungry, boolean allergic) {
        isHungry = hungry;
        isAllergic = allergic;
    }

    // getters
    public boolean isHungry() { return hungry; }

    public int eat() throws NotHungry, AllergicException {
        if (!isHungry) {
            System.out.println("The animal is not hungry.");
            throw new NotHungry();
        }
        if (isAllergic) {
            System.out.println("The animal is allergic!");
            throw new AllergicException();
        }
        System.out.println("Animal is eating...");
        isHungry = false;
        eaten++;
        return eaten;
    }


}