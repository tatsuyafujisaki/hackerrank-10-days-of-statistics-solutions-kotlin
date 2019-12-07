import kotlin.math.pow

fun Int.factorial() = if (this <= 1) 1 else (2..this).reduce(Int::times)
fun nPr(n: Int, r: Int) = n.factorial().toDouble() / (n - r).factorial()
fun nCr(n: Int, r: Int) = nPr(n, r) / r.factorial()
fun binomialProbability(p: Double, n: Int, k: Int) = nCr(n, k) * p.pow(k) * (1 - p).pow(n - k)
fun cumulativeBinomialProbability(p: Double, n: Int, ks: IntRange) = ks.sumByDouble { binomialProbability(p, n, it) }

fun main() {
    val boyProbability = 1.09 / (1.09 + 1)
    val children = 6
    val boys = 3
    println("%.3f".format(cumulativeBinomialProbability(boyProbability, children, boys..children)))
}
