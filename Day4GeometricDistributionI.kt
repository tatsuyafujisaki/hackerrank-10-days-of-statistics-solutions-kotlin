import kotlin.math.pow

fun main() {
    val defectProbability = readLine().orEmpty().split(' ').map(String::toDouble).zipWithNext { x, y -> x / y }.first()
    println("%.3f".format((1 - defectProbability).pow(readLine().orEmpty().toInt() - 1) * defectProbability))
}
