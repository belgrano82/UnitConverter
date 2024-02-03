class ConverterTemperature : Converter {

    override fun convert(from: Double, measureFrom: String, measureTo: String): List<String> {
        var convertedUnit = from
        var fromMeasure = ""
        var toMeasure = ""

        when (measureFrom.lowercase()) {
            in MeasuresOfTemperature.CELSIUS.names.map { it.lowercase() } -> {
                when (measureTo.lowercase()) {
                    in MeasuresOfTemperature.FAHRENHEIT.names.map { it.lowercase() } -> {
                        convertedUnit = from * 9 / 5 + 32
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.FAHRENHEIT.names[1] else MeasuresOfTemperature.FAHRENHEIT.names[2]
                    }

                    in MeasuresOfTemperature.KELVINS.names.map { it.lowercase() } -> {
                        convertedUnit = from + 273.15
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.KELVINS.names[1] else MeasuresOfTemperature.KELVINS.names[2]
                    }

                    in MeasuresOfTemperature.CELSIUS.names.map { it.lowercase() } -> {
                        convertedUnit = from
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.CELSIUS.names[1] else MeasuresOfTemperature.CELSIUS.names[2]
                    }
                }
                fromMeasure =
                    if (from == 1.0) MeasuresOfTemperature.CELSIUS.names[1] else MeasuresOfTemperature.CELSIUS.names[2]
            }

            in MeasuresOfTemperature.FAHRENHEIT.names.map { it.lowercase() } -> {
                when (measureTo.lowercase()) {
                    in MeasuresOfTemperature.CELSIUS.names.map { it.lowercase() } -> {
                        convertedUnit = (from - 32) * 5 / 9
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.CELSIUS.names[1] else MeasuresOfTemperature.CELSIUS.names[2]
                    }

                    in MeasuresOfTemperature.KELVINS.names.map { it.lowercase() } -> {
                        convertedUnit = (from + 459.67) * 5 / 9
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.KELVINS.names[1] else MeasuresOfTemperature.KELVINS.names[2]
                    }

                    in MeasuresOfTemperature.FAHRENHEIT.names.map { it.lowercase() } -> {
                        convertedUnit = from
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.FAHRENHEIT.names[1] else MeasuresOfTemperature.FAHRENHEIT.names[2]
                    }
                }
                fromMeasure =
                    if (from == 1.0) MeasuresOfTemperature.FAHRENHEIT.names[1] else MeasuresOfTemperature.FAHRENHEIT.names[2]
            }

            in MeasuresOfTemperature.KELVINS.names.map { it.lowercase() } -> {
                when (measureTo.lowercase()) {
                    in MeasuresOfTemperature.CELSIUS.names.map { it.lowercase() } -> {
                        convertedUnit = from - 273.15
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.CELSIUS.names[1] else MeasuresOfTemperature.CELSIUS.names[2]
                    }

                    in MeasuresOfTemperature.FAHRENHEIT.names.map { it.lowercase() } -> {
                        convertedUnit = from * 9 / 5 - 459.67
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.FAHRENHEIT.names[1] else MeasuresOfTemperature.FAHRENHEIT.names[2]
                    }

                    in MeasuresOfTemperature.KELVINS.names.map { it.lowercase() } -> {
                        convertedUnit = from
                        toMeasure =
                            if (convertedUnit == 1.0) MeasuresOfTemperature.KELVINS.names[1] else MeasuresOfTemperature.KELVINS.names[2]
                    }
                }
                fromMeasure =
                    if (from == 1.0) MeasuresOfTemperature.KELVINS.names[1] else MeasuresOfTemperature.KELVINS.names[2]
            }
        }
        return listOf(convertedUnit.toString(), fromMeasure, toMeasure)
    }
}