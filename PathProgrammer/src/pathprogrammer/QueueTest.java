package pathprogrammer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  Tests the Queue class for all behaviors.
 * 
 *  @author Group 7
 *  @version 5 Nov 2026
 */
class QueueTest
{
    private Queue<String> queue;

    /**
     * sets up queue for each test
     */
    @BeforeEach
    void setUp()
    {
        queue = new Queue<String>();
    }

    /**
     * tests basic queue methods
     */
    @Test
    void testQueue()
    {
        queue.enqueue("hi");
        queue.enqueue("hello");

        assertFalse(queue.isEmpty());

        assertEquals("hi", queue.peek());
        assertEquals("hi", queue.dequeue());
        assertEquals("hello", queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    /**
     * tests the clear method
     */
    @Test
    void testClear()
    {
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        assertFalse(queue.isEmpty());

        queue.clear();

        assertTrue(queue.isEmpty());
    }

    /**
     * tests all possible thrown exceptions
     */
    @Test
    void testExceptions()
    {
        RuntimeException exception = null;

        try
        {
            queue.dequeue();
        }
        catch (RuntimeException e)
        {
            exception = e;
        }

        assertNotNull(exception);

        exception = null;

        try
        {
            queue.peek();
        }
        catch (RuntimeException e)
        {
            exception = e;
        }

        assertNotNull(exception);
    }

    /**
     * tests the toArray implementation
     */
    @Test
    void testToArray()
    {
        String[] emptyArray = new String[0];

        assertTrue(Arrays.equals(emptyArray, queue.toArray()));

        queue.enqueue("orange");
        queue.enqueue("yellow");
        queue.enqueue("green");
        queue.enqueue("purple");

        String[] fullArray = { "orange", "yellow", "green", "purple" };

        assertTrue(Arrays.equals(fullArray, queue.toArray()));
    }
}
