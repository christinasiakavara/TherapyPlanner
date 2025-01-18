package DETsCode.Psychologist;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PsychologistTest {
    private Psychologist psychologist;
    private String wrongRoleidMessage = "RoleID must be 1 for Psychologist.";

    @Disabled
    @Test
    void givenRoleidNotEqualTo1_whenInsertPsychologist_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            psychologist = new Psychologist();
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
