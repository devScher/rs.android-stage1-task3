package subtask2

class Combinator {
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]

        for (x in 0..n) {
            if (factorial(x) * factorial(n - x) == factorial(n) / m) {
                return x
            }
        }
        return null
    }

    private fun factorial(num: Int): Long {
        return if (num >= 1) {
            num * factorial(num - 1)
        } else {
            1
        }
    }
}
