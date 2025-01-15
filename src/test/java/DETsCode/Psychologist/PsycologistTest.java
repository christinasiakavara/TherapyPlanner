package DETsCode.Psychologist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PsychologistTest {
    private Psychologist psychologist;
    private String wrongRoleidMessage = "RoleID must be 1 for Psychologist.";

    @Disabled
    @Test
    void givenRoleidNotEqualTo1_whenInsertPsychologist_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            psychologist = new Psychologist(null, null, null, null, null, null, null, null, 0, 3, 0, null, null);
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
