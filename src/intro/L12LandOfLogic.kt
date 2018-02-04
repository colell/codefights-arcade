package intro

// 52. Longest Word
// Define a word as a sequence of consecutive English letters. Find the longest word from the given string.
fun longestWord(text: String): String = text.split(Regex("\\W")).maxBy { it.length } ?: ""

// 53. Valid Time
// Check if the given string is a correct time representation of the 24-hour clock.
fun validTime(time: String) = with(time.split(":")) { get(0).toInt() in 0 .. 23 && get(1).toInt() in 0 .. 59 }

// 54. Sum Up Numbers
// CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting
// string to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely
// going to automate it, so he needs a program that sums up all the numbers which appear in the given input.
// Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.
fun sumUpNumbers(inputString: String): Int {
    return inputString.split(Regex("[^\\d]+")).sumBy { try { it.toInt() } catch (e:Exception) { 0 } }
}

// 55. Different Squares
// Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.
fun differentSquares(m: MutableList<MutableList<Int>>) = mutableSetOf<String>().apply {
    (0 .. m.size - 2).forEach { row ->
        (0 .. m[row].size - 2).forEach { col ->
            add("${m[row][col]}${m[row+1][col]}${m[row+1][col+1]}${m[row][col+1]}")
        }
    }
}.size

// 56. Digits Product
// Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose
// digits is equal to product. If there is no such integer, return -1 instead.
fun digitsProduct(product: Int): Int {
    if (product == 0) return 10
    if (product < 10) return product

    return (2 .. 9).map {
        when {
            (product % it == 0) -> with(digitsProduct(product / it)) {
                if(this == -1) {
                    return@with Int.MAX_VALUE
                }else {
                    return@with "$it$this".toInt()
                }
            }
            else -> Int.MAX_VALUE
        }
    }.min()?.let {
        if (it == Int.MAX_VALUE) -1 else it
    } ?: -1
}

// 57. File Naming
// You are given an array of desired filenames in the order of their creation. Since two files cannot have equal names,
// the one which comes later will have an addition to its name in a form of (k), where k is the smallest positive
// integer such that the obtained name is not used yet.
// Return an array of names that will be given to the files.
fun fileNaming(names: MutableList<String>): MutableList<String> {
    val nameCount = mutableMapOf<String, Int>()
    return names.map { fileName ->
        (0 until names.size).forEach { count ->
            with(if(count == 0) fileName else "$fileName($count)") {
                nameCount[this] ?: run {
                    nameCount.put(this, 0)
                    return@map this
                }
            }
        }
        ""
    }.toMutableList()
}

// 58. Message From Binary Code
// You are taking part in an Escape Room challenge designed specifically for programmers.
// In your efforts to find a clue, you've found a binary code written on the wall behind a vase,
// and realized that it must be an encrypted message. After some thought, your first guess is that each
// consecutive 8 bits of the code stand for the character with the corresponding extended ASCII code.
// Assuming that your hunch is correct, decode the message.
fun messageFromBinaryCode(code: String) = (0 until code.length step 8).map { i ->
    Integer.parseInt(code.substring(i, i+8), 2).toChar()
}.joinToString("")

// 59. Spiral Numbers
// Construct a square matrix with a size N × N containing integers from 1 to N * N in a spiral order,
// starting from top-left and in clockwise direction.
fun spiralNumbers(n: Int): MutableList<MutableList<Int>> {
    val m = (1 .. n).map { (1 .. n).toMutableList() }.toMutableList()
    val trav = Traveler(x = n-1, y = 0, dir = 'd', steps = n-1, count = n+1, grid = m)
    while (trav.moveAndPlace()){}
    return m
}

class Traveler(var x: Int, var y:Int, var dir:Char, var steps:Int, var count:Int, val grid:MutableList<MutableList<Int>>) {
    var reduceTimer = 0
    fun moveAndPlace():Boolean {
        if (steps <= 0)
            return false
        (1 .. steps).forEach {
            when(dir) {
                'l' -> x--
                'r' -> x++
                'd' -> y++
                'u' -> y--
            }
            grid[y][x] = count ++
        }
        turn()
        steps -= (reduceTimer++) % 2
        return true
    }
    fun turn() {
        when(dir) {
            'l' -> dir = 'u'
            'r' -> dir = 'd'
            'd' -> dir = 'l'
            'u' -> dir = 'r'
        }
    }
}

// 60. Sudoku
// Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with digits so that each column,
// each row, and each of the nine 3 × 3 sub-grids that compose the grid contains all of the digits from 1 to 9.
// This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.
fun sudoku(grid: MutableList<MutableList<Int>>): Boolean {
    // rows (ensure 1-9 is in each row)
    if (isError(grid)){ return false }

    // cols (first take the transpose, then ensure 1-9 is in each row)
    if (isError(grid.mapIndexed { y, r -> r.mapIndexed { x, _ -> grid[x][y] } })){ return false }

    // groups (map each group to a row, then ensure 1-9 is in each row)
    if (isError((0 .. 8).map { i -> (0 .. 8).map { j -> grid[(i/3)*3+(j/3)][(j%3)+(i%3)*3] } })){ return false }

    return true
}

fun isError(grid: List<List<Int>>) = !grid.all { row -> (1 .. 9).all { row.contains(it) } }