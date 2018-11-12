public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        if (nextFirst >= 0) {
            items[nextFirst] = item;
            nextFirst--;
            size++;
        } else {
            System.out.println("Cannot add item! Front of deque is full.");
        }
    }

    public void addLast(T item) {
        if (nextLast <= 7) {
            items[nextLast] = item;
            nextLast++;
            size++;
        } else {
            System.out.println("Cannot add item! Back of deque is full.");
        }
    }

    public T removeFirst() {
        if (nextFirst <= 3) {
            T item = items[nextFirst - 1];
            items[nextFirst - 1] = null;
            nextFirst++;
            size--;
            return item;
        } else {
            System.out.println("Cannot remove item! Front of deque is empty.");
            return null;
        }
    }

    public T removeLast() {
        if (nextLast >= 4) {
            T item = items[nextLast + 1];
            items[nextLast + 1] = null;
            nextLast--;
            size--;
            return item;
        } else {
            System.out.println("Cannot remove item! Back of deque is empty.");
            return null;
        }
    }

    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }
}
