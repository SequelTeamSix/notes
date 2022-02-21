package threading;

import java.util.concurrent.*;

public class ThreadRunner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        BankAccount account = new BankAccount(500);

        ExtendThread t1 = new ExtendThread(1, 1000, account, 300);
        ExtendThread t2 = new ExtendThread(2, 1000, account, 200);

        /*there's a couple ways to run threads that rely on implementing runnable/callable
        one such way is with a thread pool -
        meaning that the 'template' for a thread is created at the start of the program
        and our thread implementations are submitted to it:
        this is better because the threads are not actually deleted when execution stops,
        they can be reused when new threads are submitted
        making this more efficient
         */
        ThreadImplementRunnable t3 = new ThreadImplementRunnable(3, 2000);
        ThreadImplementCallable t4 = new ThreadImplementCallable(4, 2500);
        ExecutorService es = Executors.newFixedThreadPool(2);
        /*
        a future is a container for an object that will exist in the future
        as a result of thread operation
         */
        Future<Integer> result;

        t1.start();
        t2.start();
        es.submit(t3);
        result = es.submit(t4);
        System.out.println("Hello from main!");
        //what is join?
        //wait for thread to finish execution
        t1.join();
        t2.join();
        /*get will also wait like join*/
        System.out.println(result.get());

        System.out.println("All threads finished!");
        System.out.println(account.getBalance());

        /*shutdown waits for all threads in the pool to finish*/
        es.shutdown();
        es.awaitTermination(100, TimeUnit.MILLISECONDS);
    }
}
/*
what is multithreading?
multiple instances of java program running asynchronously, potentially simultaneously
multithreading maintains the same heap as the thread that spawned a thread


why thread?
1. Perform operations while waiting for IO, from user, web, harddrive
    so that time is not wasted during these operations
2. Pretty much all computers have multiple cores these days - so, we can have multiple threads running
simultaneously to divide a problem and accomplish it faster
    HPC - let's say, for instance, we need to add 1 billion numbers together

In Java there's a couple ways to perform multithreading
    1. We can extend the thread class
    2. We can implement the runnable/callable interface

What if we have unpredictable behavior from threads due to their asynchronous nature?
If they're modifying data, they may modify it in unpredictable ways...
this is known as a race condition

Thread safety: something that is thread-safe is not affected by race conditions
(typically thread-safe solutions result in overhead/bottlenecks if using lots of threads,
but it's necessary)

Thread safety?
Only allow a single thread to perform sensitive code at once
OR:
some thread safe objects employ a buffer to allow threads to modify things simultaneously
(eg string builder vs string buffer)

Thread safety introduces a new problem as well..
because threads are waiting for other threads to complete certain operations, what if we enter
a situation where two threads are waiting for each other to complete?
this is called a DEADLOCK
no thread can complete - all we can do is kill the threads..
this is very bad and we want to avoid this-
The problem is, the only way to avoid it is to program such that the possibility of deadlock is impossible
so we need to be very careful when we are designing thread-safe applications

the thing about threading issues (race conditions, deadlocks) is that they are fundamentally
random and rare and that they can't be unit tested away
they rely on careful code if we're using shared resources (like our bank account in this example)

there's also livelocks; threads are in a loop of telling the other thread that a resource has been released
 */