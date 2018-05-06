import judi.DigitToLetter

fun main(args: Array<String>) {
    for (i in 90..99) {
        val f = DigitToLetter(i)
        println("$i : ${f.digitToLetter()}")
    }
}