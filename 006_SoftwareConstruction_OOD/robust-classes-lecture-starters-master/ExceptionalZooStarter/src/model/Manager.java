package model;

import exception.AllergicException;
import exception.Broke;
import exception.DidntEat;
import exception.NotHungry;

import java.util.List;

public class Manager {

    private final List<Animal> animalsToManage;
    private final Keeper keeper;

    public Manager(List<Animal> animals, Keeper keeper) {
        this.animalsToManage = animals;
        this.keeper = keeper;
    }

    public void manage() throws Broke {
        try {
            keeper.feed();
        } catch (DidntEat e) {
            System.out.println("Get the doctor!");
            throw new Broke();
        } finally {
            System.out.println("Managing zoo...");
        }
    }


}