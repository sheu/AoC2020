import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day18Test {
    @Test
    fun testParsing() {
        val string = "4 + (1 + (8 * 2))"
        val d = Day18()
        assertEquals(26, "2 * 3 + (4 * 5)".evaluate())
        assertEquals(437, "5 + (8 * 3 + 9 + 3 * 4 * 3)".evaluate())
        assertEquals(12240, "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))".evaluate())
        assertEquals(13632, "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2".evaluate())
    }
}