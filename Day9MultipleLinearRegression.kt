fun create2dArray(rowCount: Int, columnCount: Int) = Array(rowCount) { DoubleArray(columnCount) }
fun Array<DoubleArray>.rowCount() = size
fun Array<DoubleArray>.columnCount() = first().size

fun Array<DoubleArray>.transpose(): Array<DoubleArray> {
    val transposed = create2dArray(columnCount(), rowCount())
    for (i in indices) {
        for (j in first().indices) {
            transposed[j][i] = this[i][j]
        }
    }
    return transposed
}

fun Array<DoubleArray>.subMatrix(rowToExclude: Int, columnToExclude: Int): Array<DoubleArray> {
    val subMatrix = create2dArray(rowCount() - 1, columnCount() - 1)
    var subMatrixRow = 0
    for (matrixRow in indices) {
        if (matrixRow == rowToExclude) continue
        var subMatrixColumn = 0
        for (matrixColumn in first().indices) {
            if (matrixColumn == columnToExclude) continue
            subMatrix[subMatrixRow][subMatrixColumn] = this[matrixRow][matrixColumn]
            subMatrixColumn++
        }
        subMatrixRow++
    }
    return subMatrix
}

fun Array<DoubleArray>.multiply(x: Double): Array<DoubleArray> {
    for (row in indices) {
        for (column in first().indices) {
            this[row][column] = x * this[row][column]
        }
    }
    return this
}

fun Array<DoubleArray>.multiply(matrix: Array<DoubleArray>): Array<DoubleArray> {
    require(columnCount() == matrix.rowCount())
    val result = create2dArray(size, matrix.columnCount())
    for (i in indices) {
        for (j in matrix.first().indices) {
            for (k in first().indices) {
                result[i][j] += this[i][k] * matrix[k][j]
            }
        }
    }
    return result
}

fun Array<DoubleArray>.inverse(): Array<DoubleArray> {
    fun Array<DoubleArray>.determinant(): Double {
        fun Array<DoubleArray>.isSquareMatrix() = rowCount() == columnCount()
        require(isSquareMatrix())
        return when (val n = rowCount()) {
            1 -> this[0][0]
            2 -> this[0][0] * this[1][1] - this[0][1] * this[1][0]
            else -> {
                var sum = 0.0
                for (column in 0 until n) {
                    sum += (if (column % 2 == 0) 1 else -1) * this[0][column] * subMatrix(0, column).determinant()
                }
                sum
            }
        }
    }

    fun Array<DoubleArray>.cofactor(): Array<DoubleArray> {
        val cofactorMatrix = create2dArray(rowCount(), columnCount())
        for (row in indices) {
            for (column in first().indices) {
                cofactorMatrix[row][column] = (if ((row + column) % 2 == 0) 1 else -1) * subMatrix(row, column).determinant()
            }
        }
        return cofactorMatrix
    }
    return cofactor().transpose().multiply(1 / determinant())
}

fun main() {
    val (m, n) = readLine().orEmpty().split(' ').map(String::toInt)
    val ab1 = create2dArray(n, m + 1) // a and b1
    val b2 = create2dArray(n, 1)
    for (row in 0 until n) {
        ab1[row][0] = 1.0
        with(readLine().orEmpty().split(' ').map(String::toDouble)) {
            dropLast(1).forEachIndexed { column, b1 ->
                ab1[row][column + 1] = b1
            }
            b2[row][0] = last()
        }
    }
    val ab1b2 = ab1.transpose().multiply(ab1).inverse().multiply(ab1.transpose()).multiply(b2) // a, b1, and b2
    repeat(readLine().orEmpty().toInt()) {
        val features = create2dArray(1, m + 1)
        features[0][0] = 1.0
        readLine().orEmpty().split(' ').map(String::toDouble).forEachIndexed { column, feature ->
            features[0][column + 1] = feature
        }
        println("%.2f".format(features.multiply(ab1b2)[0][0]))
    }
}
