import java.io.File
import java.lang.IllegalStateException

class Day09 {
    fun part1(input: List<String>) : Long{
        val numbers =  input.map {it.toLong()}
       var invalidNumber : Long = 0
        for( i in 25..numbers.lastIndex) {
            if(!numbers[i].isValid(numbers.subList(i-25,i))) {
                println("${numbers[i]}")
                invalidNumber = numbers[i]
            }
        }

        //part2
        var start = 0
        var end = 0
        while(end < numbers.lastIndex){
            val sublist = numbers.subList(start, end+1)
            val sumOfSublist = sublist.sum()
            when {
                sumOfSublist == invalidNumber -> {
                    println(sublist)
                    return sublist.minOrNull()!! + sublist.maxOrNull()!!
                    break
                }
                sumOfSublist < invalidNumber -> {
                    end++
                }
                else -> {
                    start++
                }
            }
        }
        throw IllegalStateException("Should never reach here")
    }

    private fun Long.isValid(numbers: List<Long>) : Boolean {
        for(i in 0..numbers.lastIndex){
            for(j in i+1..numbers.lastIndex) {
                if((numbers[i] + numbers[j]) == this) {
                    return true
                }
            }
        }
        return false
    }
}