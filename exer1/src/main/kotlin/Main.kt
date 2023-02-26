fun main(args: Array<String>) {
    fun String.estVideOuBlanche(): Boolean {
        return this.trim().isEmpty()
    }

    fun String.sigle(): String {
        val words = this.split("\\s+".toRegex()).filter { it.isNotBlank() }
        return words.joinToString("") { it.first().toUpperCase().toString() }
    }

}