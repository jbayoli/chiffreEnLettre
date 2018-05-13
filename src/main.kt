import judi.DigitToLetter

fun main(args: Array<String>) {
//    val d = DigitToLetter()
//    println(d.digitToLetter(299))
    val d = DigitToLetter()
    for (i in 0..1000) {
        println(d.digitToLetter(i))
    }
}