import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var len = 0
        var answer = 0
        val llist = mutableListOf<Int>()
        val rlist = mutableListOf<Int>()

        for (line in input) {
            val values = line.split("   ").map(String::toInt)

            llist.add(values[0])
            rlist.add(values[1])
            len++
        }

        llist.sort()
        rlist.sort()

        for (i in 0..<len)
            answer += abs(llist[i] - rlist[i])
        
        return answer
    }

    fun part2(input: List<String>): Int {
        var len = 0
        var answer = 0
        val llist = mutableListOf<Int>()
        val rmap = mutableMapOf<Int, Int>()

        for (line in input) {
            val values = line.split("   ").map(String::toInt)

            llist.add(values[0])
            rmap.compute(values[1]) { _, v ->
                (v ?: 0) + 1
            }
            len++
        }

        for (i in 0..<len)
            answer += (rmap[llist[i]] ?: 0) * llist[i]
        
        return answer
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
