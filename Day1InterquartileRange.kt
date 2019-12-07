fun readIntegers() = readLine().orEmpty().split(' ').map(String::toInt)

fun List<Int>.median(): Double {
    val i = size / 2
    return if (size % 2 == 0) (this[i - 1] + this[i]) / 2.0 else this[i].toDouble()
}

fun Collection<Int>.firstQuartile() = take(size / 2).median()

fun List<Int>.thirdQuartile() = takeLast(size / 2).median()

fun List<Int>.interquartileRange() = thirdQuartile() - firstQuartile()

fun main() {
    readLine() // Read and discard
    println(readIntegers().zip(readIntegers()) { element, frequency -> MutableList(frequency) { element } }.flatten().sorted().interquartileRange())
}
