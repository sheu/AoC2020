fun main() {
    val input = "13,x,x,x,x,x,x,37,x,x,x,x,x,401,x,x,x,x,x,x,x,x,x,x,x,x,x,17,x,x,x,x,19,x,x,x,23,x,x,x,x,x,29,x,613,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41"
    println(input.split(",").filter { it != "x" }.map { it.toInt() }.map { ((1000340 / it) + 1) * it to it }
        .minByOrNull { it.first }.let { (it!!.first - 1000340) * it!!.second })

    val d = Day13()
    d.part2(input, 13L, 41L)
}
class Day13 {
    fun part2(input: String, firstId: Long, lastId: Long) {
        var searches  = 0L

        val listOfPairs = input.split(",").mapIndexed { i, s -> i to s }.filter { it.second != "x" }.map { it.first to it.second.toLong() }
        val maxDiff = listOfPairs.map {it.second}.max()!!
        var minlcm = 100000000000000L
        while( !listOfPairs.fits(minlcm) && minlcm in (0..Long.MAX_VALUE)) {
            minlcm += firstId
            if(searches % 100_000_000_000_000L == 0L) {
                println(searches)
            }

            if(searches % 100_000_000L == 0L) {
                println(searches)
            }
            searches++

        }
        println(minlcm)
    }

    fun lcm(number1: Long, number2: Long): Long {
        if (number1 == 0L || number2 == 0L) {
            return 0
        }
        val absNumber1 = Math.abs(number1)
        val absNumber2 = Math.abs(number2)
        val absHigherNumber = Math.max(absNumber1, absNumber2)
        val absLowerNumber = Math.min(absNumber1, absNumber2)
        var lcm = absHigherNumber
        while (lcm % absLowerNumber != 0L) {
            lcm += absHigherNumber
        }
        return lcm
    }

    fun List<Pair<Int, Long>>.fits(lcm: Long) : Boolean {
        for( p in this) {
            if((lcm + p.first) % p.second != 0L) {
                return false;
            }
        }
        return true
    }

}