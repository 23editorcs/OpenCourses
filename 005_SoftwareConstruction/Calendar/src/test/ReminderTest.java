package test;

import model.Reminder;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReminderTest extends EntryTest {
    private Reminder testReminder;
    @Before
    public void setup() {
        testEntry = new Reminder(today, t1, "Wake up");
        testReminder = new Reminder(today, t1, "Wake up");
    }

    @Test
    public void testsetNote() {
        testReminder.setNote("Busy day");
        assertEquals(testReminder.getNote(), "Busy day");
    }
}
