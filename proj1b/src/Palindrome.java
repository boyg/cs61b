public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new ArrayDeque<Character>();

        for(int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private boolean isPalindrome(Deque d) {
        if (d.isEmpty() || d.size() == 1) {
            return true;
        } else if (d.removeFirst() != d.removeLast()) {
            return false;
        } else {
            return isPalindrome(d);
        }
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        } else {
            return isPalindrome(wordToDeque(word));
        }
    }
}
