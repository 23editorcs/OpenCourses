package tests;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TranscriptTest {
    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        //TODO: write new values in testTranscript constructor
        testTranscript.addGrade("CS101", 4.0);
    }

    @Test
    public void testTemplate(){
        //TODO: write tests for Transcript methods

        // test addGrade method
        assertEquals(testTranscript.getCourseAndGrade("CS101"), "CS101: 4.0");

        // test getGPA
        //assertEquals(testTranscript.getGPA(), 4.0);
    }
    @Test
    public void testGetGPA() {
        assertTrue(testTranscript.getGPA()==4.0);
    }

}
