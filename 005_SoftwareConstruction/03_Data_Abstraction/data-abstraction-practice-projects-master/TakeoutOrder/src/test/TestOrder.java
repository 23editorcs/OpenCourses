package test;

import model.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestOrder {
    private Order testOrder;

    @Before
    public void setup(){ testOrder = new Order("Quy", 123, Arrays.asList(1,2,3)); }

    @Test
    public void testCalPrice(){
        // default case
        // order 1 combo
        // order 3 combos
    }

    @Test
    public void testFoodType(){
        // default case
        // has value case
    }


}

