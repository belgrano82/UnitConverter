interface Converter {
    fun convert(from: Double, measureFrom: String, measureTo: String): List<String>
}