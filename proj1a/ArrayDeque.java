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

    public static void main(String[] args) {
        ArrayDeque<Character> ad = new ArrayDeque<Character>();
        ad.isEmpty();
        ad.size();
        ad.addFirst('a');
        ad.isEmpty();
        ad.size();
        ad.addFirst('b');
        ad.addFirst('c');
        ad.addFirst('d');
        ad.printDeque();
    }
}
