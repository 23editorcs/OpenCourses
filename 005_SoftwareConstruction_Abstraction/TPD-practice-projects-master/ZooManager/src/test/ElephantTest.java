package test;

import model.Elephant;
import model.Zookeeper;
import org.junit.Before;
import org.junit.Test;

public class ElephantTest {

    private Elephant e1;
    private Zookeeper z1;

    @Before
    public void setUp() {
        z1 = new Zookeeper("Sheldon", 27);
        e1 = new Elephant("Jolly", "Brazil", 150, z1, 200);
    }
}
