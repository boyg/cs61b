# Deque

A Deque (short for double-ended queue) is a sequence of containers with dynamic sizes that can be expanded or 
contracted on both ends (either its front or its back). Linked list and array implementations of the deque are
included.

## The Deque API

`LinkedListDeque()`: Creates an empty linked list deque.

`ArrayDeque()`: Creates an empty array deque.
***
`void addFirst(T item)`: Adds an item of type `T` to the front of the deque.

`void addLast(T item)`: Adds an item of type `T` to the back of the deque.

`boolean isEmpty()`: Returns true if the deque is empty, false otherwise.

`int size()`: Returns the size of the deque.

`void printDeque()`: Prints the items in the deque from first to last, separated by a space.

`T removeFirst()`: Removes and returns the item at the front of the deque. If no such item exists, returns null.

`T removeLast()`: Removes and returns the item at the back of the deque. If no such item exists, returns null.

`T get(int index)`: Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
If no such item exists, returns null.

## Credits
The LinkedListDequeTest.java source file and autograder provided by Berkeley's data structures course — CS61B — helped
validate the deque implementations. The rest of the code was written independently by me.
