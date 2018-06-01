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
        sentinel = new IntNode(null, -1, null);
        size = 0;
    }
}