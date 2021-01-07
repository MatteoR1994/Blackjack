package esercizi

fun main() {
    val numeri = intArrayOf(10,15,87,200,231)
    val posizioneTarget: Int? = ricercaBinaria(numeri,15,0,numeri.size)
    println("Array originale:")
    println("${numeri.joinToString(" - ")}\n")
    println(posizioneTarget ?: "Non trovato.")
}

fun ricercaBinaria(array: IntArray, target: Int, inizio: Int, fine: Int): Int? {
    var centro: Int = (fine + inizio) / 2
    if(inizio >= fine) {
        return null
    }
    if(array[centro] == target) {
        return centro
    }
    if(array[centro] > target) {
        return ricercaBinaria(array,target,inizio,centro)
    }
    if(array[centro] < target) {
        return ricercaBinaria(array,target,centro+1,fine)
    }
    return null
}