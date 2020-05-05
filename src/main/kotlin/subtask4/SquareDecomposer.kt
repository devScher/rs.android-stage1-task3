package subtask4

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decomposeValue(number * number, number - 1)
    }

    private fun decomposeValue(value: Int, start: Int): Array<Int>? {
        for( i in start downTo 1 ) {
            val square = i * i
            val residue = value - square
            if(residue == 0) {
                return arrayOf(i)
            }
            if(residue < 0) {
                return null
            }
            var sqrt = sqrt(residue.toDouble()).toInt()
            if(sqrt >= i) {
                sqrt = i - 1
            }
            val decomposed = decomposeValue(residue, sqrt)
            if( decomposed != null) {
                return decomposed + arrayOf(i)
            }
        }
        return null
    }
}
