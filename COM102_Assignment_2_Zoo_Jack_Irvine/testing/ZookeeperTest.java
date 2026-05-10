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

        String expectedResult = "\n--- Daily care routine ---\r\nChecking health of Jasper\r\nAnimal type: Eagle\nName: Jasper\nColour: black\nAge: 6\nWeight: 6.0kg\nWingspan: 1.6\n\r\nPerforming wing health check...\r\nJasper's wings are in good condition\r\nJasper is in good health\r\n---------" + System.lineSeparator();

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