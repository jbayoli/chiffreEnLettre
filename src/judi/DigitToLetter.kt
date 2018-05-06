package judi

class DigitToLetter(valeur: Int) {
    private val _valeur: Int = valeur
    private val _d = mapOf(0 to "Zéro",1 to "Un", 2 to "Deux", 3 to "Trois", 4 to "Quatre", 5 to "Cinq", 6 to "Six", 7 to "Sept", 8 to "Huit", 9 to "Neuf",
            10 to "Dix", 11 to "Onze", 12 to "Douze", 13 to "Treize", 14 to "Quatorze", 15 to "Quinze", 16 to "Seize", 20 to "Vingt", 30 to "Trente",
            40 to "Quarante", 50 to "Cinquante", 60 to "Soixante")
    private var _valeurEnLettre = ""

    fun digitToLetter(): String {
        mainProcess()
        return _valeurEnLettre
    }

    private fun checkValueBeforToDeliver(valeur: Int): String {
        var v = ""
        for (k in _d.keys) {
            if (valeur == k) {
                v = _d[k]!!
                break
            }
        }
        if (v.isBlank()) {
            v = "Le chiffre $valeur n'est pas encore pris en charge"
        }
        return v
    }

    private fun getValueInMap(args: Int): String {
        return checkValueBeforToDeliver(args)
    }

    private fun processTeens(args: Int): String {
        val uni: String
        val diza: String
        val valeurEnString = args.toString().last().toString()
        return  if(args in 17..19) {
            diza = getValueInMap(10)
            uni = getValueInMap(valeurEnString.toInt())
            "$diza-${uni.toLowerCase()}"
        } else {
            getValueInMap(args)
        }
    }

    private fun processTwenties(args: Int): String {
        val uni: String
        val diza: String
        val valeurEnString = args.toString().last().toString()
        var value = ""
        return  if(args in 21..29) {
            if (args == 21) {
                diza = getValueInMap(20)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza et $uni"
            } else if (args in 22..29) {
                diza = getValueInMap(20)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza $uni"
            }
            value
        } else  {
            getValueInMap(args)
        }
    }

    private fun processThirties(args: Int): String {
        val uni: String
        val diza: String
        val valeurEnString = args.toString().last().toString()
        var value = ""
        return if (args in 31..39) {
            if (args == 31) {
                diza = getValueInMap(30)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza et $uni"
            } else if (args in 32..39) {
                diza = getValueInMap(30)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza $uni"
            }
            value
        } else {
            getValueInMap(args)
        }
    }

    private  fun processFourties(args: Int): String {
        val uni: String
        val diza: String
        val valeurEnString = args.toString().last().toString()
        var value = ""
        return if(args in 41..49) {
            if (args == 41) {
                diza = getValueInMap(40)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza et $uni"
            } else if (args in 42..49) {
                diza = getValueInMap(40)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza $uni"
            }
            value
        } else {
            getValueInMap(args)
        }
    }

    private fun processFyfties(args: Int): String {
        val uni: String
        val diza: String
        val valeurEnString = args.toString().last().toString()
        var value = ""
        return if(args in 51..59) {
            if (args == 51) {
                diza = getValueInMap(50)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza et $uni"
            } else if (args in 52..59) {
                diza = getValueInMap(50)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza $uni"
            }
            value
        } else {
            getValueInMap(args)
        }
    }

    private fun processSixties(args: Int): String {
        val uni: String
        val diza: String
        val valeurEnString = args.toString().last().toString()
        var value = ""
        return if(args in 61..69) {
            if (args == 61) {
                diza = getValueInMap(60)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza et $uni"
            } else if (args in 62..69) {
                diza = getValueInMap(60)
                uni = getValueInMap(valeurEnString.toInt()).toLowerCase()
                value = "$diza $uni"
            }
            value
        } else {
            getValueInMap(args)
        }
    }

    private  fun processSeventies(args: Int): String {
        val diza: String
        val diza2: String
        var value = ""
        return if(args in 71..79) {
            if (args == 71) {
                diza = processSixties(60)
                diza2 = processTeens(args - 60).toLowerCase()
                value = "$diza et $diza2"
            } else if (args in 72..79) {
                diza = processSixties(60)
                diza2 = processTeens(args - 60).toLowerCase()
                value = "$diza-$diza2"

            }
            value
        } else {
            "${processSixties(60 )}-${processTeens(args - 60).toLowerCase()}"
        }
    }

    private fun processHeigties(args: Int): String {
        val digit: String
        val digit2: String
        val digit3: String
        val digitInSting: String
        digitInSting =  if (args in 81..89) {
            digit = getValueInMap(4)
            digit2 = processTeens(20).toLowerCase()
            digit3 = getValueInMap(args.toString().last().toString().toInt()).toLowerCase()
            "$digit-$digit2-$digit3"
        } else {
            digit = getValueInMap(4)
            digit2 = processTeens(20).toLowerCase()
            digit + "-" + digit2 + "s"
        }
        return digitInSting
    }

    private  fun processninties(args: Int): String {
        val digit: String
        val digit2: String
        val digit3: String
        val digitInString: String
        digitInString = if (args in 91..92){
            digit = getValueInMap(4)
            digit2 = processTeens(20).toLowerCase()
            digit3 = processTeens(args - 80).toLowerCase()
            "$digit-$digit2-$digit3"
        } else {
            digit = getValueInMap(4)
            digit2 = processTwenties(20).toLowerCase()
            digit3 = processTeens(args - 80).toLowerCase()
            "$digit-$digit2-$digit3"
        }
        return digitInString
    }

    private fun mainProcess() {
        _valeurEnLettre = when (_valeur) {
            in 10..19 -> processTeens(_valeur)
            in 20..29 -> processTwenties(_valeur)
            in 30..39 -> processThirties(_valeur)
            in 40..49 -> processFourties(_valeur)
            in 50..59 -> processFyfties(_valeur)
            in 60..69 -> processSixties(_valeur)
            in 70..79 -> processSeventies(_valeur)
            in 80..89 -> processHeigties(_valeur)
            in 90..99 -> processninties(_valeur)
            else -> getValueInMap(_valeur)
        }
    }
}