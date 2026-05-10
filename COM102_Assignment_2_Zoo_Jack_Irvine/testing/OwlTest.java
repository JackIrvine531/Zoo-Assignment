import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OwlTest {

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
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "Hoo, Hoo, I am testName a 10 year old Owl";

        //act
        String actualResult = owl.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testName";

        //act
        String actualResult = owl.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testColour";

        //act
        String actualResult = owl.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        int expectedResult = 10;

        //act
        int actualResult = owl.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        double expectedResult = 23;

        //act
        double actualResult = owl.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getHearingRange() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        int expectedResult = 200;

        //act
        int actualResult = owl.getHearingRange();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult =
                "Animal type: Owl" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 10"+ "\n" +
                        "Weight: 23.0" + "kg\n" +
                        "Hearing Range: 200" + "\n" + System.lineSeparator();

        //act
        owl.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "nameTest";

        //act
        owl.setName("nameTest");
        String actualResult = owl.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "colourTest";

        //act
        owl.setColour("colourTest");
        String actualResult = owl.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        int expectedResult = 6;

        //act
        owl.setAge(6);
        int actualResult = owl.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        double expectedResult = 12.0;

        //act
        owl.setWeight(12.0);
        double actualResult = owl.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        Owl owl = new Owl("", "testColour", 10, 23, 200 );
        Owl owl2 = new Owl("testName", "", 10, 23, 200 );
        Owl owl3 = new Owl("testName", "testColour", 0, 23, 200 );
        Owl owl4 = new Owl("testName", "testColour", 10, -23, 200 );

        boolean expectedResult = false;

        //act
        boolean actualResult = owl.isValid();
        boolean result2 = owl2.isValid();
        boolean result3 = owl3.isValid();
        boolean result4 = owl4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setHearingRange() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        int expectedResult = 120;

        //act
        owl.setHearingRange(120);
        int actualResult = owl.getHearingRange();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void fly() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testName has took off flying" + System.lineSeparator();

        //act
        owl.fly();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void land() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testName has landed" + System.lineSeparator();

        //act
        owl.land();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void chirp() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testName is hooting" + System.lineSeparator();

        //act
        owl.chirp();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void roost() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testName is roosting" + System.lineSeparator();

        //act
        owl.roost();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void cleanSelf() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testName is cleaning its feathers" + System.lineSeparator();

        //act
        owl.cleanSelf();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void performWingCheck() {
        Owl owl = new Owl("testName", "testColour", 10, 23, 200 );

        String expectedResult = "testName's wings are in good condition" + System.lineSeparator();

        //act
        owl.performWingCheck();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}