import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertEquals(true, offBy5.equalChars('a', 'f'));
        assertEquals(true, offBy5.equalChars('f', 'a'));
    }

    @Test
    public void testNotEqualChars() {
        assertEquals(false, offBy5.equalChars('f', 'h'));
    }
}
