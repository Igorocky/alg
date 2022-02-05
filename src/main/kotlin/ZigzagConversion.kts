import org.apache.commons.lang3.RandomStringUtils
import org.apache.commons.lang3.RandomUtils
import kotlin.math.max


/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
interface ISolution {
    fun convert(s: String, numRows: Int): String
}

class Solution : ISolution {
    override fun convert(s: String, numRows: Int): String {
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

class Solution2 : ISolution {
    override fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val buffs = Array(numRows){StringBuilder()}
        var buffIdx = 0
        var dir = 1
        for (i in 0 until s.length) {
            buffs[buffIdx].append(s[i])
            buffIdx += dir
            if (buffIdx >= numRows) {
                buffIdx = numRows - 2
                dir = -1
            } else if (buffIdx < 0) {
                buffIdx = 1
                dir = 1
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

fun compareSolutions(s1: ISolution, s2: ISolution) {
    for (i in 1 .. 1000) {
        val str = RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(1,1000))
        val n = RandomUtils.nextInt(1,1000)
        val r1 = s1.convert(str, n)
        val r2 = s2.convert(str, n)
        if (r1 != r2) {
            throw RuntimeException(
                """
                A mismatch found for:
                s = '$str'
                n = $n
                    r1 = '$r1' 
                    r2 = '$r2' 
                """.trimIndent()
            )
        }
    }
}

assertEquals("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR")
assertEquals("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
assertEquals("A", 1, "A")

compareSolutions(Solution(), Solution2())

println("All passed.")