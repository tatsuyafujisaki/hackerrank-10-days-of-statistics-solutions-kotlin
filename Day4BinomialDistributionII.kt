import kotlin.math.pow

fun Int.factorial() = if (this <= 1) 1 else (2..this).reduce(Int::times)
fun nPr(n: Int, r: Int) = n.factorial().toDouble() / (n - r).factorial()
fun nCr(n: Int, r: Int) = nPr(n, r) / r.factorial()
fun binomialProbability(n: Int, r: Int, p: Double) = nCr(n, r) * p.pow(r) * (1 - p).pow(n - r)
fun cumulativeBinomialProbability(n: Int, rs: IntRange, p: Double) = rs.sumByDouble { binomialProbability(n, it, p) }

fun main() {
    val rejectionProbability = 0.12
    val pistons = 10
    println("%.3f".format(cumulativeBinomialProbability(pistons, 0..2, rejectionProbability)))
    println("%.3f".format(cumulativeBinomialProbability(pistons, 2..pistons, rejectionProbability)))
}
