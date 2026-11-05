package pathprogrammer;

public class Queue<T>
{
    private Node<T> head;

    public Queue()
    {
        head = null;
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
    }
}
