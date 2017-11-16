package test;

import model.Date;
import model.Entry;
import model.Time;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class EntryTest {
    Entry testEntry;
    Date today = new Date(17, 11, 2017);
    Time t1 = new Time(10, 30);
    Time t2 = new Time(9, 59);
    Time t3 = new Time(22, 29);

    @Test
    public void testsetRepeated() {
        assertFalse(testEntry.isRepeated());
        testEntry.setRepeated();
        assertTrue(testEntry.isRepeated());
    }

    @Test
    public void testsetInterval() {
        testEntry.setRepeated();
        testEntry.setIntervals(1, 10, 0);
        assertEquals(testEntry.getDayInterval(), 1);
    }
}
