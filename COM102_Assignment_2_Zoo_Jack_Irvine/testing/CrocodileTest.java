import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CrocodileTest {

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
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "Hsssss, I am testName a 15 year old Crocodile";

        //act
        String actualResult = croc.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName";

        //act
        String actualResult = croc.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testColour";

        //act
        String actualResult = croc.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        int expectedResult = 15;

        //act
        int actualResult = croc.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        double expectedResult = 1000;

        //act
        double actualResult = croc.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getBiteForce() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        double expectedResult = 1200;

        //act
        double actualResult = croc.getBiteForce();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult =
                "Animal type: Crocodile" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 15"+ "\n" +
                        "Weight: 1000.0" + "kg\n" +
                        "Bite Force: 1200.0" + "\n" + System.lineSeparator();

        //act
        croc.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "nameTest";

        //act
        croc.setName("nameTest");
        String actualResult = croc.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "colourTest";

        //act
        croc.setColour("colourTest");
        String actualResult = croc.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        int expectedResult = 6;

        //act
        croc.setAge(6);
        int actualResult = croc.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        double expectedResult = 98.0;

        //act
        croc.setWeight(98.0);
        double actualResult = croc.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        Crocodile croc = new Crocodile("", "testColour", 15, 1000, 1200 );
        Crocodile croc2 = new Crocodile("testName", "", 15, 1000, 1200 );
        Crocodile croc3 = new Crocodile("testName", "testColour", 0, 1000, 1200 );
        Crocodile croc4 = new Crocodile("testName", "testColour", 15, -34, 1200 );

        boolean expectedResult = false;

        //act
        boolean actualResult = croc.isValid();
        boolean result2 = croc2.isValid();
        boolean result3 = croc3.isValid();
        boolean result4 = croc4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setBiteForce() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        double expectedResult = 1000;

        //act
        croc.setBiteForce(1000);
        double actualResult = croc.getBiteForce();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void slither() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName slithered about" + System.lineSeparator();

        //act
        croc.slither();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void shedSkin() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName started to shed its skin" + System.lineSeparator();

        //act
        croc.shedSkin();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void bask() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName is basking in the sun" + System.lineSeparator();

        //act
        croc.bask();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void checkSkinConditions() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName's skin is in good condition" + System.lineSeparator();

        //act
        croc.checkSkinConditions();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void swim() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName is swimming around" + System.lineSeparator();

        //act
        croc.swim();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void dive() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName has went deeper underwater" + System.lineSeparator();

        //act
        croc.dive();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void rise() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName has rose up in the water a bit" + System.lineSeparator();

        //act
        croc.rise();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void hiss() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName has started to hiss" + System.lineSeparator();

        //act
        croc.hiss();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void ambush() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName is laying in ambush" + System.lineSeparator();

        //act
        croc.ambush();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void hide() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName is hidden from sight" + System.lineSeparator();

        //act
        croc.hide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void unhide() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "testName has returned into view after hiding for a bit" + System.lineSeparator();

        //act
        croc.unhide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void checkWaterConditions() {
        Crocodile croc = new Crocodile("testName", "testColour", 15, 1000, 1200 );

        String expectedResult = "The water in testName's habitat is in good condition" + System.lineSeparator();

        //act
        croc.checkWaterConditions();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}