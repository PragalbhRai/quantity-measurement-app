package com.quantity;

import java.util.Objects;

enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double toBase(double value) {
        return value * toFeetFactor;
    }

    public double fromBase(double baseValue) {
        return baseValue / toFeetFactor;
    }
}

class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // UC5 reuse
    public static double convert(double value, LengthUnit from, LengthUnit to) {
        if (from == null || to == null)
            throw new IllegalArgumentException("Units cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        double base = from.toBase(value);
        return to.fromBase(base);
    }

    // ✅ UC6 ADDITION
    public QuantityLength add(QuantityLength other) {
        if (other == null)
            throw new IllegalArgumentException("Other length cannot be null");

        double base1 = this.unit.toBase(this.value);
        double base2 = other.unit.toBase(other.value);

        double sumBase = base1 + base2;

        double result = this.unit.fromBase(sumBase);

        return new QuantityLength(result, this.unit);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) o;

        double base1 = this.unit.toBase(this.value);
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < 1e-6;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}

public class QuantityMeasurementApp {

    public static void main(String[] args) {
package com.quantity;

        enum LengthUnit {
            FEET(1.0),
            INCHES(1.0 / 12.0),
            YARDS(3.0),
            CENTIMETERS(0.0328084);

            private final double toFeetFactor;

            LengthUnit(double toFeetFactor) {
                this.toFeetFactor = toFeetFactor;
            }

            public double toBase(double value) {
                return value * toFeetFactor;
            }

            public double fromBase(double baseValue) {
                return baseValue / toFeetFactor;
            }
        }

        class QuantityLength {
            private final double value;
            private final LengthUnit unit;

            public QuantityLength(double value, LengthUnit unit) {
                if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
                if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

                this.value = value;
                this.unit = unit;
            }

            public double getValue() {
                return value;
            }

            public LengthUnit getUnit() {
                return unit;
            }

            // ✅ UC6 (existing)
            public QuantityLength add(QuantityLength other) {
                return add(other, this.unit);
            }

            // ✅ UC7 (NEW METHOD)
            public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
                if (other == null)
                    throw new IllegalArgumentException("Other length cannot be null");

                if (targetUnit == null)
                    throw new IllegalArgumentException("Target unit cannot be null");

                double base1 = this.unit.toBase(this.value);
                double base2 = other.unit.toBase(other.value);

                double sumBase = base1 + base2;

                double result = targetUnit.fromBase(sumBase);

                return new QuantityLength(result, targetUnit);
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof QuantityLength)) return false;

                QuantityLength other = (QuantityLength) o;

                double base1 = this.unit.toBase(this.value);
                double base2 = other.unit.toBase(other.value);

                return Math.abs(base1 - base2) < 1e-6;
            }

            @Override
            public String toString() {
                return value + " " + unit;
            }
        }

        public class QuantityMeasurementApp {

            public static void main(String[] args) {

                QuantityLength l1 = new QuantityLength(1, LengthUnit.FEET);
                QuantityLength l2 = new QuantityLength(12, LengthUnit.INCHES);

                System.out.println(l1.add(l2, LengthUnit.FEET));   // 2 FEET
                System.out.println(l1.add(l2, LengthUnit.INCHES)); // 24 INCHES
                System.out.println(l1.add(l2, LengthUnit.YARDS));  // ~0.667 YARDS
            }
        }
        QuantityLength l1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = l1.add(l2);

        System.out.println("Result: " + result); // Expected: 2 FEET
    }
}