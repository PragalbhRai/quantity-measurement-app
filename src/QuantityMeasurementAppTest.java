import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void feetToFeet_sameValue() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
    }

    @Test
    void inchToInch_sameValue() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.INCH);
        var b = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.INCH);
        assertTrue(a.equals(b));
    }

    @Test
    void feetToInch_equal() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.Quantity(12.0, LengthUnit.INCH);
        assertTrue(a.equals(b));
    }

    @Test
    void inchToFeet_equal() {
        var a = new QuantityMeasurementApp.Quantity(12.0, LengthUnit.INCH);
        var b = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
    }

    @Test
    void differentValues_notEqual() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.Quantity(2.0, LengthUnit.FEET);
        assertFalse(a.equals(b));
    }

    @Test
    void nullComparison() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        assertFalse(a.equals(null));
    }

    @Test
    void sameReference() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        assertTrue(a.equals(a));
    }
}