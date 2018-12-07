public class SLList<Item> implements List61B<Item> {
    public class IntNode {
        public Item item;
        public IntNode next;
        public IntNode(Item i, IntNode n) {
            item = i;
            next = n;
        }
    }
    
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public SLList(Item x) {
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(Item x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public Item getFirst() {
        return sentinel.next.item;
    }

    @Override
    public void addLast(Item x) {
        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList l = new SLList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addFirst(0);
        l.getFirst();
        l.size();
    }
}