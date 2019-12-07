fun List<Int>.median(): Int {
    val i = size / 2
    return if (size % 2 == 0) (this[i - 1] + this[i]) / 2 else this[i]
}

fun Collection<Int>.firstQuartile() = take(size / 2).median()

fun List<Int>.thirdQuartile() = takeLast(size / 2).median()

fun main() {
    readLine() // Read and discard
    with(readLine().orEmpty().split(' ').map(String::toInt).sorted()) {
        println(firstQuartile())
        println(median())
        println(thirdQuartile())
    }
}
