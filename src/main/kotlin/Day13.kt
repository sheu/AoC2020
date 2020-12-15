fun main() {
    val input = "13,x,x,x,x,x,x,37,x,x,x,x,x,401,x,x,x,x,x,x,x,x,x,x,x,x,x,17,x,x,x,x,19,x,x,x,23,x,x,x,x,x,29,x,613,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41"
    println(input.split(",").filter { it != "x" }.map { it.toInt() }.map { ((1000340 / it) + 1) * it to it }
        .minBy { it.first }.let { (it!!.first - 1000340) * it!!.second })
}
class Day13 {

}