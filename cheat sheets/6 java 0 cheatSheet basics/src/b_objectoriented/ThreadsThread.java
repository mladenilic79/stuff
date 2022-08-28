
package b_objectoriented;

import java.util.ArrayList;
// library for locking and unlocking methods
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsThread extends Thread{
    
    static ArrayList<Integer> brojevii;
    public ThreadsThread() {
    }
    public ThreadsThread(ArrayList<Integer> brojevii) {
        this.brojevii = brojevii;
    }

    // Creates a lock for your method
    ReentrantLock lock = new ReentrantLock();
    
    /*
    By putting synchronized keyword before a method, you make sure only one 
    thread at a time can execute it.
    synchronized keyword can be put also in block of code (see below)
    Synchronizing slows down Java, so it should only be used when necessary
    */
    @Override
    /* synchronized */ public void run() {
        
        System.out.println("id " + this.getId());
        System.out.println("priority " + this.getPriority());
        System.out.println("state " + Thread.currentThread().getState());
        System.out.println("name " + Thread.currentThread().getName());
        
        /*
        this locks/unlocks the method just like synchronized. You can't use
        synchronized and lock, that's why synchronized is commented out above
        */
        lock.lock();
        System.out.println("thread");
        lock.unlock();
        
        /*
        synchronized in parameter store variables 
        that should not be accessed simultaniously
        (this. for self object or randomVar for instance etc..)
        while synchonized executes
        */

        synchronized(brojevii){
            
            // wait for threads from other class to finish
            while (brojevii.size()>3){
            
                try {
                    // wait for resource
//                    brojevii.wait();
                    // or wait with max waiting time specified
                    brojevii.wait(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println("resenje je: " + brojevii.size());
        }
    }
}
