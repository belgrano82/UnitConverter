enum class MeasuresOfLength(val names: List<String>, val multiplier: Double) {
    METERS(listOf("m", "meter", "meters"), 1.0),
    KILOMETERS(listOf("km", "kilometer", "kilometers"), 1000.0),
    CENTIMETERS(listOf("cm", "centimeter", "centimeters"), 0.01),
    MILLIMETERS(listOf("mm", "millimeter", "millimeters"), 0.001),
    MILES(listOf("mi", "mile", "miles"), 1609.35),
    YARDS(listOf("yd", "yard", "yards"), 0.9144),
    FEET(listOf("ft", "foot", "feet"), 0.3048),
    INCHES(listOf("in", "inch", "inches"), 0.0254);
}