import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testEmptyString() {
        assertEquals(true, palindrome.isPalindrome(""));
    }

    @Test
    public void testSingleChar() {
        assertEquals(true, palindrome.isPalindrome(""));
    }

    @Test
    public void testPalindromes() {
        assertEquals(true, palindrome.isPalindrome("racecar"));
        assertEquals(true, palindrome.isPalindrome("noon"));
    }

    @Test
    public void testNonPalindromes() {
        assertEquals(false, palindrome.isPalindrome("horse"));
        assertEquals(false, palindrome.isPalindrome("aaaaab"));
    }
}