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
}


// 1. Add
fun add(param1: Int, param2: Int): Int = param1 + param2

// 2. Century From Year
fun centuryFromYear(year: Int): Int = Math.ceil(year/100.0).toInt()

// 3. Check Palindrome
fun checkPalindrome(str: String): Boolean = str.reversed() == str