package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = a.add(b, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = a.add(b, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = a.add(b, LengthUnit.YARDS);

        assertEquals(0.666666, result.getValue(), 1e-3);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {
        QuantityLength a = new QuantityLength(1, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(1, LengthUnit.INCHES);

        QuantityLength result = a.add(b, LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), 1e-2);
    }

    @Test
    void testAddition_Commutativity_WithTargetUnit() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength r1 = a.add(b, LengthUnit.YARDS);
        QuantityLength r2 = b.add(a, LengthUnit.YARDS);

        assertEquals(r1.getValue(), r2.getValue(), EPSILON);
    }

    @Test
    void testAddition_WithZero_TargetUnit() {
        QuantityLength a = new QuantityLength(5, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(0, LengthUnit.INCHES);

        QuantityLength result = a.add(b, LengthUnit.YARDS);

        assertEquals(1.666666, result.getValue(), 1e-3);
    }

    @Test
    void testAddition_NegativeValues_TargetUnit() {
        QuantityLength a = new QuantityLength(5, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(-2, LengthUnit.FEET);

        QuantityLength result = a.add(b, LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NullTargetUnit() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> a.add(b, null));
    }
}