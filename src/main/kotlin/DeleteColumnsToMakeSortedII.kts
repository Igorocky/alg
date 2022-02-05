/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        if (strs.size <= 1 || strs[0].isEmpty()) {
            return 0
        }

        val eqIdxs = IntRange(0,strs.size-2).toMutableSet()
        var c = 0
        var res = 0
        while (eqIdxs.isNotEmpty() && c < strs[0].length) {
            var idxsToRemove: HashSet<Int>? = HashSet()
            for (i in eqIdxs) {
                val left = strs[i][c]
                val right = strs[i + 1][c]
                if (left > right) {
                    res++
                    idxsToRemove = null
                    break
                } else if (left < right) {
                    idxsToRemove?.add(i)
                }
            }
            c++
            if (idxsToRemove != null) {
                eqIdxs.removeAll(idxsToRemove)
            }
        }
        return res
    }
}

fun assertEquals(strs: Array<String>, expectedOutput: Int) {
    val actual = Solution().minDeletionSize(strs)
    if (expectedOutput != actual) {
        throw RuntimeException(
            """
            
            Expected: $expectedOutput
            Actual:   $actual
            """.trimIndent()
        )
    }
}

assertEquals(arrayOf("ca","bb","ac"), 1)
assertEquals(arrayOf("xc","yb","za"), 0)
assertEquals(arrayOf("zyx","wvu","tsr"), 3)
assertEquals(arrayOf("abx","agz","bgc","bfc"), 1)

println("All passed.")