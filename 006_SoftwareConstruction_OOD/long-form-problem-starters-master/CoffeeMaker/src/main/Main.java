package main;

import exceptions.*;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args) {

        // successful path
        CoffeeMaker c_success = new CoffeeMaker();

        // brew a new batch
        try {
            c_success.brew(2.5, 15);
            c_success.pourCoffee();
            c_success.setTimeSinceLastBrew(10);
            c_success.pourCoffee();
            c_success.setTimeSinceLastBrew(59);
        } catch (Exception e) {
            e.getMessage();
        }

        // unsuccessful path
        CoffeeMaker c_unsuccess = new CoffeeMaker();

        // brew with not enough beans and too little water
        try {
            c_unsuccess.brew(2.1, 10);
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            c_unsuccess.brew(2.4, 19);
            c_unsuccess.pourCoffee();
            c_unsuccess.setTimeSinceLastBrew(61);
            c_unsuccess.pourCoffee();
        } catch (Exception e) {
            e.getMessage();
        }
    }


}