import org.junit.jupiter.api.Test

class Day13Test {

    @Test
    fun test() {
        val input = "67,7,59,61"
        val startId = 67L
        val lastId =61L
        val d = Day13()
        d.part2(input, startId, lastId)
        println(d.lcm(1792L,1889))
    }
}