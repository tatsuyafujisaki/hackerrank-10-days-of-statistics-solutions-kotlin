import kotlin.math.pow

fun readDoubles() = readLine().orEmpty().split(' ').filterNot(String::isEmpty).map(String::toDouble)

fun spearman(xs: List<Double>, ys: List<Double>): Double {
    fun List<Double>.rank(): List<Int> {
        val sorted = sorted()
        return map { sorted.indexOf(it) + 1 }
    }
    val n = xs.size
    return 1 - (6 * xs.rank().zip(ys.rank()) { rankX, rankY -> (rankX - rankY).toDouble().pow(2) }.sum() / (n * (n * n - 1)))
}

fun main() {
    readLine() // Read and discard
    println("%.3f".format(spearman(readDoubles(), readDoubles())))
}
