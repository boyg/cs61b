public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }

    private void resize(int capacity) {
        // TODO: Implement resize
        return;
    }

    private float usageRatio() {
        return size / items.length;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        } else if (usageRatio() < 0.25 ) {
            resize(items.length / 2);
        }
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        } else if (usageRatio() < 0.25 ) {
            resize(items.length / 2);
        }
        if (nextLast == items.length) {
            nextLast = 0;
        }
        items[nextLast] = item;
        nextLast++;
        size++;
    }

    /** For debugging */
    private void setNextLast(int num) {
        nextLast = num;
    }
    private void setNextFirst(int num) {
        nextFirst = num;
    }

    public static void main(String[] args) {
        ArrayDeque<Character> ad = new ArrayDeque<Character>();
        ad.setNextLast(5);
        ad.setNextFirst(4);
        ad.addLast('a');
        ad.addFirst('b');
        ad.addLast('c');
        ad.addFirst('d');
        ad.addFirst('e');
        ad.addLast('f');
        ad.addLast('g');
        ad.printDeque();
    }
}
