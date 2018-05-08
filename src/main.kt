import judi.DigitToLetter

fun main(args: Array<String>) {
    for (i in 0..99) {
        val  p = DigitToLetter(i)
        println("$i : ${p.digitToLetter()}")
    }
}