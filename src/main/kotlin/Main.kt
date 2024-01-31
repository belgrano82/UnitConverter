fun main() {

    print("Enter a number and a measure of length: ")

    val input = readln()

    println(convert(input))
}

fun convert(input: String): String {

    try {

        val (number, measure) = input.split(" ")

        return checkMeasure(number.toDouble(), measure)

    } catch (e: IndexOutOfBoundsException) {

        return "Wrong input"

    }

}

fun checkMeasure(number: Double, measure: String): String {

    var convertedUnit = number
    var nameOfMeasure = ""

    when (measure.lowercase()) {

        in MeasuresOfLength.METERS.names -> {
            convertedUnit *= 1.0
            nameOfMeasure = if (number == 1.0) MeasuresOfLength.METERS.names[1] else MeasuresOfLength.METERS.names[2]
        }

        in MeasuresOfLength.KILOMETERS.names -> {
            convertedUnit *= 1000.0
            nameOfMeasure =
                if (number == 1.0) MeasuresOfLength.KILOMETERS.names[1] else MeasuresOfLength.KILOMETERS.names[2]

        }

        in MeasuresOfLength.CENTIMETERS.names -> {
            convertedUnit /= 100.0
            nameOfMeasure =
                if (number == 1.0) MeasuresOfLength.CENTIMETERS.names[1] else MeasuresOfLength.CENTIMETERS.names[2]
        }

        in MeasuresOfLength.MILLIMETERS.names -> {
            convertedUnit /= 1000.0
            nameOfMeasure =
                if (number == 1.0) MeasuresOfLength.MILLIMETERS.names[1] else MeasuresOfLength.MILLIMETERS.names[2]
        }

        in MeasuresOfLength.MILES.names -> {
            convertedUnit *= 1609.35
            nameOfMeasure = if (number == 1.0) MeasuresOfLength.MILES.names[1] else MeasuresOfLength.MILES.names[2]
        }

        in MeasuresOfLength.YARDS.names -> {
            convertedUnit *= 0.9144
            nameOfMeasure = if (number == 1.0) MeasuresOfLength.YARDS.names[1] else MeasuresOfLength.YARDS.names[2]
        }

        in MeasuresOfLength.FEET.names -> {
            convertedUnit *= 0.3048
            nameOfMeasure = if (number == 1.0) MeasuresOfLength.FEET.names[1] else MeasuresOfLength.FEET.names[2]
        }

        in MeasuresOfLength.INCHES.names -> {
            convertedUnit *= 0.0254
            nameOfMeasure = if (number == 1.0) MeasuresOfLength.INCHES.names[1] else MeasuresOfLength.INCHES.names[2]
        }

        else -> return "Wrong input. Unknown unit $measure"
    }

    val formOfMeters = if (convertedUnit == 1.0) "meter" else "meters"


    return "$number $nameOfMeasure is $convertedUnit $formOfMeters"
}