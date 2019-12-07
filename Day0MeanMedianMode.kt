fun List<Int>.median(): Double {
    val i = size / 2
    return if (size % 2 == 0) (this[i - 1] + this[i]) / 2.0 else this[i].toDouble()
}

fun Collection<Int>.mode() = groupingBy { it }.eachCount().maxBy { it.value }?.key

fun main() {
    readLine() // Read and discard
    with(readLine().orEmpty().split(' ').map(String::toInt).sorted()) {
        println("%.1f".format(average()))
        println("%.1f".format(median()))
        println(mode())
    }
}
