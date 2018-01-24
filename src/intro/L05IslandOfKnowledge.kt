package intro

// 19. Are Equally Strong
// Call two arms equally strong if the heaviest weights they each are able to lift are equal.
// Call two people equally strong if their strongest arms are equally strong (the strongest arm
// can be both the right and the left), and so are their weakest arms.
// Given your and your friend's arms' lifting capabilities find out if you two are equally strong.
fun areEquallyStrong(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int): Boolean {
    return  (yourLeft  == friendsLeft || yourLeft ==  friendsRight) &&
            (yourRight == friendsLeft || yourRight == friendsRight)
}

// 20. Array Maximal Adjacent Difference
// Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {
    return inputArray.mapIndexed { index, num -> if (index == 0) 0 else Math.abs(num - inputArray[index - 1]) }.max() ?: 0
}

// 21. Is IPv4 Address
// An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a
// computer network that uses the Internet Protocol for communication. There are two versions of the
// Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.
// IPv4 addresses are represented in dot-decimal notation, which consists of four decimal numbers,
// each ranging from 0 to 255 inclusive, separated by dots, e.g., 172.16.254.1.
// Given a string, find out if it satisfies the IPv4 address naming rules.
fun isIPv4Address(inputString: String): Boolean {
    return with(inputString.split(".")) {
        size == 4 && all {
            try { Integer.parseInt(it) in 0..255 } catch (_:Exception) { false }
        }
    }
}

// 22. Avoid Obstacles
// You are given an array of integers representing coordinates of obstacles situated on a straight line.
// Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to
// make jumps of the same length represented by some integer.
// Find the minimal length of the jump enough to avoid all the obstacles.
fun avoidObstacles(inputArray: MutableList<Int>): Int {
    var jump = 1
    var cStep = 0
    while (true) {
        cStep += jump
        if (inputArray.indexOf(cStep) == -1) {
            if (cStep < inputArray.max()!!)
                continue
            else
                return jump
        }

        cStep = 0
        jump ++
    }
}

// 23. Box Blur
// Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral!
// You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its content.
// The pixels in the input image are represented as integers. The algorithm distorts the input image in the
// following way: Every pixel x in the output image has a value equal to the average value of the pixel values
// from the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then removed.
// Return the blurred image as an integer, with the fractions rounded down.
fun boxBlur(image: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    return (0..image.size-3).map { y ->
        (0..image[0].size-3).map { x ->
            image.subList(y, y+3).sumBy { it.subList(x, x+3).sum() } / 9
        }.toMutableList()
    }.toMutableList()
}

// 24. Minesweeper
// In the popular Minesweeper game you have a board with some mines and those cells that don't contain a
// mine have a number in it that indicates the total number of mines in the neighboring cells.
// Starting off with some arrangement of mines we want to create a Minesweeper game setup.
fun minesweeper(matrix: MutableList<MutableList<Boolean>>): MutableList<MutableList<Int>> {
    return matrix.mapIndexed { y, row ->
        row.mapIndexed { x, _ ->
            var count = 0
            (-1..1).forEach { dy -> (-1..1).forEach { dx ->
                if (!(dy == 0 && dx == 0) && x + dx >= 0 && x + dx < row.size && y + dy >= 0 && y + dy < matrix.size && matrix[y + dy][x + dx])
                    count++
            } }

            count
        }.toMutableList()
    }.toMutableList()
}

