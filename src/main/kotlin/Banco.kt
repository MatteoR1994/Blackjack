class Banco(var giocatore: Giocatore) {
    var mazzo = Mazzo()
    val mano = ManoGioco(true)

    fun startGame() {
        println("Benvenuto ${giocatore.nome}! Iniziamo la nostra partita.")
        var carta1 = mazzo.estraiCarta()
        var carta2 = mazzo.estraiCarta()
        giocatore.mano.aggiungiCarta(carta1)
        giocatore.mano.aggiungiCarta(carta2)
        var carta3 = mazzo.estraiCarta()
        var carta4 = mazzo.estraiCarta()
        mano.aggiungiCarta(carta3)
        mano.aggiungiCarta(carta4)
        println("Quanto vuoi puntare?")
        var input = readLine()
        val valorePuntata = input!!.toDouble()
        println("\nGIOCATORE: ${giocatore.mano}")
        println("\nBANCO: ${mano}")
        if(giocatore.mano.verificaManoVincente()) {
            println("Bravo! Hai vinto.")
            return
        }
        var risposta: String? = null
        do {
            println("stai o carta?")
            risposta = readLine()!!
            if(risposta == "stai") {
                break
            }
            var cartaNuova = mazzo.estraiCarta()
            println(cartaNuova)
            println()
            giocatore.mano.aggiungiCarta(cartaNuova)
            if(giocatore.mano.verificaSballo()) {
                println("Hai superato 21. Peccato, hai perso!")
                break
            }
            if(giocatore.mano.verificaManoVincente()) {
                println("Bravo! Hai vinto.")
                break
            }
            println(giocatore.mano)
        } while(true)
        do {
            if(mano.verificaSballo()) {
                println("Il banco ha sballato, vince ${giocatore.nome}.")
                break
            }
            if (mano.manoMiglioreDi(giocatore.mano)) {
                println("Mi spiace, hai perso. Ho vinto io!")
                println(mano)
                break
            }
            if (mano.calcolaValoreMano() >= 17) {
                println("Punteggio del banco maggiore di 17, perde. Vince ${giocatore.nome}.")
                break
            }
            var cartaNuovaBanco = mazzo.estraiCarta()
            mano.aggiungiCarta(cartaNuovaBanco)
            println("Il banco ha estratto: $cartaNuovaBanco")
            println(mano)
        } while(true)
    }
}