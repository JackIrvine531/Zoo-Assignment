import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DonationStandTest {

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
        DonationStand dono = new DonationStand();

        String expectedResult = "--- Donation Stand ---\r\n1. £5 Donation - £5.0\r\n2. £10 Donation - £10.0\r\n3. £20 Donation - £20.0\r\n4. £50 Donation - £50.0\r\n5. £100 Donation - £100.0" + System.lineSeparator();

        //act
        dono.displayItems();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void buyItem() {
        //assign
        DonationStand dono = new DonationStand();
        Visitor visitor = new Visitor(200);

        double expectedResult = 190;
        //act
        dono.buyItem(1, visitor);

        //assert
        assertEquals(expectedResult, visitor.getBalance());
    }

    @Test
    void buyItemNotEnoughMoney() {
        //assign
        DonationStand dono = new DonationStand();
        Visitor visitor = new Visitor(2);

        String expectedResult = "Not enough balance, Transaction Canceled" + System.lineSeparator();
        //act
        dono.buyItem(1, visitor);

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void buyItemOutOfBounds() {
        //assign
        DonationStand dono = new DonationStand();
        Visitor visitor = new Visitor(200);

        String expectedResult = "Invalid Selection" + System.lineSeparator();
        //act
        dono.buyItem(100, visitor);

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void getItemCount() {
        DonationStand dono = new DonationStand();

        int expectedResult = 5;
        //act
        int actualResult = dono.getItemCount();

        //assert
        assertEquals(expectedResult, actualResult);
    }
}