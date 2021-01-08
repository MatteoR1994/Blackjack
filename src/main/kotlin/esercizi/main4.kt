package esercizi

import kotlin.math.min

fun main() {
    val array = intArrayOf(6,2,23,1,16,7)
    val risultato = trovaPali(array)
    println(array.joinToString(" - "))
    println()
    println(risultato?.joinToString(" - "))
}

fun trovaPali(a: IntArray): IntArray {
    var arrayPosizioni = IntArray(3)
    var valoreMassimo = 0
    /*for(i in 0 until a.size) {
        for(j in i+1 until a.size) {
            /*var min = if(a[i] < a[j]) {
                a[i]
            } else {
                a[j]
            }*/
            var min = min(a[i],a[j])
            if(min*(j-i) > valoreMassimo) {
                valoreMassimo = min*(j-i)
                arrayPosizioni[0] = i
                arrayPosizioni[1] = j
                arrayPosizioni[2] = valoreMassimo
            }
        }
    }*/
    var pos1 = 0
    var pos2 = a.size-1
    while(pos1 < pos2) {
        val acqua = min(a[pos1],a[pos2])*(pos2-pos1)
        if(acqua > valoreMassimo) {
            valoreMassimo = acqua
            arrayPosizioni[0] = pos1
            arrayPosizioni[1] = pos2
            arrayPosizioni[2] = valoreMassimo
        }
        if(a[pos1] > a[pos2]) {
            pos2--
        } else {
            pos1++
        }
    }
    return arrayPosizioni
}