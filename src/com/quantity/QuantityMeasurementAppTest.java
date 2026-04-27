package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(2, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength a = new QuantityLength(12, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(1, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_YardPlusFeet() {
        QuantityLength a = new QuantityLength(1, LengthUnit.YARDS);
        QuantityLength b = new QuantityLength(3, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength a = new QuantityLength(5, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(0, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength a = new QuantityLength(5, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(-2, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NullSecondOperand() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }

    @Test
    void testAddition_Commutativity() {
        QuantityLength a = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength r1 = a.add(b);
        QuantityLength r2 = b.add(a);

        assertTrue(r1.equals(r2));
    }
}