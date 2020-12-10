import java.io.File

fun main(args: Array<String>) {
    val day10 = Day10()
    val input =File("src/main/resources/joltage.txt")
    .bufferedReader().readLines()
    day10.part2(input)
}