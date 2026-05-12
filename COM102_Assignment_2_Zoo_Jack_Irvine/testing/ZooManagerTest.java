import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ZooManagerTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outStream));
    }
    Zoo testZoo = new Zoo("test");

    @AfterEach
    void restoreSystemOut() {
        System.setOut((originalOut));
    }

    @Test
    void testAddAnimal() {
        //assign
        Eagle eagle = new Eagle("jack", "black", 8, 15, 1.8);

        //act
        testZoo.addAnimal(eagle);

        //assert
        assertEquals(1, testZoo.getAnimals().size());
        assertTrue(testZoo.getAnimals().contains(eagle));
    }

    @Test
    void testAddMultipleAnimals() {
        //assign
        Eagle eagle = new Eagle("jack", "black", 8, 15, 1.8);
        Toucan toucan = new Toucan("owen", "orange", 8, 32, 30);
        Owl owl = new Owl("beth", "white", 3, 10, 100);

        //act
        testZoo.addAnimal(eagle);
        testZoo.addAnimal(toucan);
        testZoo.addAnimal(owl);

        //assert
        assertEquals(3, testZoo.getAnimals().size());
    }

    @Test
    void testAnimalDataCorrect() {
        //assign
        Eagle eagle = new Eagle("jack", "black", 8, 15, 1.8);

        //act
        testZoo.addAnimal(eagle);
        Animal animal = testZoo.getAnimals().get(0);

        //assert
        assertEquals("jack", animal.getName());
        assertEquals("black", animal.getColour());
        assertInstanceOf(Eagle.class, animal);
        assertEquals(8, animal.getAge());
        assertEquals(15.0, animal.getWeight());
        assertEquals(1.8, ((Eagle) animal).getWingSpan());
    }

    @Test
    void testUpdateAnimal() {
        //assign
        testZoo.addAnimal(new Python("snape", "black", 23, 8, 20));

        //act
        testZoo.updateDetails("snape", "voldemort", "white", 50, 10,
                null, null, null, null, null,
                null, null, 30, null);

        Animal updated = testZoo.findAnimal("voldemort");
        //assert
        assertNotNull(updated);
        assertEquals("voldemort", updated.getName());
        assertEquals("white", updated.getColour());
        assertEquals(50, updated.getAge());
        assertEquals(10, updated.getWeight());
        assertEquals(30, ((Python) updated).getTongueFlicksPerMin());
    }

    @Test
    void testUpdateAnimalNotFound() {
        //assign

        //act
        testZoo.updateDetails("ghost", "newGhost", "white", 100, 0.1,
                null, null, null,null,null, null,
                null, null, null);
        //assert
        assertNull(testZoo.findAnimal("newGhost"));
    }

    @Test
    void testOldNameRemovedAfterUpdate() {
        //assign
        testZoo.addAnimal(new Shark("Bruce", "grey", 20, 1300, 300));

        //act
        testZoo.updateDetails("Bruce", "Terrance", "white", 2, 800,
                null, null, null, null, 250,
                null, null, null, null);

        //assert
        assertNull(testZoo.findAnimal("Bruce"));
        assertNotNull(testZoo.findAnimal("Terrance"));
    }

    @Test
    void testRemoveAnimal() {
        //assign
        Crocodile croc = new Crocodile("greg", "green", 10, 200, 1000);
        testZoo.addAnimal(croc);

        //act
        testZoo.removeAnimal("greg");

        //assert
        assertEquals(0, testZoo.getAnimals().size());
        assertFalse(testZoo.getAnimals().contains(croc));
    }

    @Test
    void testRemoveOnlySpecificAnimal() {
        //assign
        Crocodile croc = new Crocodile("greg", "green", 10, 200, 1000);
        Penguin pingu = new Penguin("pingu", "white", 5, 50, 20);
        testZoo.addAnimal(croc);
        testZoo.addAnimal(pingu);

        //act
        testZoo.removeAnimal("greg");

        //assert
        assertEquals(1, testZoo.getAnimals().size());
        assertTrue(testZoo.getAnimals().contains(pingu));
    }

    @Test
    void testRemoveAnimalNotFound() {
        //assign
        testZoo.addAnimal(new Caecilian("wormy", "black", 5, 23, 40));

        //act
        testZoo.removeAnimal("ghost");

        //assert
        assertEquals(1, testZoo.getAnimals().size());
    }

    @Test
    void testRemoveFromEmptyZoo() {
        //assign


        //act
        testZoo.removeAnimal("ghost");

        //assert
        assertTrue(testZoo.getAnimals().isEmpty());
    }

    @Test
    void testRemoveIgnoreCase() {
        //assign
        testZoo.addAnimal(new Eagle("Jack", "brown", 10, 23, 2));

        //act
        testZoo.removeAnimal("jack");

        //assert
        assertEquals(0, testZoo.getAnimals().size());
    }

    @Test
    void testSearchByName() {
        //assign
        testZoo.addAnimal(new Owl("george", "brown", 20, 12, 200));

        //act
        testZoo.searchByName("george");

        //assert
        assertTrue(outStream.toString().contains("george"));
        assertTrue(outStream.toString().contains("Hoo"));
    }

    @Test
    void testSearchByNameIgnoreCase() {
        //assign
        testZoo.addAnimal(new Owl("George", "brown", 20, 12, 200));

        //act
        testZoo.searchByName("george");

        //assert
        assertTrue(outStream.toString().contains("George"));

    }

    @Test
    void testSearchByNameNotFound() {
        //assign

        //act
        testZoo.searchByName("ghost");

        //assert
        assertTrue(outStream.toString().contains("No animal found with that name"));
    }

    @Test
    void searchByColour() {
        //assign
        testZoo.addAnimal(new Toucan("jack", "blue", 7, 23, 25));

        //act
        testZoo.searchByColour("blue");
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
    void displayAllAnimals() {
        //assign

        testZoo.addAnimal(new Eagle("carrot", "orange", 7, 23, 2));
        testZoo.addAnimal(new Hippo("jasper", "grey", 7, 1234, true));


        //act
        testZoo.displayAllAnimals();
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

        //act
        testZoo.displayAllAnimals();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("There are no animals in the Zoo"));
    }

    @Test
    void testZooReportCorrectZooName() {
        //assign
        Zoo zoo = new Zoo("testName");

        //act
        zoo.zooReport();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("testName"));

    }

    @Test
    void testZooReportAnimalCount() {
        //assign
        testZoo.addAnimal(new Owl("George", "brown", 20, 12, 200));
        testZoo.addAnimal(new Eagle("carrot", "orange", 7, 23, 2));
        testZoo.addAnimal(new Hippo("jasper", "grey", 7, 1234, true));

        //act
        testZoo.zooReport();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("Total Animals: 3"));
    }

    @Test
    void testZooReportAnimalTypeCount() {
        //assign
        testZoo.addAnimal(new Eagle("George", "brown", 20, 12, 1.8));
        testZoo.addAnimal(new Eagle("carrot", "orange", 7, 23, 2));
        testZoo.addAnimal(new Hippo("jasper", "grey", 7, 1234, true));

        //act
        testZoo.zooReport();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("Eagle"));
        assertTrue(actualResult.contains("2"));

        assertTrue(actualResult.contains("Hippo"));
        assertTrue(actualResult.contains("1"));
    }

    @Test
    void testZooReportDominantColour() {
        //assign
        testZoo.addAnimal(new Eagle("George", "brown", 20, 12, 1.8));
        testZoo.addAnimal(new Eagle("carrot", "brown", 7, 23, 2));
        testZoo.addAnimal(new Eagle("jasper", "Orange", 7, 12, 1));

        //act
        testZoo.zooReport();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("brown"));
    }

    @Test
    void testZooReportEmptyZoo() {
        //assign

        //act
        testZoo.zooReport();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("Total Animals: 0"));
    }

    @Test
    void testZooReportMultipleAnimals() {
        //assign
        testZoo.addAnimal(new Eagle("George", "brown", 20, 12, 1.8));
        testZoo.addAnimal(new Owl("carrot", "orange", 7, 23, 200));
        testZoo.addAnimal(new Hippo("jasper", "grey", 7, 1234, true));

        //act
        testZoo.zooReport();
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("Eagle"));
        assertTrue(actualResult.contains("Owl"));
        assertTrue(actualResult.contains("Hippo"));

    }

    @Test
    void testPreformDailyCareFlyable() {
        //assign
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Eagle("jack", "brown", 3, 12, 1));
        Zookeeper keeper = new Zookeeper("john zookeeper");

        //act
        keeper.preformDailyCare(animals);
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("jack"));
        assertTrue(actualResult.contains("wing"));
    }

    @Test
    void testPreformDailyCareSwimmable() {
        //assign
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Shark("bruce", "grey", 3, 12, 100));
        Zookeeper keeper = new Zookeeper("john zookeeper");

        //act
        keeper.preformDailyCare(animals);
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("bruce"));
        assertTrue(actualResult.contains("water"));
    }

    @Test
    void testPreformDailyCareSlitherable() {
        //assign
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Python("chuck", "brown", 3, 12, 10));
        Zookeeper keeper = new Zookeeper("john zookeeper");

        //act
        keeper.preformDailyCare(animals);
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("chuck"));
        assertTrue(actualResult.contains("skin"));
    }

    @Test
    void testPreformDailyCareMultiAnimal() {
        //assign
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Shark("bruce", "grey", 3, 12, 100));
        animals.add(new Python("chuck", "brown", 3, 12, 10));
        animals.add(new Eagle("jack", "brown", 3, 12, 1));
        Zookeeper keeper = new Zookeeper("john zookeeper");

        //act
        keeper.preformDailyCare(animals);
        String actualResult = outStream.toString();

        //assert
        assertTrue(actualResult.contains("bruce"));
        assertTrue(actualResult.contains("water"));
        assertTrue(actualResult.contains("chuck"));
        assertTrue(actualResult.contains("skin"));
        assertTrue(actualResult.contains("jack"));
        assertTrue(actualResult.contains("wing"));
    }

    @Test
    void testPreformDailyCareEmptyZoo() {
        //assign
        ArrayList<Animal> animals = new ArrayList<>();
        Zookeeper keeper = new Zookeeper("john zookeeper");

        String expectedResult = """
                
                --- Daily care routine ---""" + System.lineSeparator();

        //act
        keeper.preformDailyCare(animals);
        String actualResult = outStream.toString();

        //assert
        assertEquals(expectedResult, actualResult);

    }

}