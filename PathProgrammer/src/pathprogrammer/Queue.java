package pathprogrammer;

import java.lang.reflect.Array;

/**
 * A queue data type to store information for this project.
 * 
 * @param <T>
 *            type of stored data
 * @author Group 7
 * @version 5 Nov 2026
 */
public class Queue<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * initializes the queue
     */
    public Queue()
    {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * @param value
     *            data to add to the queue
     */
    public void enqueue(T value)
    {
        Node<T> newNode = new Node<>(value);

        if (tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }


    /**
     * removes the top value from the queue and returns it
     * 
     * @return the value of the top element in the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Cannot dequeue an empty queue");
        }

        T data = head.getData();

        head = head.getNext();
        if (head == null)
        {
            tail = null;
        }
        size--;

        return data;
    }


    /**
     * returns the top of the queue without modifying it
     * 
     * @return the value of the top element in the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T peek()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Cannot peek at an empty queue");
        }

        return head.getData();
    }


    /**
     * clears the queue of all data
     */
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * @return true if there are no elements in the queue
     */
    public boolean isEmpty()
    {
        return head == null;
    }


    /**
     * @return the number of values in the queue
     */
    public int size()
    {
        return size;
    }


    /**
     * @return the queue in the form of an array
     */
    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> type)
    {
        T[] array = (T[]) Array.newInstance(type, size);

        Node<T> currNode = head;
        int index = 0;

        while (currNode != null)
        {
            array[index] = currNode.getData();

            currNode = currNode.getNext();
            index++;
        }

        return array;
    }
}
