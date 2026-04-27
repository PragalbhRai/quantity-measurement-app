public class QuantityMeasurementApp {

    // ENUM
    enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    // CONVERSION METHOD (UC5 CORE)
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        double valueInFeet = value * source.getFactor();   // normalize
        return valueInFeet / target.getFactor();           // convert
    }

    // MAIN METHOD (for demo)
    public static void main(String[] args) {
        System.out.println(convert(1.0, LengthUnit.FEET, LengthUnit.INCHES)); // 12
        System.out.println(convert(3.0, LengthUnit.YARDS, LengthUnit.FEET));  // 9
    }
}