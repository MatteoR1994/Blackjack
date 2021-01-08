package esercizi

fun main() {
    //val parole = arrayOf("pippo","sciarpa","calcio","bicchiere","frutta","ombrello","libro","penna","palazzo","errori")
    //val parole = arrayOf("pippo","anna","calcio","bicchiere","frutta","abba","libro","penna","palazzo","errori")
    val parole = arrayOf("pippo","anna","calcio","nnaa","frutta","abba","libro","penna","palazzo","aann")
    val parolaAnagramma = "nana"
    val palindrome = trovaPalindrome(parole)
    println("Array parole:")
    println(parole.joinToString(" - "))
    print("--------------------\nPalindrome:\n")
    print(palindrome?.joinToString(" - ") ?: "Non ce ne sono.")
    println()
    print("--------------------\nAnagrammi di <$parolaAnagramma>:\n")
    val anagrammi = trovaAnagrammi(parole,parolaAnagramma)
    if(anagrammi.size == 0) {
        print("Non ce ne sono.\n")
    } else {
        print(anagrammi?.joinToString(" - "))
        println()
    }
}

fun trovaPalindrome(array: Array<String>): MutableList<String>? {
    val risultato: MutableList<String>? = mutableListOf()
    for(i in 0 until array.size) {
        if(array[i].reversed() == array[i]) {
            risultato?.add(array[i])
        }
    }
    return risultato
}

fun trovaAnagrammi(array: Array<String>, target: String): MutableList<String> {
    val risultato: MutableList<String> = mutableListOf()
    // Stringa target: 1) Converto in array di caratteri; 2) Lo ordino; 3) Lo converto in stringa
    var charTarget = target.toCharArray()
    charTarget.sort()
    val secondaStringaConfronto = charTarget.contentToString()
    for(i in 0 until array.size) {
        // Stringa in array: 1) Converto in array di caratteri; 2) Lo ordino; 3) Lo converto in stringa
        var charAr = array[i].toCharArray()
        charAr.sort()
        val primaStringaConfronto = charAr.contentToString()
        if (primaStringaConfronto==secondaStringaConfronto) {
            risultato.add(array[i])
        }
    }
    return risultato
}