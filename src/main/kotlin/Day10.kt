class Day10 {
    fun part1(input: List<String>) : Long  {
        val temp =  listOf(0) + input.map { it.trim().toInt() }.sorted()
        val max  = temp.max()!! + 3
        val adaptersJoltage = temp + listOf(max)
        println(adaptersJoltage)
        val mapOfDiff = adaptersJoltage.fold(mapOf("P" to 0, "1" to 0, "3" to 0)){ acc, i -> acc.determineAndAdd(i)  }
        println(mapOfDiff)
        return mapOfDiff["1"]!!.toLong() * mapOfDiff["3"]!!.toLong()


    }

    fun part2(input: List<String>) : Long  {
        val temp =  listOf(0) + input.map { it.trim().toInt() }.sorted()
        val max  = temp.max()!! + 3
        val adaptersJoltage = temp + listOf(max)
        println(adaptersJoltage)
       return adaptersJoltage
           .fold(listOf(listOf<Int>())){ acc, i -> acc.addOrIgnore(i)  }
           .map { mapListLengthToCombination(it.size) }
           .filter{it > 1}
           .fold(1){acc, i -> acc * i }
    }

    private fun mapListLengthToCombination(num: Int) : Int {
        return when(num) {
            4 -> 4
            3 -> 2
            5 -> 7
            else -> 1
        }
    }

    private fun List<List<Int>>.addOrIgnore(num: Int) : List<List<Int>> {
        if (last().isNotEmpty()) {
            if(num - last().last() == 1) {
                return (dropLast(1) + listOf(last() +num) )
            }else if(num - last().last() == 3) {
                return (this + listOf(listOf(num)))
            }
        } else return (dropLast(1) + listOf(last()+num))
        return this
    }

    private fun Map<String, Int>.determineAndAdd(num: Int) :Map<String, Int> {
            val diff = num - this["P"]!!
            if(diff == 1) {
                return mapOf("P" to num,  "1" to this["1"]!!+1, "3" to this["3"]!!)
            } else if(diff == 3) {
                return mapOf("P" to num,  "1" to this["1"]!!, "3" to this["3"]!! + 1)
            }
          return this
    }
}

