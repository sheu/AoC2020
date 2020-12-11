import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11Test {
    @Test
    fun testRound1() {
        val input = listOf(
            "L.LL.LL.LL".toCharArray().toList(),
            "LLLLLLL.LL".toCharArray().toList(),
            "L.L.L..L..".toCharArray().toList(),
            "LLLL.LL.LL".toCharArray().toList(),
            "L.LL.LL.LL".toCharArray().toList(),
            "L.LLLLL.LL".toCharArray().toList(),
            "..L.L.....".toCharArray().toList(),
            "LLLLLLLLLL".toCharArray().toList(),
            "L.LLLLLL.L".toCharArray().toList(),
            "L.LLLLL.LL".toCharArray().toList()
        )
        val output = listOf(
                "#.##.##.##".toCharArray().toList(),
                "#######.##".toCharArray().toList(),
                "#.#.#..#..".toCharArray().toList(),
                "####.##.##".toCharArray().toList(),
                "#.##.##.##".toCharArray().toList(),
                "#.#####.##".toCharArray().toList(),
                "..#.#.....".toCharArray().toList(),
                "##########".toCharArray().toList(),
                "#.######.#".toCharArray().toList(),
                "#.#####.##".toCharArray().toList())

        assertEquals(output, Day11().part1(input))
        assertEquals(71, Day11().countOccupiedSeats(output))
        assertEquals(0,Day11().countOccupiedSeats(listOf(
            "L.LL.LL.LL".toCharArray().toList(),
            "LLLLLLL.LL".toCharArray().toList())))
    }

    @Test
    fun testRound2() {
        val input = listOf(
            "#.##.##.##".toCharArray().toList(),
            "#######.##".toCharArray().toList(),
            "#.#.#..#..".toCharArray().toList(),
            "####.##.##".toCharArray().toList(),
            "#.##.##.##".toCharArray().toList(),
            "#.#####.##".toCharArray().toList(),
            "..#.#.....".toCharArray().toList(),
            "##########".toCharArray().toList(),
            "#.######.#".toCharArray().toList(),
            "#.#####.##".toCharArray().toList())

        val output = listOf(
            "#.LL.LL.L#".toCharArray().toList(),
            "#LLLLLL.LL".toCharArray().toList(),
            "L.L.L..L..".toCharArray().toList(),
            "LLLL.LL.LL".toCharArray().toList(),
            "L.LL.LL.LL".toCharArray().toList(),
            "L.LLLLL.LL".toCharArray().toList(),
            "..L.L.....".toCharArray().toList(),
            "LLLLLLLLL#".toCharArray().toList(),
            "#.LLLLLL.L".toCharArray().toList(),
            "#.LLLLL.L#".toCharArray().toList())

        assertEquals(output, Day11().part1(input))
    }
    @Test
    fun testRound3() {
        val d = Day11()
        val input = listOf(
            "#.LL.LL.L#".toCharArray().toList(),
            "#LLLLLL.LL".toCharArray().toList(),
            "L.L.L..L..".toCharArray().toList(),
            "LLLL.LL.LL".toCharArray().toList(),
            "L.LL.LL.LL".toCharArray().toList(),
            "L.LLLLL.LL".toCharArray().toList(),
            "..L.L.....".toCharArray().toList(),
            "LLLLLLLLL#".toCharArray().toList(),
            "#.LLLLLL.L".toCharArray().toList(),
            "#.LLLLL.L#".toCharArray().toList())
        println(d.determineViewMap(0,2, input))

        val output = listOf(
            "#.L#.##.L#".toCharArray().toList(),
            "#L#####.LL".toCharArray().toList(),
            "L.#.#..#..".toCharArray().toList(),
            "##L#.##.##".toCharArray().toList(),
            "#.##.#L.##".toCharArray().toList(),
            "#.#####.#L".toCharArray().toList(),
            "..#.#.....".toCharArray().toList(),
            "LLL####LL#".toCharArray().toList(),
            "#.L#####.L".toCharArray().toList(),
            "#.L####.L#".toCharArray().toList())

        assertEquals(output, d.part1(input))
    }

    @Test
    fun testRound4() {
        val input = listOf(
            "#.L#.##.L#".toCharArray().toList(),
            "#L#####.LL".toCharArray().toList(),
            "L.#.#..#..".toCharArray().toList(),
            "##L#.##.##".toCharArray().toList(),
            "#.##.#L.##".toCharArray().toList(),
            "#.#####.#L".toCharArray().toList(),
            "..#.#.....".toCharArray().toList(),
            "LLL####LL#".toCharArray().toList(),
            "#.L#####.L".toCharArray().toList(),
            "#.L####.L#".toCharArray().toList())

        val output = listOf(
            "#.L#.L#.L#".toCharArray().toList(),
            "#LLLLLL.LL".toCharArray().toList(),
            "L.L.L..#..".toCharArray().toList(),
            "##LL.LL.L#".toCharArray().toList(),
            "L.LL.LL.L#".toCharArray().toList(),
            "#.LLLLL.LL".toCharArray().toList(),
            "..L.L.....".toCharArray().toList(),
            "LLLLLLLLL#".toCharArray().toList(),
            "#.LLLLL#.L".toCharArray().toList(),
            "#.L#LL#.L#".toCharArray().toList())

        assertEquals(output, Day11().part1(input))
    }
@Test
    fun testRound5() {
        val input = listOf(
            "#.L#.L#.L#".toCharArray().toList(),
            "#LLLLLL.LL".toCharArray().toList(),
            "L.L.L..#..".toCharArray().toList(),
            "##LL.LL.L#".toCharArray().toList(),
            "L.LL.LL.L#".toCharArray().toList(),
            "#.LLLLL.LL".toCharArray().toList(),
            "..L.L.....".toCharArray().toList(),
            "LLLLLLLLL#".toCharArray().toList(),
            "#.LLLLL#.L".toCharArray().toList(),
            "#.L#LL#.L#".toCharArray().toList())

        val output = listOf(
            "#.L#.L#.L#".toCharArray().toList(),
            "#LLLLLL.LL".toCharArray().toList(),
            "L.L.L..#..".toCharArray().toList(),
            "##L#.#L.L#".toCharArray().toList(),
            "L.L#.#L.L#".toCharArray().toList(),
            "#.L####.LL".toCharArray().toList(),
            "..#.#.....".toCharArray().toList(),
            "LLL###LLL#".toCharArray().toList(),
            "#.LLLLL#.L".toCharArray().toList(),
            "#.L#LL#.L#".toCharArray().toList())

        assertEquals(output, Day11().part1(input))
        assertEquals(31, Day11().countOccupiedSeats(output))
    }

    @Test
    fun testUp() {
        val input = listOf(
            "#.L#.L#.L#".toCharArray().toList(),
            "#LLLLLL.LL".toCharArray().toList(),
            "L.L.L..#..".toCharArray().toList(),
            "##L#.#L.L#".toCharArray().toList(),
            "L.L#.#L.L#".toCharArray().toList(),
            "#.L####.LL".toCharArray().toList(),
            "..#.#.....".toCharArray().toList(),
            "LLL###LLL#".toCharArray().toList(),
            "#.LLLLL#.L".toCharArray().toList(),
            "#.L#LL#.L#".toCharArray().toList())
        val d = Day11()

        assertEquals(26, d.countOccupiedSeats(d.part1(input)))
    }

}