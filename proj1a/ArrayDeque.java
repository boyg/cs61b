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

    private float getUsageRatio() {
        return (float) size / items.length;
    }

    private void checkSize() {
        if (size == items.length) {
            resize(items.length * 2);
        } else if (items.length > 8 && getUsageRatio() < 0.25 ) {
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

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst++;
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        checkSize();
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast--;
        if (nextLast == -1) {
            nextLast = items.length - 1;
        }
        T item = items[nextLast];
        items[nextLast] = null;
        size--;
        checkSize();
        return item;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        int i;
        for (i = 50; i >= 0; i--) {
            ad.addFirst(i);
        }
        for (i = 51; i <= 100; i++) {
            ad.addLast(i);
        }
        for (i = 0; i <= 25; i++) {
            ad.removeFirst();
        }
        for (i = 26; i <= 100; i++) {
            ad.removeLast();
        }
    }
}
