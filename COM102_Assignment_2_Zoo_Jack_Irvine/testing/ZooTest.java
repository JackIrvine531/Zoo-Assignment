import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ZooTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outStream));
    }
    Zoo testZoo = new Zoo("ZooName");

    @AfterEach
    void restoreSystemOut() {
        System.setOut((originalOut));
    }

    @Test
    void addAnimal() {
        //assign
        Eagle eagle = new Eagle("carrot", "Orange", 7, 20, 1.8);

        //act
        testZoo.addAnimal(eagle);

        //assert
        assertEquals(1, testZoo.getAnimals().size());
    }

    @Test
    void removeAnimal() {
        //assign
        Eagle eagle = new Eagle("carrot", "Orange", 7, 20, 1.8);
        testZoo.addAnimal(eagle);

        //act
        testZoo.removeAnimal("carrot");

        //assert
        assertEquals(0, testZoo.getAnimals().size());
    }

    @Test
    void removeAnimalError() {
        //assign

        String expectedResult = "carrot not found" + System.lineSeparator();
        //act
        testZoo.removeAnimal("carrot");

        //assert
        assertEquals(expectedResult, outStream.toString());

    }

    @Test
    void updateDetails() {
        //assign
        Owl owl = new Owl("testName", "brown", 4, 6.7, 100);
        testZoo.addAnimal(owl);

        //act
        testZoo.updateDetails("testName", "headwig", "white", 4, 7, null, null, 150, null, null, null, null, null, null);
        Animal updated = testZoo.findAnimal("headwig");

        //assert
        assertEquals("headwig", updated.getName());
        assertEquals("white", updated.getColour());
        assertEquals(150.0, ((Owl) updated).getHearingRange());
    }

    @Test
    void findAnimal() {
        //assign
        Shark shark = new Shark("Bruce", "grey", 8, 1500, 300);
        testZoo.addAnimal(shark);

        //act
        Animal found = testZoo.findAnimal("Bruce");

        //assert
        assertEquals("Bruce", found.getName());
    }

    @Test
    void testFindAnimalWhenEmpty() {
        //assign
        //act
        Animal found = testZoo.findAnimal("simba");

        //assert
        assertNull(found);
    }

    @Test
    void zooReport() {
        //assign
        String expectedResult = "\n--- Zoo Report ---\r\nZoo name: ZooName\r\nAnimal: Eagle\r\nCount: 1\r\nDominant colour: black\r\n-----------------------"
                + System.lineSeparator();

        //act
        testZoo.loadAnimalDetails();
        testZoo.zooReport();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void displayAllAnimals() {
        //assign
        Zoo newZoo = new Zoo("ZooName");
        newZoo.addAnimal(new Eagle("carrot", "orange", 7, 23, 2));
        newZoo.addAnimal(new Hippo("jasper", "grey", 7, 1234, true));


        //act
        newZoo.displayAllAnimals();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("carrot"));
        assertTrue(actualResult.contains("jasper"));

        assertTrue(actualResult.contains("orange"));
        assertTrue(actualResult.contains("grey"));

    }

    @Test
    void testEmptyZoo() {
        //assign
        Zoo zoo = new Zoo("test");

        //act
        zoo.displayAllAnimals();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("There are no animals in the Zoo"));
    }

    @Test
    void searchByName() {
        //assign
        Zoo newZoo = new Zoo("testName");


        //act
        newZoo.addAnimal(new Eagle("jack", "white", 23, 12, 2));

        //assert
        assertTrue(outStream.toString().contains("jack"));

    }

    @Test
    void searchByNameError() {
        //assign

        //act
        testZoo.searchByName("purple");
        String actualResult = outStream.toString();
        //assert
        assertTrue(actualResult.contains("No animal found with that name"));
    }

    @Test
    void searchByColour() {
        //assign
        Zoo newZoo = new Zoo("testName");
        newZoo.addAnimal(new Toucan("jack", "blue", 7, 23, 25));

        //act
        newZoo.searchByColour("blue");
        String result = outStream.toString();

        //assert
        assertTrue(result.contains("jack"));
        assertTrue(result.contains("blue"));

    }

    @Test
    void searchByColourError() {
        //assign

        //act
        testZoo.searchByColour("purple");
        String actualResult = outStream.toString();
        //assert
        assertTrue(actualResult.contains("No animals found with that colour"));
    }

    @Test
    void getAnimals() {
        //assign


        //act
        testZoo.addAnimal(new Hippo("jack", "grey", 23, 2361, true));
        testZoo.addAnimal(new Caecilian("beth", "pink", 23, 23, 45));

        //assert
        assertEquals(2, testZoo.getAnimals().size());

    }

    @Test
    void getAnimalsEmpty() {
        //assign
        Zoo testing = new Zoo("test");
        //act

        //assert
        assertTrue(testing.getAnimals().isEmpty());

    }

    @Test
    void getAnimalType() {
        //assign
        //act
        testZoo.addAnimal(new Penguin("donald", "White", 4, 34, 20));
        testZoo.addAnimal(new Shark("Bruce", "White", 8, 1500, 300));

        //assert
        assertEquals(1, testZoo.getAnimalType(Penguin.class).size());
        assertEquals(1, testZoo.getAnimalType(Shark.class).size());

    }

    @Test
    void testSaveAndLoadAnimals() {
        //assign
        Zoo saveTest = new Zoo("test");
        saveTest.addAnimal(new Eagle("steven", "black", 5, 23, 1.5));

        //act
        saveTest.saveAnimalDetails();
        Zoo loadZoo = new Zoo("loaded");
        loadZoo.loadAnimalDetails();

        //assert
        assertEquals(1, loadZoo.getAnimals().size());

        Animal loaded = loadZoo.getAnimals().get(0);
        assertEquals("steven", loaded.getName());
    }

    @Test
    void saveAndLoadZooDetails() {
        //assign
        Zoo originalZoo = new Zoo("London zoo");

        //act
        originalZoo.saveZooDetails();

        Zoo loadedZoo = new Zoo("temp");
        loadedZoo.loadZooDetails();

        //assert
        assertEquals("London zoo", loadedZoo.getZooName());
    }

}