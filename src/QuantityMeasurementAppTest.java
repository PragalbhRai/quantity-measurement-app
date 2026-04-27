import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                QuantityMeasurementApp.convert(24.0,
                        QuantityMeasurementApp.LengthUnit.INCHES,
                        QuantityMeasurementApp.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testYardsToInches() {
        assertEquals(36.0,
                QuantityMeasurementApp.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testSameUnit() {
        assertEquals(5.0,
                QuantityMeasurementApp.convert(5.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testZeroValue() {
        assertEquals(0.0,
                QuantityMeasurementApp.convert(0.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testNegativeValue() {
        assertEquals(-12.0,
                QuantityMeasurementApp.convert(-1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(1.0, null,
                        QuantityMeasurementApp.LengthUnit.FEET));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(Double.NaN,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES));
    }
}