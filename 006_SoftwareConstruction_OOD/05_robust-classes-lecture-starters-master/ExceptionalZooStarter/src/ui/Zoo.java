package ui;

import exception.Broke;
import exception.MessyException;
import model.Animal;
import model.Keeper;
import model.Manager;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            animals.add(new Animal());
//        }
        Keeper keeper = new Keeper(animals);
        Manager manager = new Manager(animals, keeper);
        try {
            manager.manage();
        } catch (Broke broke) {
            System.out.println("Reduce Costs!");
        } catch (MessyException m) {
            System.out.println("No more messy!!!");
        }
        finally {
            System.out.println("...profits");
        }
        System.out.println("And everything goes on...");
    }


}