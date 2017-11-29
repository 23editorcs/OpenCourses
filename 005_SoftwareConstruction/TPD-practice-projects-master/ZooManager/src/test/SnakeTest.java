package test;

import model.Snake;
import model.Zookeeper;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class SnakeTest {

    private Zookeeper zk1;
    private Snake s1;

    @Before
    public void setUp() {
        zk1 = new Zookeeper("Sheldon", 27);
        s1 = new Snake("Python", 9, zk1, 18, 20, false);
    }

    @Test
    public void testGetters() {
        assertFalse(s1.isVenom());
        assertEquals(s1.getLength(), 20.0);
    }
}
