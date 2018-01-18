package intro

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    // 1. Add
    add(4, 9).let {
        println(it)
        assertEquals(13, it)
    }

    // 2. Century From Year
    centuryFromYear(456).let {
        println(it)
        assertEquals(5, it)
    }

    // 3. Check Palindrome
    checkPalindrome("racecar").let {
        println(it)
        assertEquals(true, it)
    }

    // 4. Adjacent Elements Product
    adjacentElementsProduct(mutableListOf(1, 2, -5, 35, 2, 8, 12, 7)).let {
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

    // 8. Matrix Elements Sum
    matrixElementsSum(mutableListOf(
            mutableListOf(0, 1, 1, 2),
            mutableListOf(0, 5, 0, 0),
            mutableListOf(2, 0, 3, 3))).let {
        println(it)
        assertEquals(9, it)
    }

    // 9. All Longest Strings
    allLongestStrings(mutableListOf("aba", "aa", "ad", "vcd", "aba")).let {
        println(it)
        assertEquals(listOf("aba","vcd","aba"), it)
    }

    // 10. Common Character Count
    commonCharacterCount("aabcc", "adcaa").let {
        println(it)
        assertEquals(3, it)
    }

    // 11. Is Lucky
    isLucky(1230).let {
        println(it)
        assertEquals(true, it)
    }

    // 12. Sort By Height
    sortByHeight(mutableListOf(-1, 150, 190, 170, -1, -1, 160, 180)).let {
        println(it)
        assertEquals(listOf(-1, 150, 160, 170, -1, -1, 180, 190), it)
    }

    // 13. Reverse Parentheses
    reverseParentheses("Code(Cha(lle)nge)").let {
        println(it)
        assertEquals("CodeegnlleahC", it)
    }

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