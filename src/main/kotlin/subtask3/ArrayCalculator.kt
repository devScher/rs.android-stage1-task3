package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val integers: Array<Int> = itemsFromArray.filterIsInstance<Int>().toTypedArray()
        if( 0 == integers.size ){
            return 0
        }
        integers.sortByDescending { Math.abs(it) }
        var result = 1
        var lastNegative = 0
        var lastPositive = 0
        for(i in 1..(integers.size)) {
            val it = integers[i-1]
            if( i > numberOfItems ) {
                if( 0 > result ) {
                    var nextPositive = 0
                    var nextNegative = 0
                    for(j in i..(integers.size)) {
                        val nextNumber = integers[j - 1]
                        if( 0 > nextNumber ) {
                            if( 0 == nextNegative ) {
                                nextNegative = nextNumber
                            }
                        } else {
                            if( 0 == nextPositive ) {
                                nextPositive = nextNumber
                            }
                        }
                    }
                    if( lastPositive * nextPositive > lastNegative * nextNegative ) {
                        result = result / lastNegative * nextPositive
                    } else {
                        result = result / lastPositive * nextNegative
                    }
                }
                return result
            }
            if( 0 > it) {
                lastNegative = it
            } else {
                lastPositive = it
            }
            result *= it
        }
        return result
    }
}
