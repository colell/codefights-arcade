package intro

// 43. Is Beautiful String
// A string is said to be beautiful if b occurs in it no more times than a; c occurs in it no more times than b; etc.
// Given a string, check whether it is beautiful.
fun isBeautifulString(inputString: String): Boolean {
    val group = inputString.groupBy { it }
    var lastCount = Int.MAX_VALUE
    for (ch in 'a' .. 'z')
        lastCount = group[ch]?.let { if (lastCount < it.size) return false else it.size } ?: 0

    return true
}

// 44. Find Email Domain
// An email address such as "John.Smith@example.com" is made up of a local part ("John.Smith"),
// an "@" symbol, then a domain part ("example.com").
// The domain name part of an email address may only consist of letters, digits, hyphens and dots.
// The local part, however, also allows a lot of different special characters.
// Here you can look at several examples of correct and incorrect email addresses.
// Given a valid email address, find its domain part.
fun findEmailDomain(address: String): String = with(address) { substring(lastIndexOf("@")+1) }

// 45. Build Palindrome
// Given a string, find the shortest possible string which can be achieved by
// adding characters to the end of initial string to make it a palindrome.
fun buildPalindrome(st: String): String {
    var right = ""
    while(with(st + right){ reversed() != this }) {
        right = st.substring(0, right.length + 1).reversed()
    }
    return st + right
}

// 46. Election Winners
// Elections are in progress!
// Given an array of the numbers of votes given to each of the candidates so far, and an integer k
// equal to the number of voters who haven't cast their vote yet, find the number of candidates who
// still have a chance to win the election.
// The winner of the election must secure strictly more votes than any other candidate.
// If two or more candidates receive the same (maximum) number of votes, assume there is no winner at all.
fun electionsWinners(votes: MutableList<Int>, k: Int): Int {
    return votes.max()?.let { maxVotes ->
        if (k == 0) {
            if (votes.filter { it == maxVotes }.size > 1) 0 else 1
        }else {
            votes.map { cVotes -> if (cVotes + k > maxVotes) 1 else 0 }.sum()
        }
    } ?: 0
}

// 47. Is MAC48 Address
// A media access control address (MAC address) is a unique identifier assigned to network interfaces
// for communications on the physical network segment.
// The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups
// of two hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).
// Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.
fun isMAC48Address(inputString: String) = inputString.matches(Regex("[0-9A-F]{2}(-[0-9A-F]{2}){5}"))
