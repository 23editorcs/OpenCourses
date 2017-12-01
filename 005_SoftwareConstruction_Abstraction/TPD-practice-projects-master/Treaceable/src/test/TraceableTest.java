package test;

import model.Call;
import model.CellPhone;
import model.FingerPrint;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TraceableTest {

    private Person testperson;
    private Person amy;
    private CellPhone testcell;
    private CellPhone outCellPhone;
    private Call testcall;
    private FingerPrint testfinger;

    @Before
    public void setUp() {
        testperson = new Person("Sheldon");
        amy = new Person("Amy");
        testcall = new Call(outCellPhone);
        testcell = new CellPhone("0979757305", testperson);
        outCellPhone = new CellPhone("01689823314", amy);
        testfinger = new FingerPrint(testperson, "house");

        testperson.setCellPhone(testcell);
        testperson.setFingerPrint(testfinger);
        amy.setCellPhone(outCellPhone);
        testcell.call(outCellPhone);
    }

    @Test
    public void testGetters() {
        // person
        assertEquals("Amy", amy.getName());
        assertEquals(testcell, testperson.getCellPhone());
        assertEquals(testfinger, testperson.getFingerPrint());

        // cellphone
        assertEquals("0979757305", testcell.getNumber());
        assertEquals(testperson, testcell.getPerson());
        assertEquals(1, testcell.getListOfCall().size());

        // call
        assertEquals(outCellPhone, testcall.getOutgoing());

        // fingerprint
        assertEquals(testperson, testfinger.getPerson());
    }

}
