package test;

import model.Whale;
import model.Zookeeper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WhaleTest {

    private Zookeeper zk1;
    private Whale w1;

    @Before
    public void setUp() {
        zk1 = new Zookeeper("Sheldon", 27);
        w1 = new Whale("Bubby", 23, zk1, 500, true);
    }

    @Test
    public void testGetters() {
        assertTrue(w1.isWaterType());
    }
}
