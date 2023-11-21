import java.io.PrintStream;
import java.util.NoSuchElementException;


public class GenericDoubleEndedQueueImpl<T> implements GenericDoubleEndedQueue<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }
}