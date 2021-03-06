/** A double-ended queue implemented using an array.
 *  @author Steve Farra
 */

public class ArrayDeque<T> implements Deque<T> {
    /** Array holding the data. */
    private T[] items;
    /** Number of items in the deque. */
    private int size;
    /** Index of the next item to be added to the front of the queue. */
    private int nextFirst;
    /** Index of the next item to be added to the back of the queue. */
    private int nextLast;
    /** Index of the first item in the queue. */
    private int first;

    /** Instantiates the fields for an ArrayDeque. */
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to
     *  last, separated by a space.
     */
    @Override
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

    /** Retrieves an item from the deque.
     *  @param index the index of the item to be returned.
     *  0 is the first item, 1 is the second, and so forth.
     *  @return the item at the specified index.
     */
    @Override
    public T get(int index) {
        if (isEmpty() || index > size - 1) {
            return null;
        } else {
            return items[(first + index) % items.length];
        }

    }

    /** A utility method for changing the size of the items
     *  array.
     *  @param capacity the size of the new array.
     */
    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        int i = first;
        int j = 0;
        while (j < size) {
            a[j] = items[i % items.length];
            i++;
            j++;
        }
        nextFirst = a.length - 1;
        nextLast = size;
        first = 0;
        items = a;
    }

    /** A utility method for determining how filled the
     *  items array is.
     *  @return the ratio of items in the array to the array
     *  size.
     */
    private float getUsageRatio() {
        return (float) size / items.length;
    }

    /** A utility method for checking whether the items
     *  array needs to be sized up or down. */
    private void checkForResize() {
        if (size == items.length) {
            resize(items.length * 2);
        } else if (items.length > 8 && getUsageRatio() < 0.25) {
            resize(items.length / 2);
        }
    }

    /** Adds an item of type T to the front of the deque.
     *  @param item the item to be added to the front of
     *  the deque.
     */
    @Override
    public void addFirst(T item) {
        checkForResize();
        items[nextFirst] = item;
        first = nextFirst;
        size++;
        nextFirst--;
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
    }

    /** Adds an item of type T to the front of the deque.
     *  @param item the item to be added to the front of
     *  the deque.
     */
    @Override
    public void addLast(T item) {
        checkForResize();
        items[nextLast] = item;
        if (isEmpty()) {
            first = nextLast;
        }
        size++;
        nextLast++;
        if (nextLast == items.length) {
            nextLast = 0;
        }
    }

    /** Removes and returns the item at the front of the
     *  deque. If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst++;
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        first++;
        if (first == items.length) {
            first = 0;
        }
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        checkForResize();
        return item;
    }

    /** Removes and returns the item at the back of the
     *  deque. If no such item exists, returns null. */
    @Override
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
        checkForResize();
        return item;
    }
}
