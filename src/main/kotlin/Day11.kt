import java.io.File

fun main() {
    println("======================Day 11=========================================================")
    val day11 = Day11()
    val input11 =
        File("src/main/resources/day11.txt").bufferedReader().readLines().map { it.toCharArray().toList() }
    var b = day11.part1(input11)
    var a = input11
    while (a != b) {
        println(day11.countOccupiedSeats(b))
        a = b
        b = day11.part1(b)
    }
    val count = day11.countOccupiedSeats(b)
    println(count)
    println("============================End of Day 11===============================================")
}
class Day11 {


    fun countOccupiedSeats(input: List<List<Char>>) : Int {
       return input.flatten().count {it == '#'}
    }

    fun part1(input: List<List<Char>>): List<List<Char>> {

        val output = input.toListOfCharArray()
        for (i in input.indices) {
            for (j in input[i].indices) {
                if (input[i][j] != '.') {
                    val viewMap = determineViewMap(i, j, input)
                    val newStatus = determineStatus(input[i][j], viewMap)
                    output[i][j] = newStatus
                    //println(output.toListOfList())
                }
            }
        }
        return output.toListOfList()
    }

    fun determineViewMap(row: Int, col: Int, board: List<List<Char>>): Map<String, List<Char>> {
       return mapOf("up" to up(row, col, board),
           "down" to down(row, col, board),
           "left" to left(row, col, board),
           "right" to right(row, col, board),
           "upLeft" to upLeft(row, col, board),
           "upRight" to upRight(row, col, board),
           "downRight" to downRight(row, col, board),
           "downLeft" to downLeft(row, col, board),
       )

    }

    private fun determineStatus(currentStatus: Char, adjacentStatuses: Map<String, List<Char>>): Char {
        return if (currentStatus == 'L' && adjacentStatuses.canSit()) {
            '#'
        } else if (currentStatus == '#' && adjacentStatuses.canLeave()) {
            'L'
        } else {
            currentStatus
        }
    }

    private fun Map<String, List<Char>>.canSit() : Boolean {
        return filter { it.value.isNotEmpty()  && it.value.first() != 'L'}.isEmpty()
    }
    private fun Map<String, List<Char>>.canLeave() : Boolean {
        return filter { it.value.isNotEmpty()  && it.value.first() == '#'}.size >= 5
    }

     fun List<List<Char>>.toListOfCharArray() :List<CharArray>  =  fold(listOf()) { acc, list -> acc + listOf(list.toCharArray())  }
     fun List<CharArray>.toListOfList() :List<List<Char>>  =  fold(listOf()) {acc, arr -> acc + listOf(arr.toList())  }

    fun up(r: Int, c: Int, b: List<List<Char>>): List<Char> {
        return generateSequence(Pair(r, c)) { it.first - 1 to it.second }
            .takeWhile { it.first in b.indices }.map { b[it.first][it.second] }.toList().drop(1).filter { it != '.' }
    }

    fun down(r: Int, c: Int, b: List<List<Char>>): List<Char> {
        return generateSequence(Pair(r, c)) { it.first + 1 to it.second }
            .takeWhile { it.first in b.indices }.map { b[it.first][it.second] }.toList().drop(1).filter { it != '.' }
    }

    fun left(r: Int, c: Int, b: List<List<Char>>): List<Char> {
       // println("$r and $c ${b[c].lastIndex} ${b[r][c]} ")
        return generateSequence(Pair(r, c)) { it.first to it.second - 1 }
            .takeWhile { it.second in b[r].indices }.map { b[it.first][it.second] }.toList().drop(1)
            .filter { it != '.' }
    }

    fun right(r: Int, c: Int, b: List<List<Char>>): List<Char> {
        return generateSequence(Pair(r, c)) { it.first to it.second + 1 }
            .takeWhile { it.second in b[r].indices }.map { b[it.first][it.second] }.toList().drop(1)
            .filter { it != '.' }
    }

    fun upLeft(r: Int, c: Int, b: List<List<Char>>): List<Char> {
        return generateSequence(Pair(r, c)) { it.first - 1 to it.second - 1 }
            .takeWhile { it.second in b[r].indices && it.first in b.indices }.map { b[it.first][it.second] }.toList()
            .drop(1).filter { it != '.' }
    }

    fun upRight(r: Int, c: Int, b: List<List<Char>>): List<Char> =
        generateSequence(Pair(r, c)) { it.first - 1 to it.second + 1 }
            .takeWhile { it.second in b[r].indices && it.first in b.indices }.map { b[it.first][it.second] }.toList()
            .drop(1).filter { it != '.' }


    fun downRight(r: Int, c: Int, b: List<List<Char>>): List<Char> =
        generateSequence(Pair(r, c)) { it.first + 1 to it.second + 1 }
            .takeWhile { it.second in b[r].indices && it.first in b.indices }.map { b[it.first][it.second] }.toList()
            .drop(1).filter { it != '.' }

    fun downLeft(r: Int, c: Int, b: List<List<Char>>): List<Char> =
        generateSequence(Pair(r, c)) { it.first + 1 to it.second - 1 }
            .takeWhile { it.second in b[r].indices && it.first in b.indices }.map { b[it.first][it.second] }.toList()
            .drop(1).filter { it != '.' }
}