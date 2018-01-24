package intro

// 34. Extract Each Kth
// Given array of integers, remove each kth element from it.
fun extractEachKth(inputArray: MutableList<Int>, k: Int): MutableList<Int> {
    return inputArray.filterIndexed { index, _ -> (index+1) % k != 0 }.toMutableList()
}

// 35. First Digit
// Find the leftmost digit that occurs in a given string.
fun firstDigit(inputString: String): Char = inputString.first { it.isDigit() }

// 36. Different Symbols Naive
// Given a string, find the number of different characters in it.
fun differentSymbolsNaive(s: String): Int = s.groupBy { it }.size

// 37. Array Max Consecutive Sum
// Given an array of integers, find the maximal possible sum of some of its k consecutive elements.
fun arrayMaxConsecutiveSum(inputArray: MutableList<Int>, k: Int): Int {
    var currentMax = inputArray.subList(0, k).sum()
    var current = currentMax

    (0 until inputArray.size-k).forEach { i ->
        current += inputArray[i+k] - inputArray[i]
        if (currentMax < current) {
            currentMax = current
        }
    }

    return currentMax
}