import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day10Test {

    @Test
    fun testPart1() {
        val shortInput = listOf("16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4")
        val day10 = Day10()
        assertEquals(35L, day10.part1(shortInput))
        val mediumInput = listOf("28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45", "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3")
        assertEquals(220L, day10.part1(mediumInput))
    }


    @Test
    fun testPart2() {
        val shortInput = listOf("16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4")
        val day10 = Day10()
        assertEquals(8L, day10.part2(shortInput))
        val mediumInput = listOf("28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45", "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3")
        assertEquals(19208L, day10.part2(mediumInput))
    }
}