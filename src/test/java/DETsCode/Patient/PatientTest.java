package DETsCode.Patient;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PatientTest {
    private Patient patient;
    private String wrongRoleidMessage = "RoleID must be 2 for Patient.";

    @Disabled
    @Test
    void givenRoleidNotEqualTo2_whenInsertPatient_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            patient = new Patient();
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
