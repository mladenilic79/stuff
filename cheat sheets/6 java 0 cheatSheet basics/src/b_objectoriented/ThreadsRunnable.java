
package b_objectoriented;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

// runnable class holds methods for concurrent running
public class ThreadsRunnable implements Runnable{
    
    static ArrayList<Integer> brojevii;
    public ThreadsRunnable() {
    }
    public ThreadsRunnable(ArrayList<Integer> brojevii) {
        this.brojevii = brojevii;
    }

    // Creates a lock for your method
    ReentrantLock lock = new ReentrantLock();
    
    /*
    By putting synchronized keyword before a method, you make sure only one 
    thread at a time can execute it.
    synchronized keyword can be put in front of any method that is called from
    	run method
    synchronized keyword can be put also in block of code (faster option)
    Synchronizing slows down Java, so it should only be used when necessary
    */
    @Override
    /* synchronized */ public void run() {
        
        System.out.println("id " + Thread.currentThread().getId());
        System.out.println("priority " + Thread.currentThread().getPriority());
        System.out.println("state " + Thread.currentThread().getState());
        System.out.println("name " + Thread.currentThread().getName());
        
        /*
        this locks/unlocks the method just like synchronized. You can't use
        synchronized and lock, that's why synchronized is commented out
        */
        lock.lock();
        System.out.println("thread");
        lock.unlock();
        
        /*
        synchronized in parameter store variables 
        that should not be accessed simultaniously
        (this. for self object or some randVar for instance etc..)
        while synchonized executes
        */

        synchronized(brojevii){
            
            brojevii.add(4);
            brojevii.add(5);
            brojevii.add(6);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            brojevii.add(7);
            brojevii.add(8);
            brojevii.add(9);
            
            // notify any one method waiting
            brojevii.notify();
            // notify all methods waiting
//            brojevii.notifyAll();
        }
    }
}
