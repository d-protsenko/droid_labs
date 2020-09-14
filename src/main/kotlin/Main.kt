import java.math.BigInteger

fun main(args: Array<String>) {
    println(JavaPrepared.factorial(10))
}

class JavaPrepared {
    companion object {
        fun booleanExpression(a: Boolean, b: Boolean, c: Boolean, d: Boolean): Boolean {
            return (a and b) or (a and c) or (a and d) or (b and c) or (b and d) or (c and d)
        }

        fun leapYearCount(year: Int): Int {
            if (year < 4) return 0
            var temp = 0
            var tmpYear = 0
            while (tmpYear < year) {
                tmpYear += 4
                temp += 1
            }
            return temp
        }

        fun isPowerOfTwo(i: Int): Boolean {
            val bits = java.lang.Float.floatToIntBits(i.toFloat())
            if (bits and (1 shl 23) - 1 != 0) return bits and bits - 1 == 0
            val power = bits ushr 23
            return power in 1..254
        }

        fun flipBit(value: Int, bitIndex: Int): Int {
            return BigInteger.valueOf(value.toLong()).flipBit(bitIndex).intValueExact()
        }

        fun isPalindrome(inputStr: String): Boolean {
            val sb = StringBuilder(inputStr.trim().replace("[^a-zA-Z0-9]", ""))

            val reverseStr = sb.reverse().toString()

            return inputStr.equals(reverseStr, ignoreCase = true)
        }

        fun factorial(value: Int): BigInteger {
            if (value < 0) throw RuntimeException()
            return if (value == 1)
                BigInteger.ONE
            else
                factorial(value - 1).multiply(BigInteger.valueOf(value.toLong()))
        }

        fun mergeArray(nums1: Array<Int>, nums2: Array<Int>) : Array<Int> {
            var m = nums1.size
            var n = nums2.size
            var idx = m + n - 1
            val nums: Array<Int> = Array(n + m) { 0 }
            while (m > 0 && n > 0) {
                nums[idx--] = if (nums1[m - 1] > nums2[n - 1]) nums1[m-- - 1] else nums2[n-- - 1]
            }

            for (i in 0 until n) nums1[i] = nums2[i]
            return nums
        }
    }
}