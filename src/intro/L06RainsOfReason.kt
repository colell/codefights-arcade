package intro

// 25. Array Replace
// Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
fun arrayReplace(inputArray: MutableList<Int>, elemToReplace: Int, substitutionElem: Int): List<Int> {
    return inputArray.map { if (it == elemToReplace) substitutionElem else it }
}

// 26. Even Digits Only
// Check if all digits of the given integer are even.
fun evenDigitsOnly(n: Int): Boolean {
    return n.toString().all { Integer.parseInt(it.toString()) % 2 == 0 }
}

// 27. Variable Name
// Correct variable names consist only of Latin letters, digits and underscores and they can't start with a digit.
// Check if the given string is a correct variable name.
fun variableName(name: String): Boolean {
    val dict = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_"
    return name.all { dict.contains(it) } && name[0].toInt() >= 'A'.toInt()
}

// 28. Alphabetic Shift
// Given a string, replace each its character by the next one in the English alphabet (z would be replaced by a).
fun alphabeticShift(inputString: String): String {
    return inputString.map {
        (it.toInt() + 1).let { if (it > 'z'.toInt()) 'a' else it.toChar() }
    }.joinToString("")
}

// 29. Chess Board Cell Color
// Given two cells on the standard chess board, determine whether they have the same color or not.
fun chessBoardCellColor(cell1: String, cell2: String): Boolean {
    val c1 = cell1[0].toInt() - 'A'.toInt() + cell1[1].toInt() - '0'.toInt()
    val c2 = cell2[0].toInt() - 'A'.toInt() - cell2[1].toInt() - '0'.toInt()

    return (c1 - c2) % 2 == 0
}
