package model;

import exception.NotHungry;

public class Animal {

    private boolean isHungry = false;
    private boolean hungry;
    private int eaten = 0;

    // getters
    public boolean isHungry() { return hungry; }

    public int eat() throws NotHungry {
        if (!isHungry) {
            throw new NotHungry();
        }
        System.out.println("Animal is eating...");
        isHungry = false;
        eaten++;
        return eaten;
    }


}