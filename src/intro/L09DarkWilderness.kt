package intro

// 38. Growing Plant
// Each day a plant is growing by upSpeed meters. Each night that plant's height decreases by downSpeed meters due to
// the lack of sun heat. Initially, plant is 0 meters tall. We plant the seed at the beginning of a day.
// We want to know when the height of the plant will reach a certain level.
fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int {
    var height = 0
    var days = 1
    while (true) {
        height += upSpeed
        if (height >= desiredHeight)
            return days
        height -= downSpeed
        days ++
    }
}

// 39. Knapsack Light
// You found two items in a treasure chest! The first item weighs weight1 and is worth value1,
// and the second item weighs weight2 and is worth value2. What is the total maximum value of the items you
// can take with you, assuming that your max weight capacity is maxW and you can't come back for the items later?
// Note that there are only two items and you can't bring more than one item of each type,
// i.e. you can't take two first items or two second items.
fun knapsackLight(value1: Int, weight1: Int, value2: Int, weight2: Int, maxW: Int): Int {
    return listOf(Pair(weight1 + weight2, value1 + value2), Pair(weight1, value1), Pair(weight2, value2)).
            filter { it.first <= maxW }.maxBy { it.second }?.second ?: 0
}

// 40. Longest Digits Prefix
// Given a string, output its longest prefix which contains only digits.
fun longestDigitsPrefix(inputString: String): String {
    return inputString.substring(0, inputString.indexOfFirst { !it.isDigit() }.run {
        if (this < 0) inputString.length else this
    })
}

// 41. Digit Degree
// Let's define digit degree of some positive integer as the number of times we need to replace this
// number with the sum of its digits until we get to a one digit number.
// Given an integer, find its digit degree.
fun digitDegree(n: Int): Int {
    var strNum = n
    (0 .. Int.MAX_VALUE).forEach {
        if (strNum < 10) return it
        strNum = "$strNum".map { Integer.parseInt(it.toString()) }.sum()
    }
    return 0
}

// 42. Bishop and Pawn
// Given the positions of a white bishop and a black pawn on the standard chess board,
// determine whether the bishop can capture the pawn in one move.
// The bishop has no restrictions in distance for each move, but is limited to diagonal movement.
fun bishopAndPawn(bishop: String, pawn: String): Boolean {
    val bishopPos = Pair(bishop[0].toLowerCase().toInt() - 'a'.toInt(), Integer.parseInt(bishop[1].toString()))
    val pawnPos = Pair(pawn[0].toLowerCase().toInt() - 'a'.toInt(), Integer.parseInt(pawn[1].toString()))
    return with(bishopPos.first - pawnPos.first) {
        this != 0 && Math.abs((bishopPos.second - pawnPos.second).toFloat()/this) == 1f
    }
}
