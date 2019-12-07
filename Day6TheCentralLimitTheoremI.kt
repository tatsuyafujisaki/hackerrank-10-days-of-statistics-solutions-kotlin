import kotlin.math.absoluteValue
import kotlin.math.exp
import kotlin.math.sqrt

// Cumulative distribution function for the normal distribution
fun cdf(mean: Double, sd: Double, x: Double) = 0.5 * (1.0 + erf((x - mean) / (sd * sqrt(2.0))))

// Error function from Numerical Recipes 3rd Edition (p.265)
fun erf(x: Double): Double {
    val a0 = 1.26551223
    val a1 = 1.00002368
    val a2 = 0.37409196
    val a3 = 0.09678418
    val a4 = -0.18628806
    val a5 = 0.27886807
    val a6 = -1.13520398
    val a7 = 1.48851587
    val a8 = -0.82215223
    val a9 = 0.17087277
    val t = 2.0 / (2.0 + x.absoluteValue)
    (1 - t * exp(-x * x - a0 + t * (a1 + t * (a2 + t * (a3 + t * (a4 + t * (a5 + t * (a6 + t * (a7 + t * (a8 + t * a9)))))))))).let {
        return if (x >= 0) it else -it
    }
}

fun main() {
    val maxWeight = 9800.0
    val n = 49.0
    val mean = 205.0
    val standardDeviation = 15.0
    // https://faculty.math.illinois.edu/~hildebr/370/408clt.pdf
    println("%.4f".format(cdf(n * mean, sqrt(n) * standardDeviation, maxWeight)))
}
