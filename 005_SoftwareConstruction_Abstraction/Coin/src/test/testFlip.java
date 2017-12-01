package test;

import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class testFlip {

    Coin c;

    @Before
    public void setup() {
        c = new Coin();
    }

    // Make sure we are not always getting the same response
    @Test
    public void checkSameValue() {
        // stores the present value of a coin
        int present = c.checkStatus();
        // flips it
        c.flip();
        // checks the flipped value to the previous
        int now =  c.checkStatus();
        assertFalse(now == present);
    }
}
