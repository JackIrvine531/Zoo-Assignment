import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EagleTest {

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
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "kee-kee-kee, I am testName a 10 year old Eagle";

        //act
        String actualResult = eagle.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testName";

        //act
        String actualResult = eagle.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testColour";

        //act
        String actualResult = eagle.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        int expectedResult = 10;

        //act
        int actualResult = eagle.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        double expectedResult = 23;

        //act
        double actualResult = eagle.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getWingSpan() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        double expectedResult = 1.8;

        //act
        double actualResult = eagle.getWingSpan();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult =
                "Animal type: Eagle" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 10"+ "\n" +
                        "Weight: 23.0" + "kg\n" +
                        "Wingspan: 1.8" + "\n" + System.lineSeparator();

        //act
        eagle.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "nameTest";

        //act
        eagle.setName("nameTest");
        String actualResult = eagle.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "colourTest";

        //act
        eagle.setColour("colourTest");
        String actualResult = eagle.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        int expectedResult = 6;

        //act
        eagle.setAge(6);
        int actualResult = eagle.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        double expectedResult = 12.0;

        //act
        eagle.setWeight(12.0);
        double actualResult = eagle.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        Eagle eagle = new Eagle("", "testColour", 10, 23, 1.8 );
        Eagle eagle2 = new Eagle("testName", "", 10, 23, 1.8 );
        Eagle eagle3 = new Eagle("testName", "testColour", 0, 23, 1.8 );
        Eagle eagle4 = new Eagle("testName", "testColour", 10, -23, 1.8 );

        boolean expectedResult = false;

        //act
        boolean actualResult = eagle.isValid();
        boolean result2 = eagle2.isValid();
        boolean result3 = eagle3.isValid();
        boolean result4 = eagle4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setWingSpan() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        double expectedResult = 2.0;

        //act
        eagle.setWingSpan(2);
        double actualResult = eagle.getWingSpan();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void fly() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testName has took off flying" + System.lineSeparator();

        //act
        eagle.fly();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void land() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testName has landed" + System.lineSeparator();

        //act
        eagle.land();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void chirp() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testName is chirping" + System.lineSeparator();

        //act
        eagle.chirp();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void roost() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testName is roosting" + System.lineSeparator();

        //act
        eagle.roost();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void cleanSelf() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testName is cleaning itself" + System.lineSeparator();

        //act
        eagle.cleanSelf();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void performWingCheck() {
        Eagle eagle = new Eagle("testName", "testColour", 10, 23, 1.8 );

        String expectedResult = "testName's wings are in good condition" + System.lineSeparator();

        //act
        eagle.performWingCheck();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}