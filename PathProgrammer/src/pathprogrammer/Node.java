package pathprogrammer;

/**
 * A singular node to be used in the LinkedQueue data structure
 * 
 * @param <T>
 *            the type of data to be stored
 * @author Group 7
 * @version 5 Nov 2026
 */
public class Node<T>
{
    private T data;
    private Node<T> next;

    /**
     * creates a new node object
     * 
     * @param data
     * @param next
     */
    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }


    /**
     * overloaded constructor with no next node
     * 
     * @param data
     */
    public Node(T data)
    {
        this(data, null);
    }


    /**
     * returns the node's data
     * 
     * @return data
     */
    public T getData()
    {
        return data;
    }


    /**
     * returns the next node
     * 
     * @return next
     */
    public Node<T> getNext()
    {
        return next;
    }


    /**
     * @param next
     *            a new node to set as this one's next
     */
    public void setNext(Node<T> next)
    {
        this.next = next;
    }

}
