package test;

import model.Elephant;
import model.Horse;
import model.Zookeeper;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ZookeeperTest {

    private Zookeeper zk1;
    private Horse h1;

    @Before
    public void setUp() {
        zk1 = new Zookeeper("Sheldon", 27);
        h1 = new Horse("Legend", "Italy", 23, zk1, 150, 200);
        zk1.setFavourite(h1);
        //zk1.addToList(h1);
    }

    @Test
    public void testGetters() {
        assertEquals(zk1.getName(), "Sheldon");
        assertEquals(zk1.getAge(), 27);
        assertEquals(zk1.getFavourite(), h1);
        assertEquals(zk1.getAnimalList().size(), 1);
    }

    @Test
    public void testAddToList() {
        Elephant e1 = new Elephant("Nemo", "Africa", 90, zk1, 200);
        assertEquals(zk1.getAnimalList().size(), 2);
    }

    @Test
    public void testRemoveToList() {
        zk1.removeToList(h1);
        assertEquals(zk1.getAnimalList().size(), 0);
    }
}
