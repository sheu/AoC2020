import java.io.File

fun main() {

    val day9 = Day09()
    val inputForDay9 =File("src/main/resources/day09.txt")
        .bufferedReader().readLines()
    println("====================Day 09====================================")
    println(day9.part1(inputForDay9))
    println("====================The End!! Day 09==========================")
    val day10 = Day10()
    val input =File("src/main/resources/day10.txt")
    .bufferedReader().readLines()
    day10.part2(input)

}