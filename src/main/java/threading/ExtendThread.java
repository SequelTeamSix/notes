package threading;

public class ExtendThread extends Thread{
    int threadNum;
    int timeMillis;
    BankAccount acct;
    int amt;
    public ExtendThread(int threadNum, int timeMillis, BankAccount acct, int amt){
        this.threadNum=threadNum;
        this.timeMillis = timeMillis;
        this.acct = acct;
        this.amt = amt;
        /*thread constructor here*/
    }
    public void run(){

        /*why synchronized?
        Synchronized methods will only allow a single thread of this class to perform them at once
        this means that one thread will enter the synchronized block or method and this
        will *block* the further operation of any thread that reaches the point of the synchronized block
        until the thread occupying the block released control of synchronized
         */
        try {
            //thread.sleep just makes the thread wait (blocked)
            Thread.sleep(timeMillis);
            deposit();
            System.out.println("Hello from thread"+ threadNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void deposit(){
        acct.deposit(amt);
    }
}
