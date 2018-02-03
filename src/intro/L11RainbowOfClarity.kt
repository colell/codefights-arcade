package intro

// 48. Is Digit
// Determine if the given character is a digit or not.
fun isDigit(symbol: Char): Boolean = symbol.isDigit()

// 49. Line Encoding
// Given a string, return its encoding defined as follows:
// First, the string is divided into the least possible number of disjoint substrings consisting of identical characters
// for example, "aabbbc" is divided into ["aa", "bbb", "c"]
// Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating character
// for example, substring "bbb" is replaced by "3b"
// Finally, all the new strings are concatenated together in the same order and a new string is returned.
fun lineEncoding(s: String): String {
    val builder = StringBuilder()
    var counter = 0
    var currentChar = s[0]
    s.forEach { nextChar ->
        when {
            currentChar == nextChar -> counter ++
            counter < 2 -> {
                builder.append(currentChar)
                counter = 1
                currentChar = nextChar
            }
            else -> {
                builder.append(counter)
                builder.append(currentChar)
                counter = 1
                currentChar = nextChar
            }
        }
    }
    if (counter > 0) {
        if (counter < 2) {
            builder.append(currentChar)
        }else {
            builder.append(counter)
            builder.append(currentChar)
        }
    }
    return builder.toString()
}

// 50. Chess Knight
// Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.
// The knight can move to a square that is two squares horizontally and one square vertically, or two squares
// vertically and one square horizontally away from it. The complete move therefore looks like the letter L.
// Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.
fun chessKnight(cell: String): Int {
    val knight = Pair(cell[0] - 'a', cell[1] - '1')
    return (0 .. 7).map { Pair(((it % 2)+1)*Math.pow(-1.0,
            Math.floor((it / 4).toDouble())).toInt(),
            (((it+1) % 2)+1)*Math.pow(-1.0,
            Math.floor((it / 2).toDouble())).toInt()) }.filter {
        knight.first + it.first in 0..7 && knight.second + it.second in 0..7
    }.size
}

// 51. Delete Digit
// Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.
fun deleteDigit(n: Int): Int = with(n.toString()) {
    (0 until length).map { Integer.parseInt(removeRange(it .. it)) }
}.max() ?: 0
