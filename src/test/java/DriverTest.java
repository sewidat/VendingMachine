import org.example.mechanics.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTest {
    Validator validator;

    @Test
    void setUp() {
        validator = new Validator();
        assertEquals(true, validator.attempt(10));
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {

    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
    }
}
