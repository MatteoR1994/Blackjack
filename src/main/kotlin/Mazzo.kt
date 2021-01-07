class Mazzo {
    var carte: MutableList<Carta> = mutableListOf<Carta>()
    var semi = arrayOf("Cuori","Quadri","Denari","Picche")
    var nomi = arrayOf("asso","due","tre","quattro","cinque","sei","sette","otto","nove","dieci","jack","donna","re")
    init {
        for(seme in semi) {
            for( (i,nome) in nomi.withIndex()) {
                carte.add(Carta(seme,if(i+1 <=10) i+1 else 10,nome))
            }
        }
        carte.shuffle() // Mischio il mazzo
    }
    fun estraiCarta(): Carta {
        return carte.removeAt(carte.size-1)
    }
    fun cartaPresente(): Boolean {
        return carte.isNotEmpty()
    }
}