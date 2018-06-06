public class LinkedListDeque<T> {
    public static class Node {
        public Node prev;
        public T item;
        public Node next;
        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(this, 0, this);
        size = 0;
    }

    public boolean isEmpty() {
        return (sentinel.next == this);
    }

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

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
            System.out.print(p.item + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            // TODO: finish removeFirst
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            // TODO: finish removeLast
        }
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null
        } else {
            // TODO: finish get
        }
    }

    public T getRecursive(int index) {
        // TODO: finish getRecursive
    }
}