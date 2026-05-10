import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GiftShopTest {

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
        GiftShop giftShop = new GiftShop();

        String expectedResult = "--- Gift Shop ---\r\n1. Eagle plush - £20.0\r\n2. Toucan plush - £24.0\r\n3. Owl plush - £20.0\r\n4. Hippo plush - £25.0\r\n5. Shark plush - £30.0\r\n6. Penguin plush - £23.0\r\n7. Crocodile plush - £30.0\r\n8. Python plush - £20.0\r\n9. Caecilian plush - £15.0\r\n10. Zoo mug - £9.99\r\n11. Zoo keyring - £5.0\r\n12. Zoo T-shirt - £25.0\r\n13. Zoo postcard - £2.99\r\n14. Zoo magnet - £4.99" + System.lineSeparator();


        //act
        giftShop.displayItems();

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void buyItem() {
        //assign
        GiftShop giftShop = new GiftShop();
        Visitor visitor = new Visitor(200);

        double expectedResult = 176;
        //act
        giftShop.buyItem(1, visitor);

        //assert
        assertEquals(expectedResult, visitor.getBalance());
    }

    @Test
    void buyItemNotEnoughMoney() {
        //assign
        GiftShop giftShop = new GiftShop();
        Visitor visitor = new Visitor(2);

        String expectedResult = "Not enough balance, Transaction Canceled" + System.lineSeparator();
        //act
        giftShop.buyItem(1, visitor);

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void buyItemOutOfBounds() {
        //assign
        GiftShop giftShop = new GiftShop();
        Visitor visitor = new Visitor(200);

        String expectedResult = "Invalid Selection" + System.lineSeparator();
        //act
        giftShop.buyItem(100, visitor);

        //assert
        assertEquals(expectedResult, outStream.toString());
    }

    @Test
    void getItemCount() {
        GiftShop giftShop = new GiftShop();

        int expectedResult = 14;
        //act
        int actualResult = giftShop.getItemCount();

        //assert
        assertEquals(expectedResult, actualResult);
    }
}