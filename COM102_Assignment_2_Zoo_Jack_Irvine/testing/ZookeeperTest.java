import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ZookeeperTest {

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
    void preformDailyCare() {
        //assign
        Zoo testZoo = new Zoo("testZooName");
        Zookeeper keeper = new Zookeeper("testName");
        testZoo.loadZooDetails();
        testZoo.loadAnimalDetails();

        String expectedResult = "\n--- Daily care routine ---\r\nChecking health of Stephen\r\nAnimal type: Eagle\nName: Stephen\nColour: Gold\nAge: 8\nWeight: 14.0kg\nWingspan: 2.0\n\r\nPerforming wing health check...\r\nStephen's wings are in good condition\r\nStephen is in good health\r\n---------" + System.lineSeparator();

        //act
        keeper.preformDailyCare(testZoo.getAnimals());

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void getName() {
        //assign
        Zookeeper keeper = new Zookeeper("testName");

        String expectedResult = "testName";
        //act
        String actualResult = keeper.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }
}