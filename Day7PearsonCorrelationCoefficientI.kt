import kotlin.math.pow
import kotlin.math.sqrt

fun readDoubles() = readLine().orEmpty().split(' ').filterNot(String::isEmpty).map(String::toDouble)

fun Collection<Double>.standardDeviation(): Double {
    val mean = average()
    return sqrt(sumByDouble { (it - mean).pow(2) } / size)
}

fun covariance(xs: Collection<Double>, ys: Collection<Double>): Double {
    val meanX = xs.average()
    val meanY = ys.average()
    return xs.zip(ys) { x, y -> (x - meanX) * (y - meanY) }.sum() / xs.size
}

fun correlationCoefficient(xs: Collection<Double>, ys: Collection<Double>) = covariance(xs, ys) / (xs.standardDeviation() * ys.standardDeviation())

fun main() {
    readLine() // Read and discard
    println("%.3f".format(correlationCoefficient(readDoubles(), readDoubles())))
}
