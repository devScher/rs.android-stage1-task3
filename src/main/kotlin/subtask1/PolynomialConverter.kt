package subtask1

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        val size = numbers.size
        if( 0 == size ){
            return null
        }
        var result: String? = ""
        numbers.withIndex()
            .forEach{
                if (0 != it.value) {
                    result = result + if( 0 < it.value ) {
                        if( 0 < it.index )
                            " + "
                        else
                            ""
                    } else {
                        " - "
                    } + if( 1 == Math.abs( it.value ) ) {
                        ""
                    } else {
                        Math.abs( it.value ).toString()
                    } + when ( size - 1 - it.index ) {
                        0 -> ""
                        1 -> "x"
                        else -> "x^" + (size - 1 - it.index ).toString()
                    }
                }
            }
        return result
    }
}
