import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

    @Test
    void getBalance() {
        //assign
        Visitor visitor = new Visitor(200);
        double expectedResult = 200;

        //act
        double actualResult = visitor.getBalance();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deposit() {
        //assign
        Visitor visitor = new Visitor(200);
        double expectedResult = 250;

        //act
        visitor.deposit(50);

        //assert
        assertEquals(expectedResult, visitor.getBalance());
    }

    @Test
    void withdraw() {
        //assign
        Visitor visitor = new Visitor(200);
        boolean expectedResult = true;

        //act
        //assert
        assertEquals(expectedResult, visitor.withdraw(50));
    }

    @Test
    void withdrawNotEnoughMoney() {
        //assign
        Visitor visitor = new Visitor(200);
        boolean expectedResult = false;

        //act
        //assert
        assertEquals(expectedResult, visitor.withdraw(2000));
    }
}