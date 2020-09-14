import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MainTest {

    @Test
    fun testBooleanExpression() {
        assertTrue(JavaPrepared.booleanExpression(a = true, b = true, c = false, d = false))
        assertTrue(JavaPrepared.booleanExpression(a = true, b = false, c = true, d = false))
        assertTrue(JavaPrepared.booleanExpression(a = true, b = false, c = false, d = true))
        assertTrue(JavaPrepared.booleanExpression(a = false, b = true, c = true, d = false))
        assertTrue(JavaPrepared.booleanExpression(a = false, b = true, c = false, d = true))
        assertTrue(JavaPrepared.booleanExpression(a = false, b = false, c = true, d = true))
        assertFalse(JavaPrepared.booleanExpression(a = true, b = false, c = false, d = false))
        assertFalse(JavaPrepared.booleanExpression(a = false, b = false, c = true, d = false))
        assertFalse(JavaPrepared.booleanExpression(a = false, b = false, c = false, d = false))
    }

    @Test
    fun testLeapYearCount() {
        assertEquals(0, JavaPrepared.leapYearCount(3))
        assertEquals(4, JavaPrepared.leapYearCount(16))
        assertEquals(100, JavaPrepared.leapYearCount(400))
        assertEquals(500, JavaPrepared.leapYearCount(2000))
    }

    @Test
    fun testFlipBit() {
        assertEquals(522, JavaPrepared.flipBit(10, 9))
        assertEquals(1034, JavaPrepared.flipBit(10, 10))
        assertEquals(8, JavaPrepared.flipBit(10, 1))
        assertEquals(26, JavaPrepared.flipBit(10, 4))
    }

    @Test
    fun testIsPowerOfTwo() {
        assertTrue(JavaPrepared.isPowerOfTwo(1024))
        assertTrue(JavaPrepared.isPowerOfTwo(1048576))
        assertTrue(JavaPrepared.isPowerOfTwo(1073741824))
        assertFalse(JavaPrepared.isPowerOfTwo(12))
        assertFalse(JavaPrepared.isPowerOfTwo(321))
        assertFalse(JavaPrepared.isPowerOfTwo(4234))
    }

    @Test
    fun testIsPalindrome() {
        assertTrue(JavaPrepared.isPalindrome("radar"))
        assertTrue(JavaPrepared.isPalindrome("natan"))
        assertFalse(JavaPrepared.isPalindrome("dasq"))
        assertFalse(JavaPrepared.isPalindrome("ffffz"))
    }

    @Test
    fun testFactorial() {
        assertEquals(BigInteger.valueOf(3628800L), JavaPrepared.factorial(10))
        assertEquals(BigInteger.valueOf(120L), JavaPrepared.factorial(5))
    }

    @Test
    fun testFactorialException() {
        Assertions.assertThrows(RuntimeException::class.java) { JavaPrepared.factorial(-1) }
    }

    @Test
    fun testMergeArray() {
        arrayOf(1, 1, 2, 2, 3, 4) contentEquals
                JavaPrepared.mergeArray(
                    arrayOf(1, 2, 3),
                    arrayOf(1, 2, 4)
                )
        arrayOf(1, 1, 2, 3, 4, 4, 5, 6) contentEquals
                JavaPrepared.mergeArray(
                    arrayOf(1, 3, 4, 5, 6),
                    arrayOf(1, 2, 4)
                )
    }
}