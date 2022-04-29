import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
    @Test
    public  void testConstruct(){
        MyQueue<String> s = new MyQueue<>(10);
        assertEquals(s.getDelay(),10);
        assertEquals(s.size(),0);
        assertEquals(s.getMaximumDelay(),10);
        MyQueue<String> s1 = new MyQueue<>(-10);
        assertEquals(s1.getDelay(),0);
        assertEquals(s1.getMaximumDelay(),-10);
        assertEquals(s1.size(),0);
        s.enqueue("a");
        s.enqueue("a");
        s.enqueue("a");
        assertEquals(s.size(),3);
        s.enqueue(null);
        assertEquals(s.size(),4);
        assertNotEquals(s.size(),5);

    }
    @Test
    public  void testPushPeek(){
        MyQueue<String> s = new MyQueue<>(5);
        s.enqueue("a");
        s.enqueue("b");
        s.enqueue("c");
        assertSame(null,s.dequeue());
        s.enqueue(null);
        s.enqueue("d");
        s.enqueue("e");
        assertSame("a",s.dequeue());
        assertSame("b",s.dequeue());
        assertSame("c",s.dequeue());
        s.enqueue("f");
        assertSame(null,s.dequeue());
    }
    @Test
    public  void testPop(){
        MyQueue<String> s = new MyQueue<>(5);
        s.enqueue("ab");
        s.enqueue("c");
        s.enqueue("f");
        s.enqueue("f");
        assertEquals(4,s.size());
        assertSame(s.dequeue(),null);
        s.enqueue("f");
        assertEquals(5,s.size());
        assertSame(s.dequeue(),"ab");
        assertSame(s.dequeue(),"c");
        assertEquals(0,s.getDelay());
        s.enqueue("g");
        assertSame(s.dequeue(),null);
        assertEquals(4,s.getDelay());
        assertEquals(5,s.getMaximumDelay());
        s.setMaximumDelay(10);
        assertEquals(10,s.getMaximumDelay());
        assertEquals(4,s.getDelay());
        s.enqueue("k");
        assertEquals(3,s.getDelay());
        s.enqueue("k");
        s.enqueue("k");
        s.enqueue("k");
        s.enqueue("k");
        s.dequeue();
        assertEquals(0,s.getDelay());
        MyQueue<String> s2 = new MyQueue<>(0);
        s2.enqueue("a");
        try{
            s2.dequeue();
            s2.dequeue();
            s2.dequeue();
        }catch(IllegalStateException e){
            return;
        }
        throw new RuntimeException("should be exception!");
    }
    @Test
    public  void testPeek(){
        MyQueue<String> s = new MyQueue<>(3);
        s.enqueue("a1");
        assertSame("a1",s.peek());
        assertEquals(s.size(),1);
        s.enqueue("a2");
        s.enqueue("a3");
        assertEquals("a1",s.peek());
        assertEquals(3,s.size());
        assertEquals(0,s.getDelay());
        s.setMaximumDelay(10);
        assertEquals(0,s.getDelay());
        assertEquals(10,s.getMaximumDelay());
        s.enqueue("b");
        assertEquals(0,s.getDelay());
        MyQueue<String> s2 = new MyQueue<>(15);
        assertEquals(14,s2.getDelay());

    }
    @Test
    public  void testClear(){
        MyQueue<String> s = new MyQueue<>(3);
        assertTrue(s.clear());
        assertFalse(s.check());
        s.enqueue("a");
        s.enqueue("a");
        assertFalse(s.clear());
        s.enqueue("a");
        s.dequeue();
        assertTrue(s.clear());
        assertEquals(0,s.size());
        s.setMaximumDelay(10);
        assertEquals(0,s.getDelay());
        assertEquals(10,s.getMaximumDelay());
        s.enqueue("b");
        assertEquals(9,s.getDelay());
        MyQueue<String> s2 = new MyQueue<>(3);
        try{
            s2.peek();
        }catch (IllegalStateException e){
            return;
        }
    }
    @Test
    public  void testContains(){
        MyQueue<String> s = new MyQueue<>(3);
        assertFalse(s.contains(null));
        s.enqueue("a");
        s.enqueue("b");
        assertTrue(s.contains("b"));
        s.enqueue(null);
        assertTrue(s.contains(null));
        assertFalse(s.contains("null"));
    }

}

