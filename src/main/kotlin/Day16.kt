import java.io.File

fun main() {
    val input = File("src/main/resources/day16.txt").bufferedReader().readLines()
    val d = Day16()
    println(d.part1(input))
}

class Day16 {
    fun part1(input: List<String>) : Int{
        val rangeRegex = "(\\d+)-(\\d+) or (\\d+)-(\\d+)".toRegex()
        val rulesRanges = input.filter { it.contains("\\d+-\\d+ or \\d+-\\d".toRegex()) }.map {rangeRegex.find(it)!!.destructured.toList() }
            .map { listOf(it[0].toInt() to it[1].toInt(), it[2].toInt() to it[3].toInt()) }.flatten()
        val otherTickets = input.filter { it.contains("\\d+,\\d+".toRegex())}.map {it.split(",").map { s -> s.trim().toInt() }}.drop(1)
        val invalidEntries = otherTickets.fold(listOf<Int>()) { acc, list ->  acc+list.validate(rulesRanges)}
        println(invalidEntries)
        return invalidEntries.sum()

    }

    fun part2(input: List<String>) : Int{
        val rangeRegex = "(\\d+)-(\\d+) or (\\d+)-(\\d+)".toRegex()
        val rulesRanges = input.filter { it.contains("\\d+-\\d+ or \\d+-\\d".toRegex()) }.map {rangeRegex.find(it)!!.destructured.toList() }
            .map { listOf(it[0].toInt() to it[1].toInt(), it[2].toInt() to it[3].toInt()) }.flatten()
        val otherTickets = input.filter { it.contains("\\d+,\\d+".toRegex())}.map {it.split(",").map { s -> s.trim().toInt() }}.drop(1)
        val invalidEntries = otherTickets.fold(listOf<Int>()) { acc, list ->  acc+list.validate(rulesRanges)}
        println(invalidEntries)
        return invalidEntries.sum()

    }

    fun List<Int>.validate(rulesRanges: List<Pair<Int, Int>>) :List<Int> {
        println(rulesRanges)
        println(this)
        return this.fold(listOf()) { acc: List<Int>, i: Int -> acc + if(i.inRange(rulesRanges)) 0 else i }.filter { it != 0 }
    }


}

private fun Int.inRange(rulesRanges: List<Pair<Int, Int>>): Boolean {
     for (i in rulesRanges) {
         if( this in i.first..i.second) {
             return true
         }
     }
    return false
}
