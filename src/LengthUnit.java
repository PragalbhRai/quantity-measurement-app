public enum LengthUnit {
    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(0.393701 / 12.0); // convert cm → inch → feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double toFeet(double value) {
        return value * toFeetFactor;
    }
}