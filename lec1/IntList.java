public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    /** Returns the number of integers in the list. */
    public int size() {
        if (rest == null) {
            return 1;
        } else {
            return 1 + this.rest.size();
        }
    }

    /** Returns the number of integers in the list. */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the 'i'th entry in the list. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L = new IntList(7, L);
        L = new IntList(15, L);
        
        System.out.println("Size of list (using recursion):" + L.size());
        System.out.println("Size of list (using iteration):" + L.iterativeSize());
        System.out.println("1st item in list (with 0-indexing):" + L.get(1));
    }
}