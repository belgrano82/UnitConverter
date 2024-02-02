class ConverterLength : Converter {

    override fun convert(from: Double, measureFrom: String, measureTo: String): List<String> {

        var convertedUnit = from
        var fromMeasure = ""
        var toMeasure = ""

        when (measureFrom.lowercase()) {
            in MeasuresOfLength.METERS.names -> {
                convertedUnit *= MeasuresOfLength.METERS.multiplier
                fromMeasure = if (from == 1.0) MeasuresOfLength.METERS.names[1] else MeasuresOfLength.METERS.names[2]
            }

            in MeasuresOfLength.KILOMETERS.names -> {
                convertedUnit *= MeasuresOfLength.KILOMETERS.multiplier
                fromMeasure =
                    if (from == 1.0) MeasuresOfLength.KILOMETERS.names[1] else MeasuresOfLength.KILOMETERS.names[2]
            }

            in MeasuresOfLength.CENTIMETERS.names -> {
                convertedUnit *= MeasuresOfLength.CENTIMETERS.multiplier
                fromMeasure =
                    if (from == 1.0) MeasuresOfLength.CENTIMETERS.names[1] else MeasuresOfLength.CENTIMETERS.names[2]
            }

            in MeasuresOfLength.MILLIMETERS.names -> {
                convertedUnit *= MeasuresOfLength.MILLIMETERS.multiplier
                fromMeasure =
                    if (from == 1.0) MeasuresOfLength.MILLIMETERS.names[1] else MeasuresOfLength.MILLIMETERS.names[2]
            }

            in MeasuresOfLength.MILES.names -> {
                convertedUnit *= MeasuresOfLength.MILES.multiplier
                fromMeasure =
                    if (from == 1.0) MeasuresOfLength.MILES.names[1] else MeasuresOfLength.MILES.names[2]
            }

            in MeasuresOfLength.YARDS.names -> {
                convertedUnit *= MeasuresOfLength.YARDS.multiplier
                fromMeasure =
                    if (from == 1.0) MeasuresOfLength.YARDS.names[1] else MeasuresOfLength.YARDS.names[2]
            }

            in MeasuresOfLength.FEET.names -> {
                convertedUnit *= MeasuresOfLength.FEET.multiplier
                fromMeasure =
                    if (from == 1.0) MeasuresOfLength.FEET.names[1] else MeasuresOfLength.FEET.names[2]
            }

            in MeasuresOfLength.INCHES.names -> {
                convertedUnit *= MeasuresOfLength.INCHES.multiplier
                fromMeasure =
                    if (from == 1.0) MeasuresOfLength.INCHES.names[1] else MeasuresOfLength.INCHES.names[2]
            }
        }

        when (measureTo.lowercase()) {
            in MeasuresOfLength.METERS.names -> {
                convertedUnit /= MeasuresOfLength.METERS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasuresOfLength.METERS.names[1] else MeasuresOfLength.METERS.names[2]
            }

            in MeasuresOfLength.KILOMETERS.names -> {
                convertedUnit /= MeasuresOfLength.KILOMETERS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasuresOfLength.KILOMETERS.names[1] else MeasuresOfLength.KILOMETERS.names[2]
            }

            in MeasuresOfLength.CENTIMETERS.names -> {
                convertedUnit /= MeasuresOfLength.CENTIMETERS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasuresOfLength.CENTIMETERS.names[1] else MeasuresOfLength.CENTIMETERS.names[2]
            }

            in MeasuresOfLength.MILLIMETERS.names -> {
                convertedUnit /= MeasuresOfLength.MILLIMETERS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasuresOfLength.MILLIMETERS.names[1] else MeasuresOfLength.MILLIMETERS.names[2]
            }

            in MeasuresOfLength.MILES.names -> {
                convertedUnit /= MeasuresOfLength.MILES.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasuresOfLength.MILES.names[1] else MeasuresOfLength.MILES.names[2]
            }

            in MeasuresOfLength.YARDS.names -> {
                convertedUnit /= MeasuresOfLength.YARDS.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasuresOfLength.YARDS.names[1] else MeasuresOfLength.YARDS.names[2]
            }

            in MeasuresOfLength.FEET.names -> {
                convertedUnit /= MeasuresOfLength.FEET.multiplier
                toMeasure = if (convertedUnit == 1.0) MeasuresOfLength.FEET.names[1] else MeasuresOfLength.FEET.names[2]
            }

            in MeasuresOfLength.INCHES.names -> {
                convertedUnit /= MeasuresOfLength.INCHES.multiplier
                toMeasure =
                    if (convertedUnit == 1.0) MeasuresOfLength.INCHES.names[1] else MeasuresOfLength.INCHES.names[2]
            }
        }
        return listOf(convertedUnit.toString(), fromMeasure, toMeasure)
    }
}