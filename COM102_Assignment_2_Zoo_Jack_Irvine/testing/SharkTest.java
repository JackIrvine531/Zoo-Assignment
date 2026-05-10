import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SharkTest {

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
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "blub, blub, I am testName a 9 year old Shark";

        //act
        String actualResult = shark.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "testName";

        //act
        String actualResult = shark.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "testColour";

        //act
        String actualResult = shark.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        int expectedResult = 9;

        //act
        int actualResult = shark.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        double expectedResult = 1250;

        //act
        double actualResult = shark.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getNumTeeth() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        int expectedResult = 300;

        //act
        int actualResult = shark.getNumTeeth();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult =
                "Animal type: Shark" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 9"+ "\n" +
                        "Weight: 1250.0" + "kg\n" +
                        "Number of Teeth: 300" + "\n" + System.lineSeparator();

        //act
        shark.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "nameTest";

        //act
        shark.setName("nameTest");
        String actualResult = shark.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "colourTest";

        //act
        shark.setColour("colourTest");
        String actualResult = shark.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        int expectedResult = 6;

        //act
        shark.setAge(6);
        int actualResult = shark.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        double expectedResult = 800.0;

        //act
        shark.setWeight(800.0);
        double actualResult = shark.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        Shark shark = new Shark("", "testColour", 9, 1250, 300 );
        Shark shark2 = new Shark("testName", "", 9, 1250, 300 );
        Shark shark3 = new Shark("testName", "testColour", -9, 1250, 300 );
        Shark shark4 = new Shark("testName", "testColour", 9, 0, 300 );

        boolean expectedResult = false;

        //act
        boolean actualResult = shark.isValid();
        boolean result2 = shark2.isValid();
        boolean result3 = shark3.isValid();
        boolean result4 = shark4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setNumTeeth() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        int expectedResult = 400;

        //act
        shark.setNumTeeth(400);
        int actualResult = shark.getNumTeeth();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void swim() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "testName is swimming about" + System.lineSeparator();

        //act
        shark.swim();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void dive() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "testName has dived deeper" + System.lineSeparator();

        //act
        shark.dive();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void rise() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "testName has risen in the water" + System.lineSeparator();

        //act
        shark.rise();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void hide() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "testName has hidden from view" + System.lineSeparator();

        //act
        shark.hide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void unhide() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "testName has returned into view after hiding" + System.lineSeparator();

        //act
        shark.unhide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void checkWaterConditions() {
        Shark shark = new Shark("testName", "testColour", 9, 1250, 300 );

        String expectedResult = "The water in testName's habitat is in good condition" + System.lineSeparator();

        //act
        shark.checkWaterConditions();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}