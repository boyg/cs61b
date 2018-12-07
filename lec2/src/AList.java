/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> implements List61B<Item> {
    Item[] items;
    int size;

    /** Creates an empty list of size 100. */
    public AList() {
        items = (Item []) new Object[100];
        size = 0;
    }

    /** Resizes items to be of length capacity. */
    private void resize(int capacity) {
        Item[] a = (Item []) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        size--;
        return items[size];
    }
} 