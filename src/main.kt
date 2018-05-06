import judi.DigitToLetter

fun main(args: Array<String>) {
    for (i in 0..89) {
        val f = DigitToLetter(i)
        println("$i : ${f.chiffreEnLettre()}")
    }
}