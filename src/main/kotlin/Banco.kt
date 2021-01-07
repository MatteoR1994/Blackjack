class Banco(var giocatore: Giocatore) {
    var mazzo = Mazzo()
    val mano = ManoGioco(true)

    fun startGame() {
        println("Benvenuto ${giocatore.nome}! Iniziamo la nostra partita.")
        println("\nParti con ${giocatore.saldoIniziale} euro.")
        println("\n----------------------------------------------------\n")
        var numeroMani = 1
        var vittoriaSubito = false
        do {
            var sconfittaGiocatore = false
            println("MANO N°: $numeroMani\n")
            println("Quanto vuoi puntare? Il saldo attuale e': ${giocatore.saldo}")
            var input = readLine()
            val valorePuntata = input!!.toDouble()
            var carta1 = mazzo.estraiCarta()
            var carta2 = mazzo.estraiCarta()
            /*if(carta1.nome == "asso") {
                carta1 = determinaValoreAsso(carta1)
            }
            if(carta2.nome == "asso") {
                carta2 = determinaValoreAsso(carta2)
            }*/
            giocatore.mano.aggiungiCarta(carta1)
            giocatore.mano.aggiungiCarta(carta2)
            var carta3 = mazzo.estraiCarta()
            var carta4 = mazzo.estraiCarta()
            mano.aggiungiCarta(carta3)
            mano.aggiungiCarta(carta4)
            //println("\nGIOCATORE: ${giocatore.mano} - Valore mano: ${giocatore.mano.calcolaValoreMano()} ")
            println("\nGIOCATORE: ${giocatore.mano}")
            if(carta1.nome == "asso") {
                carta1 = determinaValoreAsso(carta1)
            }
            if(carta2.nome == "asso") {
                carta2 = determinaValoreAsso(carta2)
            }
            println("Valore mano: ${giocatore.mano.calcolaValoreMano()}")
            println("\nBANCO: ${mano}")
            if (giocatore.mano.verificaManoVincente()) {
                println("Bravo! Hai vinto.")
                giocatore.aggiungiPuntata(valorePuntata)
                vittoriaSubito = true
                //return
                //break
            }
            if(!vittoriaSubito) {
                var risposta: String? = null
                do {
                    /*if (giocatore.mano.verificaManoVincente()) {
                    println("Bravo! Hai vinto.")
                    giocatore.aggiungiPuntata(valorePuntata)
                    //return
                    break
                }*/
                    println("stai o carta?")
                    risposta = readLine()!!
                    if (risposta == "stai") {
                        break
                    }
                    var cartaNuova = mazzo.estraiCarta()
                    println(cartaNuova)
                    cartaNuova = determinaValoreAsso(cartaNuova)
                    println()
                    giocatore.mano.aggiungiCarta(cartaNuova)
                    if (giocatore.mano.verificaSballo()) {
                        println("Hai superato 21. Peccato, hai perso!")
                        giocatore.togliPuntata(valorePuntata)
                        sconfittaGiocatore = true
                        break
                    }
                    if (giocatore.mano.verificaManoVincente()) {
                        println("Bravo! Hai vinto.")
                        giocatore.aggiungiPuntata(valorePuntata)
                        break
                    }
                    //println("GIOCATORE: ${giocatore.mano} - Valore: ${giocatore.mano.calcolaValoreMano()}")
                    println("GIOCATORE: ${giocatore.mano}")
                    println("Valore: ${giocatore.mano.calcolaValoreMano()}")
                } while (true)
            }
            if(!sconfittaGiocatore && !vittoriaSubito) {
                do {
                    if (mano.verificaSballo()) {
                        println("Il banco ha sballato, vince ${giocatore.nome}.")
                        giocatore.aggiungiPuntata(valorePuntata)
                        break
                    }
                    if (mano.manoMiglioreDi(giocatore.mano)) {
                        println("Mi spiace, hai perso. Ho vinto io!")
                        giocatore.togliPuntata(valorePuntata)
                        println(mano)
                        break
                    }
                    if (mano.calcolaValoreMano() >= 17) {
                        println("Punteggio del banco maggiore di 17, perde. Vince ${giocatore.nome}.")
                        giocatore.aggiungiPuntata(valorePuntata)
                        break
                    }
                    var cartaNuovaBanco = mazzo.estraiCarta()
                    //cartaNuovaBanco = determinaValoreAsso(cartaNuovaBanco)
                    mano.aggiungiCarta(cartaNuovaBanco)
                    println("Il banco ha estratto: $cartaNuovaBanco")
                    println("BANCO: $mano")
                } while (true)
            }
            println("\nVuoi giocare ancora? si = continua / no = esci")
            val inputContinua = readLine()!!
            numeroMani ++
            println("\n****************************************************\n")
            giocatore.mano.carte.clear()
            mano.carte.clear()
            mano.primaMostra = true
            vittoriaSubito = false
        }while(inputContinua != "no")
        println("PARTITA FINITA, GRAZIE PER AVER GIOCATO. A PRESTO!")
    }

    fun determinaValoreAsso(carta: Carta): Carta {
        if(carta.nome == "asso") {
            println("Hai pescato un asso! Quanto vuoi farlo valere, 1 o 11?")
            val input = readLine()!!
            carta.valore = input.toInt()
        }
        return carta
    }
}