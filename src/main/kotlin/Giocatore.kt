class Giocatore(var nome: String, var saldoIniziale: Double, var saldo: Double) {
    val mano: ManoGioco = ManoGioco(false)

    fun togliPuntata(importo: Double) {
        saldo -= importo
    }

    fun aggiungiPuntata(importo: Double) {
        saldo += importo
    }
}