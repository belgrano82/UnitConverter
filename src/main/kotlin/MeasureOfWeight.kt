enum class MeasureOfWeight(val names: List<String>, val multiplier: Double) {
    GRAMS(listOf("g", "gram", "grams"), 1.0),
    KILOGRAMS(listOf("kg", "kilogram", "kilograms"), 1000.0),
    MILLIGRAMS(listOf("mg", "milligram", "milligrams"), 0.001),
    POUNDS(listOf("lb", "pound", "pounds"), 453.592),
    OUNCES(listOf("oz", "ounce", "ounces"), 28.3495);
}