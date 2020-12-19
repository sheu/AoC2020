import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class Day16Test {

    @Test
    fun testRegex() {
        assertTrue("departure location: 36-363 or 377-962".contains("\\d+-\\d+ or \\d+-\\d+".toRegex()))
        assertFalse("your ticket:".contains("\\d+-\\d+ or \\d+-\\d+".toRegex()))

        val list = "(\\d+)-(\\d+) or (\\d+)-(\\d+)".toRegex().find("departure location: 36-363 or 377-962")?.destructured?.toList()
        println(list)
    }
    
    @Test
    fun testInput() {
        val input = listOf("class: 1-3 or 5-7",
                "row: 6-11 or 33-44",
                "seat: 13-40 or 45-50",
                "",
                "your ticket:",
                "7,1,14",
                "",
                "nearby tickets:",
                "7,3,47",
                "40,4,50",
                "55,2,20",
                "38,6,12")
        val d = Day16()
        d.part1(input)
    }
}