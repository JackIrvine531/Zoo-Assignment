import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HippoTest {

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
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "honk,honk,honk,honk,honk, I am testName a 10 year old Hippo";

        //act
        String actualResult = hippo.makeSound();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetName() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "testName";

        //act
        String actualResult = hippo.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetColour() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "testColour";

        //act
        String actualResult = hippo.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetAge() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        int expectedResult = 10;

        //act
        int actualResult = hippo.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetWeight() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        double expectedResult = 2300;

        //act
        double actualResult = hippo.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getHungryHippo() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        boolean expectedResult = true;

        //act
        boolean actualResult = hippo.getHungryHippo();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testDisplayDetails() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult =
                "Animal type: Hippo" + "\n" +
                        "Name: testName"+ "\n" +
                        "Colour: testColour" + "\n" +
                        "Age: 10"+ "\n" +
                        "Weight: 2300.0" + "kg\n" +
                        "Is it a Hungry Hungry Hippo: true" + "\n" + System.lineSeparator();

        //act
        hippo.displayDetails();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void testSetName() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "nameTest";

        //act
        hippo.setName("nameTest");
        String actualResult = hippo.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetColour() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "colourTest";

        //act
        hippo.setColour("colourTest");
        String actualResult = hippo.getColour();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetAge() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        int expectedResult = 6;

        //act
        hippo.setAge(6);
        int actualResult = hippo.getAge();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSetWeight() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        double expectedResult = 1500.0;

        //act
        hippo.setWeight(1500.0);
        double actualResult = hippo.getWeight();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testIsValid() {
        Hippo hippo = new Hippo("", "testColour", 10, 2300, true );
        Hippo hippo2 = new Hippo("testName", "", 10, 2300, true );
        Hippo hippo3 = new Hippo("testName", "testColour", -10, 2300, true );
        Hippo hippo4 = new Hippo("testName", "testColour", 10, 0, true );

        boolean expectedResult = false;

        //act
        boolean actualResult = hippo.isValid();
        boolean result2 = hippo2.isValid();
        boolean result3 = hippo3.isValid();
        boolean result4 = hippo4.isValid();

        //assert
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, result2);
        assertEquals(expectedResult, result3);
        assertEquals(expectedResult, result4);
    }

    @Test
    void setHungryHippo() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        boolean expectedResult = false;

        //act
        hippo.setHungryHippo(false);
        boolean actualResult = hippo.getHungryHippo();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void swim() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "testName swims about for a bit" + System.lineSeparator();

        //act
        hippo.swim();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void dive() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "testName has dived a bit deeper under the water" + System.lineSeparator();

        //act
        hippo.dive();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void rise() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "testName has risen in the water a bit" + System.lineSeparator();

        //act
        hippo.rise();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void hide() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "testName has hidden from view" + System.lineSeparator();

        //act
        hippo.hide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void unhide() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "testName has returned into view after hiding a bit" + System.lineSeparator();

        //act
        hippo.unhide();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void checkWaterConditions() {
        Hippo hippo = new Hippo("testName", "testColour", 10, 2300, true );

        String expectedResult = "The water in testName's habitat is in good condition" + System.lineSeparator();

        //act
        hippo.checkWaterConditions();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }
}