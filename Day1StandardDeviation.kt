import kotlin.math.pow
import kotlin.math.sqrt

fun List<Int>.standardDeviation(): Double {
    val mean = average()
    return sqrt(sumByDouble { (it - mean).pow(2) } / size)
}

fun main() {
    readLine() // Read and discard
    println("%.1f".format(readLine().orEmpty().split(' ').map(String::toInt).standardDeviation()))
}
