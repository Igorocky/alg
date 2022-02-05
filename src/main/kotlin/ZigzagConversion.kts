import java.lang.RuntimeException
import java.lang.StringBuilder
import kotlin.math.max

class Solution {
    fun convert(s: String, numRows: Int): String {
        val buffs = Array(numRows){StringBuilder()}
        val period = max(numRows*2-2,1)
        for (i in 0..(s.length-1)/period) {
            for (j in 0 until numRows) {
                val charIdx1 = i * period + j
                if (charIdx1 < s.length) {
                    buffs[j].append(s[charIdx1])
                }
                if (0 < j && j < numRows-1) {
                    val charIdx2 = (i + 1) * period - j
                    if (charIdx2 < s.length) {
                        buffs[j].append(s[charIdx2])
                    }
                }
            }
        }
        return buffs.asSequence().joinToString(separator = "") { it.toString() }
    }
}

fun assertEquals(s: String, numRows: Int, expectedOutput: String) {
    val actual = Solution().convert(s, numRows)
    if (expectedOutput != actual) {
        throw RuntimeException("""
            Expected: $expectedOutput
            Actual:   $actual
            """.trimIndent())
    }
}

assertEquals("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR")
assertEquals("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
assertEquals("A", 1, "A")
println("All passed.")