package judi

class DigitToLetter {
    private var _digit: String = ""
    private var _digit2: String = ""
    private var _digit3: String = ""
    private var _lastDigitInString: String = ""
    private var _digitInSting: String = ""
    private var _numberInLetter = ""
    private val _d = mapOf(0 to "Zéro",1 to "Un", 2 to "Deux", 3 to "Trois", 4 to "Quatre", 5 to "Cinq", 6 to "Six", 7 to "Sept", 8 to "Huit", 9 to "Neuf",
            10 to "Dix", 11 to "Onze", 12 to "Douze", 13 to "Treize", 14 to "Quatorze", 15 to "Quinze", 16 to "Seize", 20 to "Vingt", 30 to "Trente",
            40 to "Quarante", 50 to "Cinquante", 60 to "Soixante", 100 to "Cent", 1_000 to "Mille")

    fun digitToLetter(args: Int): String {
        mainProcess(args)
        return _numberInLetter
    }

    private fun checkValueBeforToDeliver(valueToCheck: Int): String {
        var v = ""
        for (k in _d.keys) {
            if (valueToCheck == k) {
                v = _d[k]!!
                break
            }
        }
        if (v.isBlank()) {
            v = "Le chiffre $valueToCheck n'est pas encore pris en charge"
        }
        return v
    }

    private fun getValueInMap(args: Int): String {
        return checkValueBeforToDeliver(args)
    }

    private fun processTeens(args: Int): String {
        _lastDigitInString = args.toString().last().toString()
        return  if(args in 17..19) {
            _digit = getValueInMap(args - _lastDigitInString.toInt())
            _digit2 = getValueInMap(_lastDigitInString.toInt())
            "$_digit-${_digit2.toLowerCase()}"
        } else {
            getValueInMap(args)
        }
    }

    private fun processTwenties(args: Int): String {
        _lastDigitInString = args.toString().last().toString()
        return  if(args in 21..29) {
            if (args == 21) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit et $_digit2"
            } else if (args in 22..29) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit $_digit2"
            }
            _digitInSting
        } else  {
            getValueInMap(args)
        }
    }

    private fun processThirties(args: Int): String {
        _lastDigitInString = args.toString().last().toString()
        return if (args in 31..39) {
            if (args == 31) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit et $_digit2"
            } else if (args in 32..39) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit $_digit2"
            }
            _digitInSting
        } else {
            getValueInMap(args)
        }
    }

    private  fun processForties(args: Int): String {
        _lastDigitInString = args.toString().last().toString()
        return if(args in 41..49) {
            if (args == 41) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit et $_digit2"
            } else if (args in 42..49) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit $_digit2"
            }
            _digitInSting
        } else {
            getValueInMap(args)
        }
    }

    private fun processFifties(args: Int): String {
        _lastDigitInString = args.toString().last().toString()
        return if(args in 51..59) {
            if (args == 51) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit et $_digit2"
            } else if (args in 52..59) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit $_digit2"
            }
            _digitInSting
        } else {
            getValueInMap(args)
        }
    }

    private fun processSixties(args: Int): String {
        _lastDigitInString = args.toString().last().toString()
        _digitInSting = ""
        return if(args in 61..69) {
            if (args == 61) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit et $_digit2"
            } else if (args in 62..69) {
                _digit = getValueInMap(args - args.toString().last().toString().toInt())
                _digit2 = getValueInMap(_lastDigitInString.toInt()).toLowerCase()
                _digitInSting = "$_digit $_digit2"
            }
            _digitInSting
        } else {
            getValueInMap(args)
        }
    }

    private  fun processSeventies(args: Int): String {
        return if(args in 71..79) {
            if (args == 71) {
                val digit = processSixties(60)
                val digit2 = processTeens(args - 60).toLowerCase()
                _digitInSting = "$digit et $digit2"
            } else if (args in 72..79) {
                val digit = processSixties(60)
                val digit2 = processTeens(args - 60).toLowerCase()
                _digitInSting = "$digit-$digit2"

            }
            _digitInSting
        } else {
            "${processSixties(60 )}-${processTeens(args - 60).toLowerCase()}"
        }
    }

    private fun processEighties(args: Int): String {
        return if (args in 81..89) {
            _digit = getValueInMap(4)
            _digit2 = getValueInMap(20).toLowerCase()
            _digit3 = getValueInMap(args.toString().last().toString().toInt()).toLowerCase()
            "$_digit-$_digit2-$_digit3"
        } else {
            _digit = getValueInMap(4)
            _digit2 = getValueInMap(20).toLowerCase()
            _digit + "-" + _digit2 + "s"
        }
    }

    private  fun processNineties(args: Int): String {
        val digit = getValueInMap(4)
        val digit2 = getValueInMap(20).toLowerCase()
        val digit3 = processTeens(args - 80).toLowerCase()
        return "$digit-$digit2-$digit3"
    }

    private fun processHundreds(args: Int): String {
        val digitToString: String
        return if (args > 100) {
            val firstDigit = args.toString().first().toString().toInt()
            val middleDigit = args.toString()[1].toString().toInt()
            digitToString = if (firstDigit == 1) {
                commonProcessForHundreds(middleDigit, args, firstDigit.toString())
            } else{
                if (args == 200 || args == 300 || args == 400 || args == 500 || args == 600 || args == 700 || args == 800 || args == 900) {
                    "${getValueInMap(firstDigit)} ${getValueInMap(100).toLowerCase()}s"
                } else {
                    "${getValueInMap(firstDigit)} ${commonProcessForHundreds(middleDigit, args, firstDigit.toString()).toLowerCase()}"
                }
            }
                digitToString
        } else {
            getValueInMap(args)
        }
    }

    private fun commonProcessForHundreds(middleDigit: Int, digitToBeTransform: Int, firstDigit: String): String {
        return if(middleDigit != 0) {
            val d = digitToBeTransform.toString().removePrefix(firstDigit).toInt()
            "${getValueInMap(100)} ${digitToLetter(d).toLowerCase()}"
        } else {
            val d = digitToBeTransform.toString().removeRange(0,1).toInt()
            "${getValueInMap(100)} ${getValueInMap(d).toLowerCase()}"
        }
    }

    private fun mainProcess(args: Int) {
        _numberInLetter = when (args) {
            in 10..19 -> processTeens(args)
            in 20..29 -> processTwenties(args)
            in 30..39 -> processThirties(args)
            in 40..49 -> processForties(args)
            in 50..59 -> processFifties(args)
            in 60..69 -> processSixties(args)
            in 70..79 -> processSeventies(args)
            in 80..89 -> processEighties(args)
            in 90..99 -> processNineties(args)
            in 100..999 -> processHundreds(args)
            else -> getValueInMap(args)
        }
    }
}