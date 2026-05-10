import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PenguinTest {

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
        //arrange
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "gak, gak, I am testName a 9 year old Penguin";

        //act
        String actualResult = penguin.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "testName";

        //act
        String actualResult = penguin.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "testColour";

        //act
        String actualResult = penguin.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        int expectedResult = 9;

        //act
        int actualResult = penguin.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        double expectedResult = 60;

        //act
        double actualResult = penguin.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getSwimSpeed() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        int expectedResult = 20;

        //act
        int actualResult = penguin.getSwimSpeed();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult =
                "Animal type: Penguin" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 9"+ "\n" +
                        "Weight: 60.0" + "kg\n" +
                        "Swim Speed: 20" + "\n" + System.lineSeparator();

        //act
        penguin.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "nameTest";

        //act
        penguin.setName("nameTest");
        String actualResult = penguin.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "colourTest";

        //act
        penguin.setColour("colourTest");
        String actualResult = penguin.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        int expectedResult = 6;

        //act
        penguin.setAge(6);
        int actualResult = penguin.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        double expectedResult = 35.0;

        //act
        penguin.setWeight(35.0);
        double actualResult = penguin.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        Penguin penguin = new Penguin("", "testColour", 9, 60, 20 );
        Penguin penguin2 = new Penguin("testName", "", 9, 60, 20 );
        Penguin penguin3 = new Penguin("testName", "testColour", 0, 60, 20 );
        Penguin penguin4 = new Penguin("testName", "testColour", 9, -60, 20 );

        boolean expectedResult = false;

        //act
        boolean actualResult = penguin.isValid();
        boolean result2 = penguin2.isValid();
        boolean result3 = penguin3.isValid();
        boolean result4 = penguin4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setSwimSpeed() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        double expectedResult = 15;

        //act
        penguin.setSwimSpeed(15);
        double actualResult = penguin.getSwimSpeed();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void swim() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "testName has gone for a swim" + System.lineSeparator();

        //act
        penguin.swim();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void dive() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "testName has dove deeper in the water" + System.lineSeparator();

        //act
        penguin.dive();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void rise() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "testName has risen in the water a bit" + System.lineSeparator();

        //act
        penguin.rise();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void hide() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "testName has hidden from view" + System.lineSeparator();

        //act
        penguin.hide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void unhide() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "testName has returned to view after hiding" + System.lineSeparator();

        //act
        penguin.unhide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void checkWaterConditions() {
        Penguin penguin = new Penguin("testName", "testColour", 9, 60, 20 );

        String expectedResult = "The water in testName's habitat is in good condition" + System.lineSeparator();

        //act
        penguin.checkWaterConditions();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}