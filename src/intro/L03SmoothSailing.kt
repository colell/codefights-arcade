package intro

// 9. All Longest Strings
// Given an array of strings, return another array containing all of its longest strings.
fun allLongestStrings(inputArray: MutableList<String>): List<String> {
    return inputArray.maxBy { it.length }?.run {
        inputArray.filter { it.length == this.length }
    } ?: mutableListOf()
}

// 10. Common Character Count
// Given two strings, find the number of common characters between them.
fun commonCharacterCount(s1: String, s2: String): Int {
    return s1.groupBy { it }.values.map { group ->
        Math.min(group.size, s2.count { it == group[0] })
    }.sum()
}

// 11. Is Lucky
// Ticket numbers usually consist of an even number of digits.
// A ticket number is considered lucky if the sum of the first half of the digits is
// equal to the sum of the second half. Given a ticket number n, determine if it's lucky or not.
fun isLucky(n: Int): Boolean {
    return with("$n") {
        substring(0 until length/2).sumBy { it-'0' } == substring(length/2).sumBy { it-'0' }
    }
}

// 12. Sort By Height
// Some people are standing in a row in a park. There are trees between them which cannot be moved. (-1)
// Your task is to rearrange the people by their heights in a non-descending order without moving the trees.
fun sortByHeight(a: MutableList<Int>): List<Int> {
    return with (a.filter { it != -1 }.sorted().iterator()) { a.map { if(it == -1) -1 else next() } }
}

// 13. Reverse Parentheses
// You have a string s that consists of English letters, punctuation marks, whitespace characters, and brackets.
// It is guaranteed that the parentheses in s form a regular bracket sequence.
// Your task is to reverse the strings contained in each pair of matching parentheses,
// starting from the innermost pair. The results string should not contain any parentheses.
fun reverseParentheses(s: String): String {
    var s2 = s
    val indexStack:MutableList<Int> = mutableListOf()
    for (i in 0 until s.length) {
        if (s2[i] == '(')
            indexStack.add(0, i)
        if (s2[i] == ')') {
            val start:Int = indexStack.removeAt(0)
            s2 = s2.substring(0, start+1) + s2.substring(start+1, i).reversed() + s2.substring(i)
        }
    }
    return s2.filter { it != '(' && it != ')' }
}