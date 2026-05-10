import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getName() {
        //assign
        Item item = new Item("testItem", 100);

        String expectedResult = "testItem";
        //act
        String actualResult = item.getName();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getPrice() {
        //assign
        Item item = new Item("testItem", 100);

        double expectedResult = 100;
        //act
        double actualResult = item.getPrice();

        //assert
        assertEquals(expectedResult, actualResult);
    }
}