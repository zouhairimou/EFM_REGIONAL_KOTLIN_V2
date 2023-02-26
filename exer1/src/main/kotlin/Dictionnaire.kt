class Dictionnaire {
    private val entrees = ArrayList<Entree>()

    fun nombreEntrees(): Int {
        return entrees.size
    }

    fun ajouter(e: Entree) {
        if (entrees.contains(e)) {
            throw Exception("L'entrée existe déjà dans le dictionnaire.")
        }
        entrees.add(e)
    }

    fun supprimer(e: Entree): Boolean {
        return entrees.remove(e)
    }

    fun supprimer(motFrancais: String): Boolean {
        val entree = entrees.find { it.motFrancais == motFrancais }
        return entree?.let { entrees.remove(it) } ?: false
    }

    fun anFr(motAnglais: String): ArrayList<String> {
        val motsFrancais = ArrayList<String>()
        for (entree in entrees) {
            if (entree.motAnglais == motAnglais) {
                motsFrancais.add(entree.motFrancais)
            }
        }
        return motsFrancais
    }

    fun motsAnglais(): ArrayList<String> {
        val motsAnglais = HashSet<String>()
        for (entree in entrees) {
            motsAnglais.add(entree.motAnglais)
        }
        return ArrayList(motsAnglais)
    }

    fun dictionnaireAnFr(): Map<String, ArrayList<String>> {
        val dicoAnFr = HashMap<String, ArrayList<String>>()
        for (entree in entrees) {
            if (!dicoAnFr.containsKey(entree.motAnglais)) {
                dicoAnFr[entree.motAnglais] = ArrayList()
            }
            dicoAnFr[entree.motAnglais]?.add(entree.motFrancais)
        }
        return dicoAnFr
    }

    override fun toString(): String {
        return entrees.joinToString("\n")
    }
}
