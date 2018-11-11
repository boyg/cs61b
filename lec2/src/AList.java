/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    int[] items;
    int size;
    public static final int ALIST_SIZE = 100;
    public static final int NULL_ITEM = 0;

    /** Creates an empty list. */
    public AList() {
        items = new int[ALIST_SIZE];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == ALIST_SIZE) {
            return;
        } else {
            items[size] = x;
            size++;
        }
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        if (size == 0) {
            return NULL_ITEM;
        } else {
            return items[size - 1];
        }       
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if (i < 0 || i > size - 1) {
            return NULL_ITEM;
        } else {
            return items[i - 1];
        }        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        if (size == 0) {
            return NULL_ITEM;
        } else {
            size--;
            return items[size];
        }
    }
} 