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

    public void addFirst(T item) {
        // Create a new node with the provided item
        Node<T> newNode = new Node<>(item);
    
        // If the queue is empty, set both head and tail to the new node
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // If the queue is not empty, insert the new node at the beginning
            newNode.next = head; // Set the new node's next to the current head
            head.prev = newNode; // Set the current head's previous to the new node
            head = newNode;      // Update the head to be the new node
        }
    
        // Increment the size of the queue
        size++;
    }

    // Removes and returns the first item from the queue
    public T removeFirst() throws NoSuchElementException {
        // Check if the queue is empty; if so, throw an exception
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
    
        // Store the data of the head node to return later
        T item = head.data;
    
        // Move the head pointer to the next node in the queue
        head = head.next;
    
        // If the queue becomes empty after removing the node, set tail to null
        if (head == null) {
            tail = null;
        } else {
            // Otherwise, disconnect the new head from the old (now removed) head
            head.prev = null;
        }
    
        // Decrement the size of the queue
        size--;
    
        // Return the data of the removed node
        return item;
    }
    
    // Adds an item to the end of the queue
    public void addLast(T item) {
        // Create a new node with the given item
        Node<T> newNode = new Node<>(item);
    
        // Check if the queue is empty
        if (isEmpty()) {
            // If the queue is empty, the new node becomes both head and tail
            head = tail = newNode;
        } else {
            // If the queue is not empty, insert the new node at the end
            tail.next = newNode; // Link the current tail's next to the new node
            newNode.prev = tail; // Link the new node's previous to the current tail
            tail = newNode;      // Update the tail to be the new node
        }
    
        // Increment the size of the queue
        size++;
    }
    
    public T removeLast() throws NoSuchElementException {
        // Check if the queue is empty and throw an exception if it is
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
    
        // Store the data from the tail node to return later
        T item = tail.data;
    
        // Move the tail pointer to the previous node
        tail = tail.prev;
    
        // If the queue is now empty after removal, set head to null
        if (tail == null) {
            head = null;
        } else {
            // Otherwise, disconnect the new tail from the removed node
            tail.next = null;
        }
    
        // Decrement the size of the queue
        size--;
    
        // Return the data of the removed node
        return item;
    }

    // Returns the first item from the queue without removing it
    public T getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    // Returns the last item from the queue without removing it
    public T getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return tail.data;
    }
    
    // Prints all items in the queue from front to end
    public void printQueue(PrintStream stream) {
        Node<T> current = head;
        while (current != null) {
            stream.println(current.data);
            current = current.next;
        }
    }

    // Returns the size of the queue
    public int size() {
        return size;
    }

}
