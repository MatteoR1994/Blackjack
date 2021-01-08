package esercizi

fun main() {
    val parole = arrayOf("pippo","sciarpa","calcio","bicchiere","frutta","ombrello","libro","penna","palazzo","errori")
    val parolaEstratta = parole[(0 until parole.size).random()]
    var caratteriTrovati = CharArray(parolaEstratta.length)
    for(i in 0 until parolaEstratta.length) {
        caratteriTrovati[i] = '-'
    }
    var numeroTentativi = 10
    while(true) {
        println("La parola da indovinare e' lunga: ${parolaEstratta.length}.\n")
        println(caratteriTrovati)
        println("in: Indovinare / l: Lettera ?")
        var scelta = readLine()!!
        when(scelta) {
            "l" -> {
                if(numeroTentativi <= 0) {
                    println("Non hai piu' tentativi, devi indovinare la parola.")
                }
                else {
                    println("\nInserire una lettera: ")
                    var input = readLine()!!
                    var stringaScomposta = parolaEstratta.toCharArray()
                    for (a in 0 until stringaScomposta.size) {
                        if (stringaScomposta[a] == input[0]) {
                            caratteriTrovati[a] = input[0]
                        }
                    }
                    numeroTentativi--
                    println(caratteriTrovati)

                    println("Hai ancora $numeroTentativi lettere disponibili da inserire per indovinare.")
                }
            }
            else -> {
                println("\nInserisci la parola: ")
                var input = readLine()!!
                if(parolaEstratta == input) {
                    println("Bravo, hai indovinato!")
                    break
                } else {
                    println("Peccato, hai sbagliato! GAME OVER.")
                    println("La parola estratta era: $parolaEstratta")
                    break
                }
            }
        }
    }
}