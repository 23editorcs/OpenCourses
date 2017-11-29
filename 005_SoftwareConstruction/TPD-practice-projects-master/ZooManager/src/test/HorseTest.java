package test;

import model.Horse;
import model.Zookeeper;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HorseTest {

    private Zookeeper z1;
    private Horse h1;

    @Before
    public void setUp() {
        z1 = new Zookeeper("Sheldon", 27);
        h1 = new Horse("Legend", "Italy", 18, z1, 100, 190);
    }

    @Test
    public void testGetters() {
        assertEquals(h1.getTopSpeed(), 190.0);
    }
}
