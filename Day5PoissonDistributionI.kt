import kotlin.math.E
import kotlin.math.pow

fun Int.factorial() = if (this <= 1) 1 else (2..this).reduce(Int::times)
fun poissonProbability(mean: Double, k: Int) = mean.pow(k) * E.pow(-mean) / k.factorial()

fun main() {
    println("%.3f".format(poissonProbability(readLine().orEmpty().toDouble(), readLine().orEmpty().toInt())))
}
