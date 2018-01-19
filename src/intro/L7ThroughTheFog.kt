package intro

// 30. Circle of Numbers
// Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance
// between any two neighbouring numbers is equal (note that 0 and n - 1 are neighbouring, too).
// Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.
fun circleOfNumbers(n: Int, firstNumber: Int): Int = (firstNumber + n/2) % n

// 31. Deposit Profit
// You have deposited a specific amount of dollars into your bank account.
// Each year your balance increases at the same growth rate.
// Find out how long it would take for your balance to pass a specific threshold with the
// assumption that you don't make any additional deposits.
fun depositProfit(deposit: Int, rate: Int, threshold: Int): Int {
    var years = 0
    var balance = deposit.toFloat()
    while (balance < threshold) {
        years ++
        balance *= rate/100f + 1
    }
    return years
}

// 32. Absolute Values Sum Minimization
// Given a sorted array of integers a, find an integer x from a such that the value of
// abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x)
// is the smallest possible (here abs denotes the absolute value).
// If there are several possible answers, output the smallest one.
fun absoluteValuesSumMinimization(a: MutableList<Int>): Int = a[(a.size-1) / 2]

// 33. Strings Rearrangement
// Given an array of equal-length strings, check if it is possible to rearrange the strings in such a way
// that after the rearrangement the strings at consecutive positions would differ by exactly one character.
fun stringsRearrangement(inputArray: MutableList<String>): Boolean {
    val nodes = inputArray.map { Node(it) }

    nodes.forEach { cNode ->
        nodes.forEach { lNode ->
            if (cNode.value.mapIndexed { i, ch -> if (ch == lNode.value[i]) 0 else 1 }.sum() == 1)
                cNode.connections.add(lNode)
        }
    }
    return isHamiltonian(nodes)
}

fun isHamiltonian(unusedNodes: List<Node>, currentNode: Node? = null): Boolean {
    if (unusedNodes.isEmpty())
        return true
    var possible = false
    currentNode?.connections?.forEach { connection ->
        if (!possible) {
            if (unusedNodes.contains(connection))
                possible = isHamiltonian(unusedNodes.toMutableList().apply { remove(connection) }.toList(), connection)
        }
    } ?: run {
        unusedNodes.forEach { node ->
            if (!possible) {
                possible = isHamiltonian(unusedNodes.toMutableList().apply { remove(node) }.toList(), node)
            }
        }
    }
    return possible
}

data class Node(val value: String, val connections:MutableList<Node> = mutableListOf())
