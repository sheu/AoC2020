import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12Test {

    @Test
    fun testPar1() {
        val input  = listOf("F10", "N3", "F7", "R90", "F11")
        val d = Day12()
        assertEquals(25, d.part1(input))
        assertEquals(286, d.part2(input))
    }
}