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
        if (isEmpty()) {
            return;
        }
        int i = nextFirst + 1;
        int j = 0;
        while (j < size) {
            System.out.print(items[i % items.length] + " ");
            i++;
            j++;
        }
        System.out.println();
    }

    public T get(int index) {
        if (isEmpty() || index > size - 1) {
            return null;
        } else {
            return items[(nextFirst + index) % (items.length - 1)];
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
        ad.printDeque();
        ad.get(4);
        int i;
        for (i = 50; i >= 0; i--) {
            ad.addFirst(i);
        }
        ad.printDeque();
        for (i = 51; i <= 100; i++) {
            ad.addLast(i);
        }
        ad.printDeque();
        for (i = 0; i <= 25; i++) {
            ad.removeFirst();
        }
        ad.printDeque();
        for (i = 26; i <= 100; i++) {
            ad.removeLast();
            if (i == 72) {
                ad.printDeque();
                System.out.println(ad.get(5));
            }
        }
    }
}
