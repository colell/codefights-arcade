import kotlin.test.assertEquals


fun main(args: Array<String>) {

    // 4. Adjacent Elements Product
    adjacentElementsProduct(mutableListOf(1,2,-5,35,2,8,12,7)).let {
        println(it)
        assertEquals(96, it)
    }

    // 5. Shape Area
    shapeArea(3).let {
        println(it)
        assertEquals(13, it)
    }

    // 6. Make Array Consecutive
    makeArrayConsecutive2(mutableListOf(6, 2, 3, 8)).let {
        println(it)
        assertEquals(3, it)
    }

    // 7. Almost Increasing Sequence
    almostIncreasingSequence(mutableListOf(1, 3, 2, 1)).let {
        println(it)
        assertEquals(false, it)
    }

    // 8.
    matrixElementsSum(mutableListOf(
            mutableListOf(0, 1, 1, 2),
            mutableListOf(0, 5, 0, 0),
            mutableListOf(2, 0, 3, 3))).let {
        println(it)
        assertEquals(9, it)
    }
}

// 4. Adjacent Elements Product
// Given an array of integers, find the pair of adjacent
// elements that has the largest product and return that product.
fun adjacentElementsProduct(inputArray: MutableList<Int>): Int {
    return (0 .. inputArray.size - 2).map {
        inputArray[it] * inputArray[it + 1]
    }.max() ?: Int.MIN_VALUE
}

// 5. Shape Area
// Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.
// A 1-interesting polygon is just a square with a side of length 1.
// An n-interesting polygon is obtained by taking the n - 1-interesting polygon and appending
// 1-interesting polygons to its rim, side by side.
//
//                                #
//                   #           ###
// n = 1: #  n = 2: ###  n = 3: #####
//                   #           ###
//                                #
//
fun shapeArea(n: Int): Int = if (n == 1) 1 else { (n - 1) * 4 + shapeArea(n - 1)  }

// 6. Make Array Consecutive
// Ratiorg got statues of different sizes as a present from CodeMaster for his birthday,
// each statue having an non-negative integer size. Since he likes to make things perfect,
// he wants to arrange them from smallest to largest so that each statue will be bigger than
// the previous one exactly by 1. He may need some additional statues to be able to accomplish that.
// Help him figure out the minimum number of additional statues needed.
fun makeArrayConsecutive2(statues: MutableList<Int>): Int = with(statues) { max()!!-min()!! + 1 - size }

// 7. Almost Increasing Sequence
// Given a sequence of integers as an array, determine whether it is possible to obtain a
// strictly increasing sequence by removing no more than one element from the array.
fun almostIncreasingSequence(sequence: MutableList<Int>): Boolean {
    return with(sequence) {(0 until size - 1).map {
            if (this[it] - this[it + 1] >= 0) {
                // Ensure the surrounding values are still in order if removed
                if (it > 0 && it < size - 2 && this[it] - this[it + 2] >= 0 && this[it - 1] - this[it + 1] >= 0)
                    return false
                1
            }else 0
        }
    }.sum() <= 1
}

// 8. Matrix Elements Sum
// After they became famous, the CodeBots all decided to move to a new building and live together.
// The building is represented by a rectangular matrix of rooms. Each cell in the matrix contains an
// integer that represents the price of the room. Some rooms are free (their cost is 0),
// but that's probably because they are haunted, so all the bots are afraid of them.
// That is why any room that is free or is located anywhere below a free room in the same column is
// not considered suitable for the bots to live in.
//
// Help the bots calculate the total price of all the rooms that are suitable for them.
fun matrixElementsSum(matrix: MutableList<MutableList<Int>>): Int {
    return matrix.indices.map { y ->
        matrix[y].indices.map { x ->
            if ((y downTo 0).none { matrix[it][x] == 0 }) matrix[y][x] else 0
        }.sum()
    }.sum()
}