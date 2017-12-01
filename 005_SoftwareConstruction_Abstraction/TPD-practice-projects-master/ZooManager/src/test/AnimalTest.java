package test;

import model.Animal;
import model.Zookeeper;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AnimalTest {
    private Animal a1;
    private Zookeeper zk1;

    @Before
    public void setUp() {
        zk1 = new Zookeeper("Sheldon", 27);
        a1 = new Animal(10, "Joey", zk1, 50, "Africa");
    }

    @Test
    public void testGetters() {
        assertEquals(a1.getAge(), 10);
        assertEquals(a1.getName(), "Joey");
        assertEquals(a1.getCountry(), "Africa");
        assertEquals(a1.getWeight(), 50.0);
        assertEquals(a1.getCareTaker(), zk1);
    }

}
