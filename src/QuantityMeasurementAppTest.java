import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // -------- FEET TESTS --------

    @Test
    void givenSameFeet_shouldReturnTrue() {
        var a = new QuantityMeasurementApp.Feet(1.0);
        var b = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(a.equals(b));
    }

    @Test
    void givenDifferentFeet_shouldReturnFalse() {
        var a = new QuantityMeasurementApp.Feet(1.0);
        var b = new QuantityMeasurementApp.Feet(2.0);
        assertFalse(a.equals(b));
    }

    // -------- INCH TESTS --------

    @Test
    void givenSameInch_shouldReturnTrue() {
        var a = new QuantityMeasurementApp.Inch(1.0);
        var b = new QuantityMeasurementApp.Inch(1.0);
        assertTrue(a.equals(b));
    }

    @Test
    void givenDifferentInch_shouldReturnFalse() {
        var a = new QuantityMeasurementApp.Inch(1.0);
        var b = new QuantityMeasurementApp.Inch(2.0);
        assertFalse(a.equals(b));
    }

    // -------- NULL TEST --------

    @Test
    void givenNull_shouldReturnFalse() {
        var a = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(a.equals(null));
    }

    // -------- TYPE TEST --------

    @Test
    void givenDifferentType_shouldReturnFalse() {
        var feet = new QuantityMeasurementApp.Feet(1.0);
        var inch = new QuantityMeasurementApp.Inch(12.0);
        assertFalse(feet.equals(inch));
    }

    // -------- SAME REFERENCE --------

    @Test
    void givenSameReference_shouldReturnTrue() {
        var a = new QuantityMeasurementApp.Inch(5.0);
        assertTrue(a.equals(a));
    }
}