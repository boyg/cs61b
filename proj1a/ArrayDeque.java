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

    // TODO: Fix printDeque()
    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }

    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        int i = nextFirst + 1;
        int j = 0;
        while (j < size) {
            a[j] = items[i % items.length];
            i++;
            j++;
        }
        nextFirst = a.length - 1;
        nextLast = size;
        items = a;
    }

    private float usageRatio() {
        System.out.println(size / items.length);
        return (float) size / items.length;
    }

    private void checkSize() {
        if (size == items.length) {
            resize(items.length * 2);
        } else if (items.length > 8 && usageRatio() < 0.25 ) {
            resize(items.length / 2);
        }
    }

    public void addFirst(T item) {
        checkSize();
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    public void addLast(T item) {
        checkSize();
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
        ad.addFirst('a');
        ad.addLast('b');
        ad.addFirst('c');
        ad.addLast('d');
        ad.addFirst('e');
        ad.addLast('f');
        ad.addFirst('g');
        ad.addLast('h');
        ad.addFirst('i');
        ad.addLast('j');
        ad.addFirst('k');
        ad.addFirst('l');
        ad.addFirst('m');
        ad.addFirst('n');
        ad.addLast('o');
        ad.addLast('p');
        ad.addLast('q');
        ad.printDeque();
    }
}
