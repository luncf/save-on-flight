package ca.umanitoba.cs.comp3350.saveonflight.objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class AirlineTest {
    private final Airline AIRLINE  = new Airline("Air Canada");
    private Airline airline2;
    private String wrongObject;

    @Before
    public void setUp() {
        airline2 = new Airline("westjet");
        wrongObject = "Air Canada";
    }

    @After
    public void tearDown() {
        airline2 = null;
    }

    @Test
    public void testEqualsMethod(){
        assertFalse(AIRLINE.equals(airline2)); //westjet != air canada
        airline2.setName("Air Canada");
        assertTrue(AIRLINE.equals(airline2)); //air canada = air canada
        airline2.setName("");
        assertFalse(AIRLINE.equals(airline2)); //air canada !=
        assertFalse(AIRLINE.equals(wrongObject)); //air canada != "air canada"
        airline2 = null;
        assertFalse(AIRLINE.equals(airline2)); //air canada != null
    }
}
