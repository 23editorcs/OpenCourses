package test;

import exception.AllergicException;
import exception.DidntEat;
import exception.NotHungry;
import model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AnimalTest {

    @Test
    public void tesHungryAndNotAllergic() {
        Animal a = new Animal(true, false);
        int eatenTimes = 0;

        try {
            eatenTimes = a.eat();
        } catch (NotHungry notHungry) {
            fail("Got not hungry when shouldn't have.");
        } catch (AllergicException e) {
            fail("Got allergic when shouldn't have.");
        }
        assertTrue(eatenTimes == 1);
    }

    @Test
    public void testNotHungryAndNotAllergic() {
        Animal a = new Animal(false, false);
        int eatenTimes = 0;

        try {
            eatenTimes = a.eat();
        } catch (NotHungry notHungry) {

        } catch (AllergicException e) {
            fail("Got allergic when shouldn't have.");
        }
        assertTrue(eatenTimes == 0);
    }

    @Test
    public void testHungryAndAllergic() {
        Animal a = new Animal(true, true);
        int eatenTimes = 0;

        try {
            eatenTimes = a.eat();
        } catch (NotHungry notHungry) {
            fail("Got not hungry when shouldn't have.");
        } catch (AllergicException e) {

        }
        assertTrue(eatenTimes == 0);
    }

    @Test
    public void testNotHungryAndAllergic() {
        Animal a = new Animal(false, true);
        int eatenTimes = 0;

        try {
            eatenTimes = a.eat();
        } catch (NotHungry notHungry) {

        } catch (AllergicException e) {
            fail("Shouldn't go to here.");
        }
        assertTrue(eatenTimes == 0);
    }
}
