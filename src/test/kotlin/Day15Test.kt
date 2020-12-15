import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day15Test {

    @Test
    fun test132() {
        val startMap = mapOf(1 to 1, 3 to 2, 2 to 3)
        val i = 3
        val last = 2
        val d = Day15()
        assertEquals(1, d.part1(startMap, i, last, 2020))
    }
    @Test
    fun test213() {
        val startMap = mapOf(2 to 1, 1 to 2)
        val i = 3
        val last = 3
        val d = Day15()
        assertEquals(10, d.part1(startMap, i, last, 2020))
    }

    @Test
    fun test123() {
        val startMap = mapOf(1 to 1, 2 to 2)
        val i = 3
        val next = 3
        val d = Day15()
        assertEquals(27, d.part1(startMap, i, next, 2020))
    }

    @Test
    fun tes231() {
        val startMap = mapOf(2 to 1, 3 to 2)
        val i = 3
        val next = 1
        val d = Day15()
        assertEquals(78, d.part1(startMap, i, next, 2020))
    }
    @Test
    fun test321() {
        val startMap = mapOf(3 to 1, 2 to 2)
        val i = 3
        val next = 1
        val d = Day15()
        assertEquals(438, d.part1(startMap, i, next, 2020))
    }

    @Test
    fun test312() {
        val startMap = mapOf(3 to 1, 1 to 2)
        val i = 3
        val next = 2
        val d = Day15()
        assertEquals(362, d.part1(startMap, i, next, 30000000))
    }

    @Test
    fun test036() {
        val startMap = mapOf(0 to 1, 3 to 2)
        val i = 3
        val next = 6
        val d = Day15()
        assertEquals(175594, d.part1(startMap, i, next, 30000000))
    }

    @Test
    fun final() {
        val startMap = mapOf(11 to 1, 0 to 2, 1 to 3, 10 to 4, 5 to 5)
        val i = 6
        val next = 19
        val d = Day15()
        println(d.part1(startMap, i, next, 30000000))
    }


}