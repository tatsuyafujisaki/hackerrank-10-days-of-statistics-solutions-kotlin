import kotlin.math.pow
import kotlin.math.sqrt

fun Collection<Int>.standardDeviation(): Double {
    val mean = average()
    return sqrt(sumByDouble { (it - mean).pow(2) } / size)
}

fun covariance(xs: Collection<Int>, ys: Collection<Int>): Double {
    val meanX = xs.average()
    val meanY = ys.average()
    return xs.zip(ys) { x, y -> (x - meanX) * (y - meanY) }.sum() / xs.size
}

fun correlationCoefficient(xs: Collection<Int>, ys: Collection<Int>) = covariance(xs, ys) / (xs.standardDeviation() * ys.standardDeviation())

fun main() {
    val xs = listOf(95, 85, 80, 70, 60)
    val ys = listOf(85, 95, 70, 65, 70)
    val b = correlationCoefficient(xs, ys) * ys.standardDeviation() / xs.standardDeviation()
    val a = ys.average() - b * xs.average()
    println("%.3f".format(a + b * 80))
}
