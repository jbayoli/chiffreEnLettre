package judi

class DigitToLetter(digit: Int = 0) {
    private val _digitInInt: Int = digit
    private var _digit: String = ""
    private var _digit2: String = ""
    private var _digit3: String = ""
    private var _lastDigitInString: String = ""
    private var _digitInSting: String = ""
    private var _numberInLetter = ""
    private val _d = mapOf(0 to "Zéro",1 to "Un", 2 to "Deux", 3 to "Trois", 4 to "Quatre", 5 to "Cinq", 6 to "Six", 7 to "Sept", 8 to "Huit", 9 to "Neuf",
            10 to "Dix", 11 to "Onze", 12 to "Douze", 13 to "Treize", 14 to "Quatorze", 15 to "Quinze", 16 to "Seize", 20 to "Vingt", 30 to "Trente",
            40 to "Quarante", 50 to "Cinquante", 60 to "Soixante", 100 to "Cent")

    fun digitToLetter(): String {
        mainProcess()
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
        _digitInSting =  if (args in 81..89) {
            _digit = getValueInMap(4)
            _digit2 = getValueInMap(20).toLowerCase()
            _digit3 = getValueInMap(args.toString().last().toString().toInt()).toLowerCase()
            "$_digit-$_digit2-$_digit3"
        } else {
            _digit = getValueInMap(4)
            _digit2 = getValueInMap(20).toLowerCase()
            _digit + "-" + _digit2 + "s"
        }
        return _digitInSting
    }

    private  fun processNineties(args: Int): String {
        val digit = getValueInMap(4)
        val digit2 = getValueInMap(20).toLowerCase()
        val digit3 = processTeens(args - 80).toLowerCase()
        _digitInSting = "$digit-$digit2-$digit3"
        return _digitInSting
    }

    private fun mainProcess() {
        _numberInLetter = when (_digitInInt) {
            in 10..19 -> processTeens(_digitInInt)
            in 20..29 -> processTwenties(_digitInInt)
            in 30..39 -> processThirties(_digitInInt)
            in 40..49 -> processForties(_digitInInt)
            in 50..59 -> processFifties(_digitInInt)
            in 60..69 -> processSixties(_digitInInt)
            in 70..79 -> processSeventies(_digitInInt)
            in 80..89 -> processEighties(_digitInInt)
            in 90..99 -> processNineties(_digitInInt)
            else -> getValueInMap(_digitInInt)
        }
    }
}