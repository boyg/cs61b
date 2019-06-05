import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertEquals(true, offByOne.equalChars('a', 'b'));
        assertEquals(true, offByOne.equalChars('r', 'q'));
    }

    @Test
    public void testNotEqualChars() {
        assertEquals(false, offByOne.equalChars('a', 'e'));
        assertEquals(false, offByOne.equalChars('z', 'a'));
        assertEquals(false, offByOne.equalChars('a', 'a'));
    }
}
