package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int time;
    private int cups;

    public CoffeeMaker(){
        this.time = 0;
        this.cups = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return time;

    }
    public int getCupsRemaining() {
        return cups;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return (cups > 0);
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        this.time = time;
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    //          if beans < 2.4, throws a NotEnoughBeansException
    //          if beans > 2.6, throws a TooManyBeansException
    //          if water < 14.75, throws a WaterException
    public void brew(double beans, double water) throws NotEnoughBeansException, TooManyBeansException, WaterException{
        if (beans < 2.4) { throw new NotEnoughBeansException(beans); }
        else if (beans > 2.6) { throw new TooManyBeansException(beans); }
        else if (water < 14.75) { throw new WaterException(water); }
        else {
            this.cups = 15;
            this.time = 0;
        }
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          if cups <= 0, throws a NoCupsRemainingException
    //          if brew >= 60, throws a StaleCoffeeException
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException{
        if (areCupsRemaining() && (time < 60)) {
            cups--;
        } else if (!areCupsRemaining()) { throw new NoCupsRemainingException(); }
        else if (time >= 60) { throw new StaleCoffeeException(time); }
    }
}
