fun main() = converting()

private fun converting() {
    var input = ""

    while (input != "exit") {
        print("Enter what you want to convert (or exit): ")
        input = readln()
        convertResult(input)
    }
}

private fun convertResult(input: String) {

    if (input != "exit") {
        try {
            val connectors = listOf("to", "in", "convertTo")

            val regexPattern = connectors.joinToString("|") { "\\b$it\\b" }.toRegex()

            val parts = regexPattern.split(input).map { it.trim() }

            if (parts.size == 2) {
                val firstPart = parts[0].split(" ")
                val amount = firstPart[0].toDouble()
                val from = firstPart.drop(1).joinToString(" ")
                val to = parts[1]

                val meas1 = findMatchingEnum(from)
                val meas2 = findMatchingEnum(to)

                println(
                    when (checkPossibilityOfConversion(meas1?.get(0) ?: "???", meas2?.get(0) ?: "???")) {
                        "weight" -> {
                            val result = ConverterWeight().convert(amount, from, to)
                            if (amount < 0) "Weight shouldn't be negative" else "$amount ${result[1]} is ${result[0]} ${result[2]}\n"
                        }

                        "length" -> {
                            val result = ConverterLength().convert(amount, from, to)
                            if (amount < 0) "Length shouldn't be negative" else "$amount ${result[1]} is ${result[0]} ${result[2]}\n"
                        }

                        "temperature" -> {
                            val result = ConverterTemperature().convert(amount, from, to)
                            "$amount ${result[1]} is ${result[0]} ${result[2]}\n"

                        }

                        else -> "Conversion from ${meas1?.get(2) ?: "???"} to ${meas2?.get(2) ?: "???"} is impossible\n"
                    }
                )
            } else {
                println("Parse error\n")
            }
        } catch (e: Exception) {
            println("Parse error\n")
        }
    }
}

private fun checkPossibilityOfConversion(measure1: String, measure2: String): String {

    val listMeasuresOfLength = MeasuresOfLength.entries.flatMap { it.names }
    val listMeasuresOfWeight = MeasureOfWeight.entries.flatMap { it.names }
    val listMeasuresOfTemperature = MeasuresOfTemperature.entries.flatMap { it.names }

    return when {
        measure1 in listMeasuresOfWeight && measure2 in listMeasuresOfWeight -> "weight"
        measure1 in listMeasuresOfLength && measure2 in listMeasuresOfLength -> "length"
        measure1 in listMeasuresOfTemperature && measure2 in listMeasuresOfTemperature -> "temperature"
        else -> ""
    }
}

private fun findMatchingEnum(value: String): List<String>? {
    MeasuresOfLength.entries.firstOrNull { value.lowercase() in it.names }?.let { return it.names }
    MeasureOfWeight.entries.firstOrNull { value.lowercase() in it.names }?.let { return it.names }
    MeasuresOfTemperature.entries.firstOrNull { measure ->
        measure.names.any { it.equals(value, ignoreCase = true) }
    }.let {
        if (it != null) {
            return it.names
        }
    }
    return null
}
