package pathprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest
{
    private Queue<String> queue;

    @BeforeEach
    void setUp()
    {
        queue = new Queue<String>();
    }


    @Test
    void test()
    {
        queue.enqueue("hi");
        queue.enqueue("hello");
        
        assertFalse(queue.isEmpty());
        
        assertEquals("hello", queue.peek());
        assertEquals("hello", queue.dequeue());
        assertEquals("hi", queue.dequeue());
        
        assertTrue(queue.isEmpty());
    }
}
