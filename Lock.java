package TwitterAssignment;
/**
 * http://tutorials.jenkov.com/java-concurrency/locks.html
 */
public class Lock {
    
    private boolean locked = false;
    
    /**
     * Locks the Lock, added for concurrency
     * @throws InterruptedException 
     */
    synchronized public void lock() throws InterruptedException
    {
        while (locked)
            wait();
        locked = true;
    }
    
    /**
     * Releases the Lock, allowing other threads to continue
     */
    synchronized public void unlock()
    {
        locked = false;
        notify();
    }
    
}
