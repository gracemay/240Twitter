//package TwitterAssignment;
/**
 * http://tutorials.jenkov.com/java-concurrency/locks.html
 */
public class Lock {
    
    private boolean locked = false;
    
    synchronized public void lock() throws InterruptedException
    {
        while (locked)
            wait();
        locked = true;
    }
    
    synchronized public void unlock()
    {
        locked = false;
        notify();
    }
    
}
