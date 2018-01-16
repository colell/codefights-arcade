import kotlin.test.assertEquals


fun main(args: Array<String>) {

    // 14. Alternating Sums
    alternatingSums(mutableListOf(50, 60, 60, 45, 70)).let {
        println(it)
        assertEquals(listOf(180, 105), it)
    }

    // 15. Add Boarder
    addBorder(mutableListOf("abc", "ded")).let {
        println(it)
        assertEquals(mutableListOf("*****","*abc*","*ded*","*****"), it)
    }

    // 16. Are Similar
    areSimilar(mutableListOf(1, 2, 3), mutableListOf(2, 1, 3)).let {
        println(it)
        assertEquals(true, it)
    }

    // 17. Array Change
    arrayChange(mutableListOf(1, 1, 1)).let {
        println(it)
        assertEquals(3, it)
    }

    // 18. Palindrome Rearranging
    palindromeRearranging("abbcabb").let {
        println(it)
        assertEquals(true, it)
    }
}

// 14. Alternating Sums
// Several people are standing in a row and need to be divided into two teams.
// The first person goes into team 1, the second goes into team 2, the third goes into team 1 again,
// the fourth into team 2, and so on.
// You are given an array of positive integers - the weights of the people.
// Return an array of two integers, where the first element is the total weight of team 1,
// and the second element is the total weight of team 2 after the division is complete.ngs.
fun alternatingSums(a: MutableList<Int>): MutableList<Int> {
    return mutableListOf(a.filterIndexed { index, _ -> index % 2 == 0 }.sum(), a.filterIndexed { index, _ -> index % 2 == 1 }.sum())
}

// 15. Add Boarder
// Given a rectangular matrix of characters, add a border of asterisks(*) to it.
fun addBorder(picture: MutableList<String>): MutableList<String> {
    return with ((1..picture[0].length + 2).map { "*" }.joinToString("")) {
        picture.map { "*$it*" }.toMutableList().also {
            it.add(0, this)
            it.add(this)
        }
    }
}

// 16. Are Similar?
// Two arrays are called similar if one can be obtained from another by swapping
// at most one pair of elements in one of the arrays.
// Given two arrays a and b, check whether they are similar.
fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
    var swaps = 0
    a.forEachIndexed { index, i ->
        if (i != b[index]) {
            val opt = b.indexOfFirst { index2, j -> j == i && a[index2] != j }
            if (opt == -1) return false
            swaps ++
            b[index] = b[opt].also { b[opt] = b[index] }
        }
        if (swaps > 1) return false
    }
    return true
}
private inline fun <T> List<T>.indexOfFirst(predicate: (Int, T) -> Boolean): Int {
    for ((index, item) in this.withIndex()) {
        if (predicate(index, item))
            return index
    }
    return -1
}

// 17. Array Change
// You are given an array of integers. On each move you are allowed to increase exactly one of its element by one.
// Find the minimal number of moves required to obtain a strictly increasing sequence from the input.
fun arrayChange(inputArray: MutableList<Int>): Int {
    return inputArray.mapIndexed { index, element ->
        if (index > 0 && inputArray[index-1] - element >= 0) {
            (inputArray[index-1] - element + 1).also { inputArray[index] = inputArray[index-1]+1 }
        } else 0
    }.sum()
}

// 18. Palindrome Rearranging
// Given a string, find out if its characters can be rearranged to form a palindrome.
fun palindromeRearranging(inputString: String): Boolean {
    return inputString.groupBy { it }.values.sumBy { it.size % 2 } <= 1
}

