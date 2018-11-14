/** A double-ended queue implemented using a linked list of nodes.
 * @author Steve Farra */
public class LinkedListDeque<T> {
    /** Node class for holding the data. */
    private class Node {
        /** A pointer to the previous node. */
        public Node prev;
        /** The data in the node. */
        public T item;
        /** A pointer to the next node. */
        public Node next;
        /** Instantiates the fields for a node.
         *  @param p a pointer to the previous node.
         *  @param i the data in the node.
         *  @param n a pointer to the next node.
         */
        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** A node used to assist in the construction and maintenance
     * of the deque.
     */
    private Node sentinel;
    /** The number of items currently in the deque. */
    private int size;

    /** Instantiates the fields for a LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new Node(sentinel, null, sentinel);
        size = 0;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Adds an item of type T to the front of the deque.
     *  @param item the item to be added to the front of
     *  the deque.
     */
    public void addFirst(T item) {
        if (isEmpty()) {
            sentinel.next = new Node(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            Node p = sentinel.next;
            sentinel.next = new Node(sentinel, item, p);
            p.prev = sentinel.next;
        }
        size++;
    }

    /** Adds an item of type T to the front of the deque.
     *  @param item the item to be added to the front of
     *  the deque.
     */
    public void addLast(T item) {
        if (isEmpty()) {
            sentinel.next = new Node(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            Node p = sentinel.prev;
            sentinel.prev = new Node(p, item, sentinel);
            p.next = sentinel.prev;
        }
        size++;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to
     * last, separated by a space.
     */
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        Node p = sentinel;
        while (p.next.item != null) {
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the
     * deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T frontItem = sentinel.next.item;
        if (size == 1) {
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
        } else {
            Node p = sentinel.next.next;
            sentinel.next = p;
            p.prev = sentinel;
        }
        size--;
        return frontItem;
    }

    /** Removes and returns the item at the back of the
     * deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T backItem = sentinel.prev.item;
        if (size == 1) {
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
        } else {
            Node p = sentinel.prev.prev;
            sentinel.prev = p;
            p.next = sentinel;
        }
        size--;
        return backItem;
    }

    /** Retrieves an item from the deque.
     *  @param index the index of the item to be returned.
     *  0 is the first item, 1 is the second, and so forth.
     *  @return the item at the specified index.
     */
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        } else {
            int i = 0;
            Node p = sentinel.next;
            while (i < index) {
                p = p.next;
                i++;
            }
            return p.item;
        }
    }

    /** Utility method for performing recursion for getRecursive.
     * @param p a pointer to the node on the current recursive layer.
     *  @param index the index on the current recursive layer.
     *  @return the item at the specified index.
     */
    private T getRecursive(Node p, int index) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursive(p.next, index - 1);
        }
    }

    /** Recursively retrieves an item from the deque.
     *  @param index the index of the item to be returned.
     *  0 is the first item, 1 is the second, and so forth.
     *  @return the item at the specified index.
     */
    public T getRecursive(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        } else {
            return getRecursive(sentinel.next, index);
        }
    }
}
