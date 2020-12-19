import java.io.File
import java.util.*
import kotlin.contracts.contract

fun main() {
   val input = File("src/main/resources/day18.txt").bufferedReader().readLines()
    val d = Day18()
    println(d.part1(input))
}

class Day18 {
    fun part1(input: List<String>) : Long {
        return input.map { it.evaluate() }.sum()
    }


}

fun String.evaluate(): Long {
    val charArray = this.toCharArray()
    var op = 'x'
    //val valuesInParenthesis = mutableListOf<String>()
    val stack = Stack<String>()
    var currentValue = 0L
    for(i in charArray.indices) {
        if(stack.isNotEmpty() && charArray[i] != ')') {
            stack.push(charArray[i].toString())
        }else {
            when {
                charArray[i] == '-' -> op = '-'
                charArray[i] == '+' -> op = '+'
                charArray[i] == '*' -> op = '*'
                charArray[i] == '/' -> op = '/'
                charArray[i] == '(' -> stack.push(charArray[i].toString())
                charArray[i] == ')' -> {
                    var popedValue = stack.pop()
                    val newString = mutableListOf<String>()
                    while (popedValue != "(") {
                        newString.add(popedValue)
                        popedValue = stack.pop()
                    }
                    val tempValue = newString.reversed().evaluate()
                    if (stack.isNotEmpty()) {
                        stack.push("$tempValue")
                    } else {
                        when (op) {
                            '-' -> currentValue -= tempValue
                            '+' -> currentValue += tempValue
                            '*' -> currentValue *= tempValue
                            '/' -> currentValue /= tempValue
                            else -> currentValue = tempValue

                        }
                        op = 'x'
                    }
                }
                charArray[i] == ' ' -> continue
                else -> {
                    val tempValue = Character.getNumericValue(charArray[i])

                    when (op) {
                        '-' -> currentValue -= tempValue
                        '+' -> currentValue += tempValue
                        '*' -> currentValue *= tempValue
                        '/' -> currentValue /= tempValue
                        else -> currentValue = tempValue.toLong()

                    }
                    op = 'x'
                }


            }
        }

    }
    return currentValue

}

fun List<String>.evaluate() : Long {
    println(this)
    var op = ""
    var currentValue  = 0L
    for(s in this) {
        if(s.matches("\\d+".toRegex())) {
            if(op.isEmpty()) {
                currentValue = s.toLong()
            }else {
                when (op) {
                    "+" -> currentValue += s.toLong()
                    "-" -> currentValue -= s.toLong()
                    "*" -> currentValue *= s.toLong()
                    "/" -> currentValue /= s.toLong()
                }

            }
        }else if(s.matches("\\*|\\+|\\-|\\/".toRegex())) {
            op = s
        }
    }
    return currentValue
}