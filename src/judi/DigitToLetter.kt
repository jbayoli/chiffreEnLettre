package judi

class DigitToLetter {
    private val _mapOfKnewDigit = mapOf(0 to "Zéro",1 to "Un", 2 to "Deux", 3 to "Trois", 4 to "Quatre", 5 to "Cinq", 6 to "Six", 7 to "Sept", 8 to "Huit",
            9 to "Neuf", 10 to "Dix", 11 to "Onze", 12 to "Douze", 13 to "Treize", 14 to "Quatorze", 15 to "Quinze", 16 to "Seize", 20 to "Vingt", 30 to "Trente",
            40 to "Quarante", 50 to "Cinquante", 60 to "Soixante", 100 to "Cent", 1_000 to "Mille", 1_000_000 to "Un million")

    fun digitToLetter(args: Int = 0): String {
        return if (args >= 0) {
            mainProcess(args)
        } else {
            "Les nombres négatifs ne sont pas pris en charge "
        }
    }

    private fun mainProcess(args: Int): String {
        return when (args) {
            in 17..19 -> processSeventeenToNineteen(args)
            in 21..79 -> processFromTwentyToSeventies(args)
            in 80..99 -> processEightyToNineties(args)
            in 101..999 -> processHundreds(args)
            in 1001..999999 -> processThousands(args)
            else -> getValueInMap(args)
        }
    }

    private fun getValueInMap(args: Int): String {
        return if (checkTheValueInTheMap(args)) {
            _mapOfKnewDigit[args]!!
        } else {
            "Le chiffre $args n'est pas encore pris en charge"
        }
    }

    private fun checkTheValueInTheMap(valueToCheck: Int): Boolean {
        return _mapOfKnewDigit.containsKey(valueToCheck)
    }

    private fun processSeventeenToNineteen(args: Int): String {
        val lastDigit = args.toString().last().toString().toInt()
        return  "${getValueInMap(args - lastDigit)}-${getValueInMap(lastDigit).toLowerCase()}"
    }

    private fun processFromTwentyToSeventies(args: Int): String {
        val lastDigit = args.toString().last().toString().toInt()
        return if(args < 70) {
            when (lastDigit) {
                0 -> getValueInMap(args)
                1 -> "${getValueInMap(args - lastDigit)} et ${getValueInMap(lastDigit).toLowerCase()}"
                else -> "${getValueInMap(args - lastDigit)} ${getValueInMap(lastDigit).toLowerCase()}"
            }
        } else {
            if (lastDigit == 1) {
                "${getValueInMap(60)} et ${getValueInMap(args - 60).toLowerCase()}"
            } else {
                "${getValueInMap(60)}-${digitToLetter(args-60).toLowerCase()}"
            }
        }
    }

    private fun processEightyToNineties(args: Int): String {
        val lastDigit = args.toString().last().toString().toInt()
        return if (args < 90) {
            if (args in 81..89) {
                "${getValueInMap(4)}-${getValueInMap(20).toLowerCase()}-${getValueInMap(lastDigit).toLowerCase()}"
            } else {
                "${getValueInMap(4)}-${getValueInMap(20).toLowerCase()}s"
            }
        } else {
            "${getValueInMap(4)}-${getValueInMap(20).toLowerCase()}-${digitToLetter(args - 80).toLowerCase()}"
        }
    }

    private fun processHundreds(args: Int): String {
        val firstDigit = args.toString().first().toString().toInt()
        val middleDigit = args.toString()[1].toString().toInt()
        val lastDigit = args.toString().last().toString().toInt()
        fun commonProcessForHundreds(): String {
            val d: Int
            return if(middleDigit != 0) {
                d = args.toString().removePrefix(firstDigit.toString()).toInt()
                "${getValueInMap(100)} ${digitToLetter(d).toLowerCase()}"
            } else {
                d = args.toString().removeRange(0,1).toInt()
                "${getValueInMap(100)} ${getValueInMap(d).toLowerCase()}"
            }
        }
        return if (firstDigit == 1) {
            commonProcessForHundreds()
        } else {
            if (middleDigit == 0 && lastDigit == 0) {
                "${getValueInMap(firstDigit)} ${getValueInMap(100).toLowerCase()}s"
            } else {
                "${getValueInMap(firstDigit)} ${commonProcessForHundreds().toLowerCase()}"
            }
        }
    }

    private fun processThousands(args: Int): String {
        var firstDigit: Int? = null
        var secondDigit: Int? = null
        var thirdDigit: Int? = null
        var lastDigit: Int? = null
        fun commonProcessForThousands(): String {
            val d: Int
            return if (secondDigit != 0) {
                d = args.toString().removePrefix(firstDigit.toString()).toInt()
                "${getValueInMap(1000)} ${digitToLetter(d).toLowerCase()}"
            } else if (secondDigit == 0 && thirdDigit != 0) {
                d = args.toString().removePrefix("$firstDigit$secondDigit").toInt()
                "${getValueInMap(1000)} ${digitToLetter(d).toLowerCase()}"
            } else {
                "${getValueInMap(1000)} ${getValueInMap(lastDigit!!).toLowerCase()}"
            }
        }
        fun setFirstToLastDigitInThousands() {
            val numberOfDigit = args.toString().count()
            fun cPTSSecondToLastDigitInThousands(args: Int) {
                val remainder: String = args.toString().removePrefix(firstDigit.toString())
                secondDigit = remainder.first().toString().toInt()
                thirdDigit = remainder[remainder.count() - 2].toString().toInt()
                lastDigit = remainder.last().toString().toInt()
            }
            when (numberOfDigit) {
                4 -> {
                    firstDigit = args.toString().first().toString().toInt()
                    cPTSSecondToLastDigitInThousands(args)
                }
                5 -> {
                    firstDigit = args.toString().removeRange(2, 5).toInt()
                    cPTSSecondToLastDigitInThousands(args)
                }
                6 -> {
                    firstDigit = args.toString().removeRange(3, 6).toInt()
                    cPTSSecondToLastDigitInThousands(args)
                }
            }
        }
        setFirstToLastDigitInThousands()
        return if (args in 1000..1999) {
            commonProcessForThousands()
        } else {
            if (secondDigit == 0 && thirdDigit == 0 && lastDigit == 0){
                "${digitToLetter(firstDigit!!)} ${getValueInMap(1000).toLowerCase()}"
            } else {
                "${digitToLetter(firstDigit!!)} ${commonProcessForThousands().toLowerCase()}"
            }
        }
    }
}