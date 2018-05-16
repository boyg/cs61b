public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    
    private IntNode first;
    private int size;

    public SLList() {
        first = null;
        size = 0;
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x) {
        if (first == null) {
            first = new IntNode(x, null);
        } else {
            IntNode p = first;
            
            while (p.next != null) {
                p = p.next;
            }
            p.next = new IntNode(x, null);
        }
        size += 1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList l = new SLList();
        l.addFirst(3);
        SLList l2 = new SLList();
        l2.addLast(6);
        System.out.println("l: " + l.getFirst());
        System.out.println("l2: " + l2.getFirst());
    }
}