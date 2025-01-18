package DETsCode.Admin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AdminTest {
    private Admin admin;
    private String wrongRoleidMessage = "RoleID must be 3 for Admin.";

    @Disabled
    @Test
    void givenRoleidNotEqualTo3_whenInsertAdmin_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            admin = new Admin(null, null, null, null, null, null, null, null, 0, 2, 0, null);
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
