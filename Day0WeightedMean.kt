fun readIntegers() = readLine().orEmpty().split(' ').map(String::toInt)

fun Collection<Int>.weightedMean(weights: Collection<Int>) = zip(weights).sumBy { it.first * it.second }.toDouble() / weights.sum()

fun main() {
    readLine() // Read and discard
    println("%.1f".format(readIntegers().weightedMean(readIntegers())))
}
