import com.ginsberg.cirkle.circular
import java.io.File
import java.lang.RuntimeException
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    val input = File("src/main/resources/day12.txt").bufferedReader().readLines()
    val d = Day12()
    println(d.part1(input))
    println(d.part2(input))
}

class Day12 {
    fun part1(instructions: List<String>) : Int {

        val finalPos = instructions.fold(Pair<String,Pair<Int, Int>>("east",Pair(0, 0))) {acc, s -> acc.nextPosition(s) }
        return abs(finalPos.second.first) + abs(finalPos.second.second)

    }

    fun part2(instructions: List<String>) : Int {

        val finalPos = instructions.fold(Pair(Pair(0,0),Pair(10,1))) {acc, s -> acc.nextPosition2(s) }
        return abs(finalPos.first.first) + abs(finalPos.first.second)

    }



    fun Pair<String, Pair<Int, Int>>.nextPosition(instruction: String): Pair<String, Pair<Int, Int>> {
        val instValue = instruction.substring(1).toInt()
        when (instruction[0]) {
            'F' -> {
                return when (first) {
                    "east" -> Pair(first, Pair(second.first + instValue, second.second))
                    "west" -> Pair(first, Pair(second.first - instValue, second.second))
                    "north" -> Pair(first, Pair(second.first, second.second + instValue))
                    else -> Pair(first, Pair(second.first, second.second - instValue))
                }

            }
            'N' -> {
                return Pair(first, Pair(second.first, second.second + instValue))
            }
            'S' -> {
                return Pair(first, Pair(second.first, second.second - instValue))
            }
            'E' -> {
                return Pair(first, Pair(second.first + instValue, second.second))
            }
            'W' -> {
                return Pair(first, Pair(second.first - instValue, second.second))
            }
            'L' -> {
                val currentIndex = ROTATION.indexOf(first) + (instValue / 90)
                return Pair(ROTATION[currentIndex], Pair(second.first, second.second))
            }
            'R' -> {
                val currentIndex = ROTATION.indexOf(first) - (instValue / 90)
                return Pair(ROTATION[currentIndex], Pair(second.first, second.second))
            }
            else -> return this
        }
    }

    fun Pair<Pair<Int, Int>, Pair<Int, Int>>.nextPosition2(instruction: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        val instValue = instruction.substring(1).toInt()
        when (instruction[0]) {
            'F' -> {
                return Pair(
                    Pair(first.first + second.first * instValue, first.second + second.second * instValue),
                    second
                )
            }
            'N' -> {
                return Pair(first, Pair(second.first, second.second + instValue))
            }
            'S' -> {
                return Pair(first, Pair(second.first, second.second - instValue))
            }
            'E' -> {
                return Pair(first, Pair(second.first + instValue, second.second))
            }
            'W' -> {
                return Pair(first, Pair(second.first - instValue, second.second))
            }
            'L' -> {
                return Pair(first, second.rotate(instValue))
            }
            'R' -> {
                return Pair(first, second.rotate(instValue * -1))
            }
            else -> throw RuntimeException("I have no idea what happened")
        }
    }

    companion object {
        val ROTATION = listOf("east", "north", "west", "south").circular()
    }

    fun Pair<Int, Int>.rotate(degrees: Int) :Pair<Int, Int>{
        val radians = degrees.toDouble() * (PI/180)
        val x = first*cos(radians).toInt() - second * sin(radians).toInt()
        val y = first*sin(radians).toInt() - second * cos(radians).toInt()
        return Pair(x, y)
    }

    fun multiplyMatrix(a: Array<Array<Int>>, b: Array<Array<Int>>) : Array<Array<Int>>{
        val result = Array(a.size){Array(b[0].size){0} }
        for( i in result.indices) {
            for (j in result[i].indices ) {
                for(k in a[0].indices) {
                    result[i][j] = a[i][k] * b[k][j]
                }
            }
        }
        return result;
    }

}