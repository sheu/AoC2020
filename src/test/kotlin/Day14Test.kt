import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Day14Test {
    fun Long.to32bitString(): String =
        java.lang.Long.toBinaryString(this).padStart(36, '0')
    @Test
    fun testIntToBinaryString() {

        val input  = 11L
        assertEquals("000000000000000000000000000000001011", input.to32bitString())
        assertEquals("000000000000000000000000000001100101", 101L.to32bitString())
        assertEquals("000000000000000000000000000000000000", 0L.to32bitString())
    }

    @Test
    fun testSample() {
        val input = listOf("mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0")
        val d = Day14()

        assertEquals(165, d.part1(input))

    }

    @Test
    fun testSample2() {
        val input = listOf("mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1")
        val d = Day14()

        assertEquals(208, d.part2(input))

    }

    @Test
    fun testRegex() {
        println("mem[8]".split("\\[|\\]".toRegex()))
    }

}