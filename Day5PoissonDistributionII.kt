import kotlin.math.pow

/**
 * E\[X] in the Poisson distribution = [mean] (average number of successes)
 * Var(X) in the Poisson distribution = [mean] (actual number of successes)
 *
 * Var(X) = E[X^2] - E\[X]^2
 * -> E[X^2] = Var(X) + E\[X]^2 = [mean] + [mean]^2
 */
fun squaredPoissonProbability(mean: Double) = mean + mean.pow(2)

fun main() {
    val meanA = 0.88
    val meanB = 1.55
    println("%.3f".format(160 + 40 * squaredPoissonProbability(meanA)))
    println("%.3f".format(128 + 40 * squaredPoissonProbability(meanB)))
}
