import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CafeTest {

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
    void displayItems() {
        //assign
        Cafe cafe = new Cafe();

        String expectedResult = "--- Cafe ---\r\n1. Coffee - £4.5\r\n2. Tea - £3.0\r\n3. Sandwich - £4.5\r\n4. Toastie - £5.0\r\n5. Wrap - £4.5\r\n6. Kids Zoo Meal - £4.0\r\n7. Adult Zoo Meal - £6.0\r\n8. Bottle of water - £2.5\r\n9. Juice box - £4.5" + System.lineSeparator();

        //act
        cafe.displayItems();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void buyItem() {
        //assign
        Cafe cafe = new Cafe();
        Visitor visitor = new Visitor(200);

        double expectedResult = 197;
        //act
        cafe.buyItem(1, visitor);

        //assert
        assertEquals(expectedResult, visitor.getBalance());
    }

    @Test
    void buyItemNotEnoughMoney() {
        //assign
        Cafe cafe = new Cafe();
        Visitor visitor = new Visitor(2);

        String expectedResult = "Not enough balance, Transaction Canceled" + System.lineSeparator();
        //act
        cafe.buyItem(1, visitor);

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void buyItemOutOfBounds() {
        //assign
        Cafe cafe = new Cafe();
        Visitor visitor = new Visitor(200);

        String expectedResult = "Invalid Selection" + System.lineSeparator();
        //act
        cafe.buyItem(100, visitor);

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void getItemCount() {
        //assign
        Cafe cafe = new Cafe();

        int expectedResult = 9;
        //act
        int actualResult = cafe.getItemCount();

        //assert
        assertEquals(expectedResult, actualResult);
    }
}