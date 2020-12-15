fun main() {

}

class Day15 {
    fun part1(startMap: Map<Int, Int>, i: Int, last: Int, max: Int) : Int {
        var currentIndex = i
        val indexToValueMap = startMap.toMutableMap()
        var lastValue = last
        var runningCurrent = 0
        while( currentIndex <= max ) {
            val currentValue = lastValue
            lastValue = if(indexToValueMap[lastValue] != null)  currentIndex - indexToValueMap[lastValue]!!   else 0
            indexToValueMap[currentValue] = currentIndex
            currentIndex++
            runningCurrent = currentValue
        }
        println(runningCurrent)
        return runningCurrent
    }

}