package pathprogrammer;

public class Queue<T>
{
    private Node<T> head;
    private int size;

    public Queue()
    {
        head = null;
        size = 0;
    }


    public void enqueue(T value)
    {
        Node<T> newNode = new Node<T>(value);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node<T> currNode = head;
            while (currNode.getNext() != null)
            {
                currNode = currNode.getNext();
            }
            currNode.setNext(newNode);
        }

        size++;
    }


    public T dequeue()
    {
        if (head == null)
        {
            return null;
        }

        Node<T> previousNode = null;
        Node<T> currNode = head;

        while (currNode.getNext() != null)
        {
            previousNode = currNode;
            currNode = currNode.getNext();
        }

        if (previousNode != null)
        {
            previousNode.setNext(null);
        }
        else
        {
            head = null;
        }

        size--;
        return currNode.getData();
    }


    public T peek()
    {
        if (head == null)
        {
            return null;
        }

        Node<T> currNode = head;

        while (currNode.getNext() != null)
        {
            currNode = currNode.getNext();
        }

        return currNode.getData();
    }


    public void clear()
    {
        head = null;
        size = 0;
    }


    public boolean isEmpty()
    {
        return head == null;
    }


    @SuppressWarnings("unchecked")
    public T[] toArray()
    {
        T[] array = (T[])new Object[size];

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
