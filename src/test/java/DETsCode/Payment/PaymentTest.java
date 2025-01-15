package DETsCode.Payment;

import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PaymentTest {
    private Payment payment;
    private String negativeAmountMessage = "Amount cannot be less than 0.";

    @Disabled
    @Test
    void givenAmountLessThan0_whenInsertPayment_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            payment = new Payment(0, -1, null, 0, 0);
        });
        String expectedMessage = negativeAmountMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Disabled
    @Test
    void givenAmountLessThan0_whenUpdatePayment_thenReturnErrorMessage() {
        payment = new Payment(0, 0, null, 0, 0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            payment.setAmmount(-1);
        });
        String expectedMessage = negativeAmountMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
