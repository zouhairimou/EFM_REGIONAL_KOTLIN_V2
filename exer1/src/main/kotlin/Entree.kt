class Entree(var motFrancais: String, var motAnglais: String) {
    init {
        require(!motFrancais.isEmptyOrBlank()) { "Le mot français ne peut pas être vide ou blanc" }
        require(!motAnglais.isEmptyOrBlank()) { "Le mot anglais ne peut pas être vide ou blanc" }
    }

    override fun toString(): String {
        return "$motFrancais:$motAnglais"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Entree) return false

        return motFrancais == other.motFrancais
    }
}

fun String.isEmptyOrBlank(): Boolean {
    return this.isBlank()
}

fun String.sigle(): String {
    return this.split(" ").map { it.first().toUpperCase() }.joinToString("")
}

