package DETsCode.Admin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AdminTest {
    private Admin admin;
    private String wrongRoleidMessage = "RoleID must be 3 for Admin.";

    @Disabled
    @Test
    void givenRoleidNotEqualTo3_whenInsertAdmin_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            admin = new Admin();
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
