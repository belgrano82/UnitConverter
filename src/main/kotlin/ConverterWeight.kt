class ConverterWeight : Converter {

    override fun convert(from: Double, measureFrom: String, measureTo: String): List<String> {

        var convertedUnit = from
        var fromMeasure = ""
        var toMeasure = ""

        when (measureFrom.lowercase()) {
            in MeasureOfWeight.GRAMS.names -> {
                convertedUnit *= MeasureOfWeight.GRAMS.multiplier
                fromMeasure = if (from == 1.0) MeasureOfWeight.GRAMS.names[1] else MeasureOfWeight.GRAMS.names[2]
            }

            in MeasureOfWeight.KILOGRAMS.names -> {
                convertedUnit *= MeasureOfWeight.KILOGRAMS.multiplier
                fromMeasure =
                    if (from == 1.0) MeasureOfWeight.KILOGRAMS.names[1] else MeasureOfWeight.KILOGRAMS.names[2]
            }

            in MeasureOfWeight.MILLIGRAMS.names -> {
                convertedUnit *= MeasureOfWeight.MILLIGRAMS.multiplier
                fromMeasure =
                    if (from == 1.0) MeasureOfWeight.MILLIGRAMS.names[1] else MeasureOfWeight.MILLIGRAMS.names[2]
            }

            in MeasureOfWeight.POUNDS.names -> {
                convertedUnit *= MeasureOfWeight.POUNDS.multiplier
                fromMeasure = if (from == 1.0) MeasureOfWeight.POUNDS.names[1] else MeasureOfWeight.POUNDS.names[2]
            }

            in MeasureOfWeight.OUNCES.names -> {
                convertedUnit *= MeasureOfWeight.OUNCES.multiplier
                fromMeasure = if (from == 1.0) MeasureOfWeight.OUNCES.names[1] else MeasureOfWeight.OUNCES.names[2]
            }
        }

        when (measureTo.lowercase()) {
            in MeasureOfWeight.GRAMS.names -> {
                convertedUnit /= MeasureOfWeight.GRAMS.multiplier
                toMeasure = if (convertedUnit == 1.0) MeasureOfWeight.GRAMS.names[1] else MeasureOfWeight.GRAMS.names[2]
            }

            in MeasureOfWeight.KILOGRAMS.names -> {
                convertedUnit /= MeasureOfWeight.KILOGRAMS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasureOfWeight.KILOGRAMS.names[1] else MeasureOfWeight.KILOGRAMS.names[2]
            }

            in MeasureOfWeight.MILLIGRAMS.names -> {
                convertedUnit /= MeasureOfWeight.MILLIGRAMS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasureOfWeight.MILLIGRAMS.names[1] else MeasureOfWeight.MILLIGRAMS.names[2]
            }

            in MeasureOfWeight.POUNDS.names -> {
                convertedUnit /= MeasureOfWeight.POUNDS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasureOfWeight.POUNDS.names[1] else MeasureOfWeight.POUNDS.names[2]
            }

            in MeasureOfWeight.OUNCES.names -> {
                convertedUnit /= MeasureOfWeight.OUNCES.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasureOfWeight.OUNCES.names[1] else MeasureOfWeight.OUNCES.names[2]
            }
        }

        return listOf(convertedUnit.toString(), fromMeasure, toMeasure)
    }
}
