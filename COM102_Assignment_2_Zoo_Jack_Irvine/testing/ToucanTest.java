import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ToucanTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut((originalOut));
    }

    @Test
    void testMakeSound() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "kreekk, kreekk, I am testName a 10 year old Toucan";

        //act
        String actualResult = toucan.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testName";

        //act
        String actualResult = toucan.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testColour";

        //act
        String actualResult = toucan.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        int expectedResult = 10;

        //act
        int actualResult = toucan.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        double expectedResult = 200;

        //act
        double actualResult = toucan.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getBeakLength() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        double expectedResult = 30;

        //act
        double actualResult = toucan.getBeakLength();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult =
                "Animal type: Toucan" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 10"+ "\n" +
                        "Weight: 200.0" + "g\n" +
                        "Beak Length: 30.0" + "\n" + System.lineSeparator();

        //act
        toucan.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "nameTest";

        //act
        toucan.setName("nameTest");
        String actualResult = toucan.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "colourTest";

        //act
        toucan.setColour("colourTest");
        String actualResult = toucan.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        int expectedResult = 6;

        //act
        toucan.setAge(6);
        int actualResult = toucan.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        double expectedResult = 180.0;

        //act
        toucan.setWeight(180.0);
        double actualResult = toucan.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        Toucan toucan = new Toucan("", "testColour", 10, 200, 30 );
        Toucan toucan2 = new Toucan("testName", "", 10, 200, 30 );
        Toucan toucan3 = new Toucan("testName", "testColour", -10, 200, 30 );
        Toucan toucan4 = new Toucan("testName", "testColour", 10, 0, 30 );

        boolean expectedResult = false;

        //act
        boolean actualResult = toucan.isValid();
        boolean result2 = toucan2.isValid();
        boolean result3 = toucan3.isValid();
        boolean result4 = toucan4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setBeakLength() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        double expectedResult = 28;

        //act
        toucan.setBeakLength(28);
        double actualResult = toucan.getBeakLength();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void fly() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testName has took off flying" + System.lineSeparator();

        //act
        toucan.fly();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void land() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testName has landed" + System.lineSeparator();

        //act
        toucan.land();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void chirp() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testName is croaking" + System.lineSeparator();

        //act
        toucan.chirp();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void roost() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testName is roosting" + System.lineSeparator();

        //act
        toucan.roost();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void cleanSelf() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testName is cleaning itself" + System.lineSeparator();

        //act
        toucan.cleanSelf();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void performWingCheck() {
        Toucan toucan = new Toucan("testName", "testColour", 10, 200, 30 );

        String expectedResult = "testName's wings are in good condition" + System.lineSeparator();

        //act
        toucan.performWingCheck();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}