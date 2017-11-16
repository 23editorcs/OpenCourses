package test;

import model.Event;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EventTest extends EntryTest {
    private Event testEvent;

    @Before
    public void setup() {
        testEntry = new Event(today, t2, "Google IO");
        testEvent = new Event(today, t2, "Fb hackathon");
    }

    @Test
    public void testsetReminder() {
        testEvent.setReminder(today, t2, "Let's go", "Get the laptop");
//        Reminder r = new Reminder(today, t2, "Let's go");
//        r.setNote("Get the laptop");
        assertEquals(testEvent.getReminder().getDate(), today);
        assertEquals(testEvent.getReminder().getTime(), t2);
        assertEquals(testEvent.getReminder().getLabel(), "Let's go");
        assertEquals(testEvent.getReminder().getNote(), "Get the laptop");
//        assertEquals(testEvent.getReminder(), r);
    }

}
