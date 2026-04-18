import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void yardToFeet_equal() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.YARD);
        var b = new QuantityMeasurementApp.Quantity(3.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
    }

    @Test
    void yardToInch_equal() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.YARD);
        var b = new QuantityMeasurementApp.Quantity(36.0, LengthUnit.INCH);
        assertTrue(a.equals(b));
    }

    @Test
    void cmToInch_equal() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.CM);
        var b = new QuantityMeasurementApp.Quantity(0.393701, LengthUnit.INCH);
        assertTrue(a.equals(b));
    }

    @Test
    void cmToFeet_notEqual() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.CM);
        var b = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        assertFalse(a.equals(b));
    }

    @Test
    void transitiveProperty() {
        var yard = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.YARD);
        var feet = new QuantityMeasurementApp.Quantity(3.0, LengthUnit.FEET);
        var inch = new QuantityMeasurementApp.Quantity(36.0, LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }
}