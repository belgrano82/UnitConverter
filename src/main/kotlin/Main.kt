fun main() = converting()

private fun converting() {
    var input = ""

    while (input != "exit") {
        print("Enter what you want to convert (or exit): ")
        input = readln()
        convertResult(input)
        println()
    }
}

private fun convertResult(input: String) {

    if (input != "exit") {
        try {
            val (number, measure1, transWord, measure2) = input.split(" ")
            val amount = number.toDouble()

            val meas1 = findMatchingEnum(measure1)
            val meas2 = findMatchingEnum(measure2)

            println(
                when (checkPossibilityOfConversion(meas1?.get(0) ?: "???", meas2?.get(0) ?: "???")) {
                    "weight" -> {
                        val result = ConverterWeight().convert(amount, measure1, measure2)
                        "$amount ${result[1]} is ${result[0]} ${result[2]}"
                    }
                    "length" -> {
                        val result = ConverterLength().convert(amount, measure1, measure2)
                        "$amount ${result[1]} is ${result[0]} ${result[2]}"
                    }
                    else -> "Conversion from ${meas1?.get(2) ?: "???"} to ${meas2?.get(2) ?: "???"} is impossible"
                }
            )
        } catch (e: Exception) {
            println(false)
        }
    }
}
private fun checkPossibilityOfConversion(measure1: String, measure2: String): String {

    val listMeasuresOfLength = MeasuresOfLength.entries.flatMap { it.names }
    val listMeasuresOfWeight = MeasureOfWeight.entries.flatMap { it.names }

    return when {
        measure1 in listMeasuresOfWeight && measure2 in listMeasuresOfWeight -> "weight"
        measure1 in listMeasuresOfLength && measure2 in listMeasuresOfLength -> "length"
        else -> ""
    }
}
private fun findMatchingEnum(value: String): List<String>? {
    MeasuresOfLength.entries.firstOrNull { value.lowercase() in it.names }?.let { return it.names }
    MeasureOfWeight.entries.firstOrNull { value.lowercase() in it.names }?.let { return it.names }
    return null
}
