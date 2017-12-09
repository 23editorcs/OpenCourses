package test;

import exceptions.*;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CoffeeMakerTest {
    private CoffeeMaker c = new CoffeeMaker();
    private CoffeeMaker testBrew;
    private CoffeeMaker testPour;

    @Before
    public void setUp() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        c = new CoffeeMaker();
        testBrew = new CoffeeMaker();
        testPour = new CoffeeMaker();

        c.brew(2.5, 15);
        testPour.brew(2.5, 15);
    }

    @Test
    public void testGetters(){
        c.setTimeSinceLastBrew(10);
        assertEquals(10, c.getTimeSinceLastBrew());
        assertEquals(15, c.getCupsRemaining());
    }

    @Test (expected = NotEnoughBeansException.class)
    public void testNotEnoughBeansAndGoodWater() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        testBrew.brew(2, 15);
    }

    @Test (expected = TooManyBeansException.class)
    public void testTooManyBeansAndGoodWater() throws NotEnoughBeansException, TooManyBeansException, WaterException {
            testBrew.brew(2.7, 19);
   }

    @Test (expected = WaterException.class)
    public void testGoodBeansAndWaterException() throws NotEnoughBeansException, TooManyBeansException, WaterException {
            testBrew.brew(2.4, 11);
   }

    @Test (expected = StaleCoffeeException.class)
    public void testStaleException() throws NoCupsRemainingException, StaleCoffeeException {
        testPour.setTimeSinceLastBrew(61);
        testPour.pourCoffee();
   }

    @Test
    public void testPour() throws NoCupsRemainingException, StaleCoffeeException {
        testPour.setTimeSinceLastBrew(30);
        assertEquals(15, testPour.getCupsRemaining());
        assertTrue(testPour.areCupsRemaining());
        testPour.pourCoffee();
        assertEquals(14, testPour.getCupsRemaining());
        for (int i = 0; i < 14; i++) {
            testPour.pourCoffee();
        }
        assertEquals(0, testPour.getCupsRemaining());
        assertFalse(testPour.areCupsRemaining());
    }

    @Test (expected = NoCupsRemainingException.class)
    public void testNoCupsRemaining() throws NoCupsRemainingException, StaleCoffeeException {
        testPour.setTimeSinceLastBrew(20);
        for (int i = 0; i < 15; i++) {
            testPour.pourCoffee();
        }
        testPour.pourCoffee();
    }
}
