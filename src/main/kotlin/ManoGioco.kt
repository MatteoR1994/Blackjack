class ManoGioco(val manoBanco: Boolean) {
    var carte: MutableList<Carta> = mutableListOf<Carta>()
    var primaMostra = true

    fun aggiungiCarta(carta: Carta) {
        carte.add(carta)
    }

    fun calcolaValoreMano(): Int {
        var somma = 0
        for(c in carte) {
            somma += c.valore
        }
        return somma
    }

    fun verificaSballo(): Boolean {
        val valore = calcolaValoreMano()
        return valore > 21
    }

    fun verificaManoVincente(): Boolean {
        val valore = calcolaValoreMano()
        return valore == 21
    }

    fun manoMiglioreDi(mano: ManoGioco): Boolean {
        if(verificaSballo()) {
            return false
        }
        return calcolaValoreMano() > mano.calcolaValoreMano()
    }

    override fun toString(): String {
        var stringa = "Le carte sono: "
        if(manoBanco && primaMostra) {
            stringa += carte[0].toString()
            primaMostra = false
            return stringa
        }
        for(c in carte) {
            stringa += c.toString()
        }
        return stringa
    }
}