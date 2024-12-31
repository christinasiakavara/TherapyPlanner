package DETsCode.User;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserTest {
    private User user;

    @BeforeEach
    void init() {
        user = new User(null, null, null, null, null, null, null, null, 0, 0);
    }

    @Test
    void testSetRoleIdException() {
        String expectedErrorMessage = "RoleID must be 1 for Psychologist or 2 for Patient or 3 for Admin.";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setRoleID(4);
        });
        //assertTrue(exception.getMessage().equals(expectedErrorMessage));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @Test
    void testGetRoleName() {
        user.setRoleID(1);
        assertEquals("Psychologist", user.getRoleName());
        user.setRoleID(2);
        assertEquals("Patient", user.getRoleName());
        user.setRoleID(3);
        assertEquals("Admin", user.getRoleName()); 
    }

    @Test
    void testGetRoleNameException() {
        User user = new User(null, null, null, null, null, null, null, null, 0, 4);
        String expectedErrorMessage = "Invalid roleID: " + user.getRoleID();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            user.getRoleName();
        });
        assertEquals(expectedErrorMessage, exception.getMessage());  
    }
}
