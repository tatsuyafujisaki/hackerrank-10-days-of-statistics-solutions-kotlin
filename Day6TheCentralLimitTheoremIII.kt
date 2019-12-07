import kotlin.math.sqrt

fun main() {
    val n = 100.0
    val mean = 500.0
    val standardDeviation = 80.0
    val z = 1.96 // Z score for two-sided 95% confidence interval
    val errorMargin = z * standardDeviation / sqrt(n) // https://en.wikipedia.org/wiki/Margin_of_error
    println("%.2f".format(mean - errorMargin))
    println("%.2f".format(mean + errorMargin))
}
