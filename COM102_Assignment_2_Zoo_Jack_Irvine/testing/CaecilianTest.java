import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CaecilianTest {

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
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "click, click, I am testName a 5 year old Caecilian";

        //act
        String actualResult = caecilian.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {

        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testName";

        //act
        String actualResult = caecilian.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testColour";

        //act
        String actualResult = caecilian.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        int expectedResult = 5;

        //act
        int actualResult = caecilian.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        double expectedResult = 100;

        //act
        double actualResult = caecilian.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getBurrowDepth() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        double expectedResult = 30;

        //act
        double actualResult = caecilian.getBurrowDepth();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult =
                "Animal type: Caecilian" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 5"+ "\n" +
                        "Weight: 100.0" + "g\n" +
                        "Burrow Depth: 30" + "\n" + System.lineSeparator();

        //act
        caecilian.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "nameTest";

        //act
        caecilian.setName("nameTest");
        String actualResult = caecilian.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "colourTest";

        //act
        caecilian.setColour("colourTest");
        String actualResult = caecilian.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        int expectedResult = 6;

        //act
        caecilian.setAge(6);
        int actualResult = caecilian.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        double expectedResult = 98.0;

        //act
        caecilian.setWeight(98.0);
        double actualResult = caecilian.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        //arrange
        Caecilian caecilian = new Caecilian("", "testColour", 5, 100, 30 );
        Caecilian caecilian2 = new Caecilian("testName", "", 5, 100, 30 );
        Caecilian caecilian3 = new Caecilian("testName", "testColour", -5, 100, 30 );
        Caecilian caecilian4 = new Caecilian("testName", "testColour", 5, 0, 30 );

        boolean expectedResult = false;

        //act
        boolean actualResult = caecilian.isValid();
        boolean result2 = caecilian2.isValid();
        boolean result3 = caecilian3.isValid();
        boolean result4 = caecilian4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setBurrowDepth() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        int expectedResult = 28;

        //act
        caecilian.setBurrowDepth(28);
        int actualResult = caecilian.getBurrowDepth();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void slither() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testName is slithering about" + System.lineSeparator();

        //act
        caecilian.slither();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void shedSkin() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testName is shedding its skin" + System.lineSeparator();

        //act
        caecilian.shedSkin();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void bask() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testName is basking in the sun" + System.lineSeparator();

        //act
        caecilian.bask();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void hiss() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testName is hissing" + System.lineSeparator();

        //act
        caecilian.hiss();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void ambush() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testName is setting an ambush for prey" + System.lineSeparator();

        //act
        caecilian.ambush();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void checkSkinConditions() {
        //arrange
        Caecilian caecilian = new Caecilian("testName", "testColour", 5, 100, 30 );

        String expectedResult = "testName's skin is in good condition" + System.lineSeparator();

        //act
        caecilian.checkSkinConditions();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}