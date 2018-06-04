public class LinkedListDeque<DataType> {
    public class IntNode {
        public IntNode prev;
        public DataType item;
        public IntNode next;
        public IntNode(IntNode p, DataType i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(this, -1, this);
        size = 0;
    }

    public void addFirst(T item) {
        if (sentinel.next == this) {
            sentinel.next = new IntNode(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            IntNode p = sentinel.next;
            // continue here
        }
    }
}