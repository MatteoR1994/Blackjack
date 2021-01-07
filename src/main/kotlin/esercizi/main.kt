package esercizi

fun main() {
    val ar = intArrayOf(7,12,8,2,10)
    val risultato = findSum(ar,9)
    println("Array originale:")
    println("${ar.joinToString(" - ")}\n")
    println("Posizione degli elementi dell'array originale la cui somma fa 9:")
    println(risultato?.joinToString(" - "))
    // 0 - 3
}

fun findSum(a: IntArray, sum: Int): IntArray? {
    val arrayRisultato = IntArray(2)
    for(i in 0 until a.size) {
        for(b in i+1 until  a.size) {
            if(a[i]+a[b] == sum) {
                arrayRisultato[0] = i
                arrayRisultato[1] = b
                return arrayRisultato
            }
        }
    }
    return null
}