import java.io.PrintStream;
import java.util.NoSuchElementException;


// Generic implementation of a double-ended queue
public class GenericDoubleEndedQueueImpl<T> implements GenericDoubleEndedQueue<T> {

    private Node<T> head; // The head node of the queue
    private Node<T> tail; // The tail node of the queue
    private int size;     // The number of elements in the queue

    // A static inner class representing a node in the queue
    private static class Node<T> {
        T data;           // The data held by the node, of generic type T
        Node<T> next;     // Reference to the next node in the queue
        Node<T> prev;     // Reference to the previous node in the queue

        // Constructor for the node
        Node(T data) {
            this.data = data; // Set the data of the node
        }
    }

    // Constructor for the generic double-ended queue
    public GenericDoubleEndedQueueImpl() {
        this.head = this.tail = null; // Initially, both head and tail are null
        this.size = 0;                // The queue size is initialized to 0
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0; // Returns true if the queue size is 0
    }

    // ... Additional methods would go here ...
}
