package AdvancedJavaReview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedCustomerExample {
    public static void main(String[] args) throws InterruptedException {
/*        Threads: independent execution of code
            multiple threads can run concurrently
            What's it good for:

                good for large computations if we have multiple processors and can split
                the problem up

                or, for cases where, even with 1 processor, there is a lot of waiting/IO/network
                such that we can run other tasks while we wait for that to complete

                problems: later

            The first way to make a thread:
            extend thread class
            overwrite the run() method
            does running run() on an object that extends thread run a new thread?
            no, we need to call start(), which will call run() by itself
            does anyone actually use this anymore?
            no

          Better ways:
            using an executorservice, we have more control over threads
            with this method, we use objects that implement runnable and callable interfaces
            it's actually more efficient, because we can implement executorservice in such
            a way that we create a pool of reusable threads at startup rather than recreating
            threads
 */
        CustomerAccount account = new CustomerAccount(1, 500);

        ExecutorService es = Executors.newFixedThreadPool(2);

        CustomerPurchaseThread thread1 = new CustomerPurchaseThread(1, 500,
                100, account);
        CustomerPurchaseThread thread2 = new CustomerPurchaseThread(2, 500,
                200, account);

        es.submit(thread1);
        es.submit(thread2);

        es.shutdown();
        es.awaitTermination(100, TimeUnit.MILLISECONDS);

        Thread.sleep(1000);

        System.out.println("Customer "+account.getCustomerID() + " now has balance of " +
                account.getBalance());

        /*
        race condition: unpredictable behavior that results from not knowing what threads execute in what
        order or when they will be preempted (execution paused by processor
        after the thread has run enough)

         how do we solve this:
         we 'lock' sensitive code such that only a single thread can access certain code at a time
            in java: using the synchronized keyword on a method or synchronized block

         problems:
            when we introduce locking code,
            we may introduce a situation where two threads are waiting for each other to complete
            this is called a deadlock: neither thread may proceed because they are stuck waiting

         additional engineering cost
            To avoid problems related to unpredictability, we have to put in significant engineering
            effort to ensure that those problems do not occur: because race conditions and deadlocks
            are both fundamentally rare, difficult to reproduce events


         */




        /*
        how comes we can modify objects in a thread?
        each thread contains its own stack, but all threads share the heap

        stack:
            primitive variables
            callstack (the stack of called methods)

        heap:
            where objects in memory are stored
                (memory references point for objects to here)
            string pool

        garbage collection: something that java in particular is good at,
        objects which the jre knows will no longer be used can be removed from memory
            (meaning, we've lost the memory reference to it)

         */


    }
}
