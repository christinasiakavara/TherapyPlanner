package DETsCode.Patient;

import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PatientTest {
    private Patient patient;
    private String wrongRoleidMessage = "RoleID must be 2 for Patient.";

    @Disabled
    @Test
    void givenRoleidNotEqualTo2_whenInsertPatient_thenReturnErrorMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            patient = new Patient(null, null, null, null, null, null, null, null, 0, 3, null, 0, null);
        });
        String expectedMessage = wrongRoleidMessage;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
