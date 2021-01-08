package esercizi

fun main() {
    val ar = intArrayOf(7,12,8,2,10)
    val risultato = findSumMap(ar,9)
    println(risultato?.joinToString(" - "))
}

fun findSumMap(a: IntArray, sum: Int): IntArray? {
    val mappaAppoggio = mutableMapOf<Int,Int>()
    var arrayPosizioni: IntArray? = null
    for( (i,n) in a.withIndex()) {
        if(mappaAppoggio[n] != null) {
            arrayPosizioni = intArrayOf(i,mappaAppoggio[n]!!)
            return arrayPosizioni
        }
        mappaAppoggio[sum-n] = i
    }
    return null
}