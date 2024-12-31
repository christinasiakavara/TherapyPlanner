package DETsCode.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserTest {
    private User user;
    private String wrongRoleidMessage = "RoleID must be 1 for Psychologist or 2 for Patient or 3 for Admin.";

    @BeforeEach
    void init() {
        user = new User(null, null, null, null, null, null, null, null, 1, 1);
    }

    @Disabled
    @Test
    void givenRoleidLessThan1_whenInsertUser_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user = new User(null, null, null, null, null, null, null, null, 0, 1);
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Disabled
    @Test
    void givenRoleidGreaterThan3_whenInsertUser_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user = new User(null, null, null, null, null, null, null, null, 4, 1);
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void givenRoleidLessThan1_whenUpdateRoleid_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setRoleID(0);
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void givenRoleidGreaterThan3_whenUpdateRoleid_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setRoleID(4);
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void whenRoleIdEqualsTo1_expectRoleNamePsychologist() {
        user.setRoleID(1);
        assertEquals("Psychologist", user.getRoleName());
    }

    @Test
    void whenRoleIdEqualsTo2_expectRoleNamePatient() {
        user.setRoleID(2);
        assertEquals("Patient", user.getRoleName());
    }

    @Test
    void whenRoleIdEqualsTo3_expectRoleNameAdmin() {
        user.setRoleID(3);
        assertEquals("Admin", user.getRoleName()); 
    }

    @Test
    void whenRoleIdGreaterThan3_expectRoleNameErrorMessage() {
        User user = new User(null, null, null, null, null, null, null, null, 0, 4);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            user.getRoleName();
        });
        String expectedMessage = "Invalid roleID: " + user.getRoleID();
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);  
    }

    @Test
    void whenRoleIdLessThan1_expectRoleNameErrorMessage() {
        User user = new User(null, null, null, null, null, null, null, null, 0, 0);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            user.getRoleName();
        });
        String expectedMessage = "Invalid roleID: " + user.getRoleID();
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);  
    }
}
