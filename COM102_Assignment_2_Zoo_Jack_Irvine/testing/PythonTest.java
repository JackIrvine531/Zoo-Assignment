import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PythonTest {

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
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "sssssss, I am testName a 5 year old Python";

        //act
        String actualResult = python.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {

        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testName";

        //act
        String actualResult = python.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testColour";

        //act
        String actualResult = python.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        int expectedResult = 5;

        //act
        int actualResult = python.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        double expectedResult = 10;

        //act
        double actualResult = python.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getTongueFlicksPerMin() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        int expectedResult = 30;

        //act
        int actualResult = python.getTongueFlicksPerMin();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );
        String expectedResult =
                "Animal type: Python" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 5"+ "\n" +
                        "Weight: 10.0" + "kg\n" +
                        "Tongue Flicks Per Minute: 30" + "\n" + System.lineSeparator();

        //act
        python.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "nameTest";

        //act
        python.setName("nameTest");
        String actualResult = python.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "colourTest";

        //act
        python.setColour("colourTest");
        String actualResult = python.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        int expectedResult = 6;

        //act
        python.setAge(6);
        int actualResult = python.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        double expectedResult = 7.0;

        //act
        python.setWeight(7.0);
        double actualResult = python.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        //arrange
        Python python = new Python("", "testColour", 5, 10, 30 );
        Python python2 = new Python("testName", "", 5, 10, 30 );
        Python python3 = new Python("testName", "testColour", 0, 10, 30 );
        Python python4= new Python("testName", "testColour", 5, -10, 30 );

        boolean expectedResult = false;

        //act
        boolean actualResult = python.isValid();
        boolean result2 = python2.isValid();
        boolean result3 = python3.isValid();
        boolean result4 = python4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setTongueFlicksPerMin() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        int expectedResult = 28;

        //act
        python.setTongueFlicksPerMin(28);
        int actualResult = python.getTongueFlicksPerMin();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void slither() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testName is slithering about" + System.lineSeparator();

        //act
        python.slither();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void shedSkin() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testName is shedding its skin" + System.lineSeparator();

        //act
        python.shedSkin();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void bask() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testName is basking in the sun" + System.lineSeparator();

        //act
        python.bask();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void hiss() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testName is hissing" + System.lineSeparator();

        //act
        python.hiss();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void ambush() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testName is laying in ambush for prey" + System.lineSeparator();

        //act
        python.ambush();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void checkSkinConditions() {
        //arrange
        Python python = new Python("testName", "testColour", 5, 10, 30 );

        String expectedResult = "testName's skin is in good condition" + System.lineSeparator();

        //act
        python.checkSkinConditions();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}