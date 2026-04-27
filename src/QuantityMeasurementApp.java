package com.quantitymeasurement;

class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value) || unit == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Conversion
    public QuantityLength convertTo(LengthUnit target) {
        if (target == null) throw new IllegalArgumentException("Target unit null");

        double base = unit.convertToBaseUnit(value);
        double result = target.convertFromBaseUnit(base);

        return new QuantityLength(result, target);
    }

    // Addition (explicit target - UC7 compatible)
    public QuantityLength add(QuantityLength other, LengthUnit target) {
        if (other == null || target == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;
        double result = target.convertFromBaseUnit(sumBase);

        return new QuantityLength(result, target);
    }

    // Addition default (UC6)
    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(a.convertTo(LengthUnit.INCHES)); // 12 INCHES
        System.out.println(a.add(b, LengthUnit.FEET));      // 2 FEET
        System.out.println(a.equals(b));                    // true
    }
}