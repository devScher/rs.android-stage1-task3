package subtask6

data class Row(var count: Int, var parent: Row?, var value: Array<String> = arrayOf())

class FullBinaryTrees {
    fun stringForNodeCount(count: Int): String {
        if (1 > count) {
            return "[]"
        }
        if (0 == count % 2) {
            return "[]"
        }
        val root = Row(count - 1, null, arrayOf("0"))
        val children = getChildren(root)
        var result: Array<String> = arrayOf()
        for (child in children) {
            var row: Array<String> = arrayOf()
            var node: Row? = child
            while (null != node) {
                row = node.value + row
                node = node.parent
            }
            result += arrayOf("[" + row.joinToString(",") + "]")
        }
        return "[" + result.joinToString(" ") + "]"
    }

    private fun getChildren(parent: Row): Array<Row> {
        val count: Int = parent.count
        if (0 == count) {
            return arrayOf(Row(0, parent, arrayOf()))
        }
        val row = parent.value
        val size = row.size - 1
        var result: Array<Row> = arrayOf()
        for (i in 0..size) {
            if ("0" == row[i]) {
                if (result.isEmpty()) {
                    result += arrayOf(Row(count, parent)) + arrayOf(Row(count, parent))
                } else {
                    result = duplicateRowArray(result)
                }
                for (j in 0..(result.size / 2 - 1)) {
                    if (1 < result[j * 2].count) {
                        result[j * 2].value += arrayOf("0", "0")
                        result[j * 2].count -= 2
                        result[j * 2 + 1].value += arrayOf("null", "null")
                    }
                }
            }
        }
        var withChildren: Array<Row> = arrayOf()
        for (r in result) {
            if (2 > r.count) {
                if (r.value.isNotEmpty()) {
                    withChildren += r
                }
            } else {
                withChildren += getChildren(r)
            }
        }
        return withChildren
    }

    private fun duplicateRowArray(rowArray: Array<Row>): Array<Row> {
        var newArray: Array<Row> = arrayOf()
        for (row in rowArray) {
            newArray += row
            if (0 == row.count) {
                newArray += Row(row.count, row.parent, arrayOf())
            } else {
                newArray += Row(row.count, row.parent, row.value)
            }
        }
        return newArray
    }
}
