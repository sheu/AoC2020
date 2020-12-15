import java.io.File

fun main() {
    val input = File("src/main/resources/day14.txt").bufferedReader().readLines()
    val d = Day14()
    println(d.part1(input))
    println(d.part2(input))
}

class Day14 {


    fun Long.to32bitString(): String =
        java.lang.Long.toBinaryString(this).padStart(36, '0')

    fun part1(input: List<String>): Long {
        val memoryMap = mutableMapOf<String, String>()
        var mask = ""
        for (i in input.indices) {
            if (input[i].startsWith("mask")) {
                mask = input[i].split(" = ")[1].trim()
            } else {
                val instruction = input[i].split(" = ")
                val value = instruction[1].trim().toLong()
                val memAddress = instruction[0].trim().split("\\[|\\]".toRegex())[1].trim()
                memoryMap[memAddress] =
                    value.to32bitString().foldIndexed("") { j, acc, v -> acc + if (mask[j] == 'X') v else mask[j] }

            }
        }
        return memoryMap.map { java.lang.Long.parseLong(it.value, 2) }.filter { it != 0L }.sum()
    }

    fun part2(input: List<String>): Long {

        val memoryMap = mutableMapOf<String, Long>()
        var mask = ""
        for (i in input.indices) {
            if (input[i].startsWith("mask")) {
                mask = input[i].split(" = ")[1].trim()
            } else {
                val instruction = input[i].split(" = ")

                val memAddress = instruction[0].trim().split("\\[|\\]".toRegex())[1].trim().toLong()
                val value = instruction[1].trim().toLong()


                val valueWithFloat = memAddress.to32bitString()
                    .foldIndexed("") { j, acc, v -> acc + if (mask[j] == 'X') 'X' else if (mask[j] == '1') '1' else v }

                val list = mutableListOf<String>()
                val numX = valueWithFloat.filter { it == 'X' }.count()
                generateAllBinaryStrings(numX, "X".repeat(numX).toCharArray(), 0, list)
                val addList = valueWithFloat.buildList(list)
                for (add in addList) {
                    memoryMap[add] = value
                }

            }
        }

        return memoryMap.map { it.value }.sum()
    }

    fun generateAllBinaryStrings(n: Int, arr: CharArray, i: Int, l: MutableList<String>) {
        if (i == n) {
            l.add(arr.joinToString(""))
            return
        }
        arr[i] = '0'
        generateAllBinaryStrings(n, arr, i + 1, l)
        arr[i] = '1'
        generateAllBinaryStrings(n, arr, i + 1, l)
    }

    fun String.buildList(l: List<String>): List<String> {
        val m = mutableListOf<String>()
        for (s in l) {
            val val1 = s.fold(this) { acc, c -> acc.replaceFirst("X", c.toString()) }
            m.add(val1)
        }
        return m.toList()
    }


}