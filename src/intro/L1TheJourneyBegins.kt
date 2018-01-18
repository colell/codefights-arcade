package intro

// 1. Add
// Write a function that returns the sum of two numbers.
fun add(param1: Int, param2: Int): Int = param1 + param2

// 2. Century From Year
// Given a year, return the century it is in. The first century spans from the year 1 up to and
// including the year 100, the second - from the year 101 up to and including the year 200, etc.
fun centuryFromYear(year: Int): Int = Math.ceil(year/100.0).toInt()

// 3. Check Palindrome
// Given the string, check if it is a palindrome.
fun checkPalindrome(str: String): Boolean = str.reversed() == str